package dynamicprogramming.printlcsubsequence;

public class LCSubsequencePrintBottomUp {

  public static void main(String[] args) {
    String x = "acbcf";
    String y = "abcdaf";

    int n = x.length();
    int m = y.length();

    int[][] t = new int[n + 1][m + 1];
    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < m + 1; j++) {
        if (i == 0 || j == 0) {
          t[i][j] = 0;
        }
      }
    }

    System.out.println("The longest common subsequence is: "
        + lcs(x, y, n, m, t));
  }

  private static String lcs(String x, String y, int n, int m, int[][] t) {
    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < m + 1; j++) {
        if (x.charAt(n - 1) == y.charAt(m - 1)) {
          t[i][j] = t[i - 1][j - 1] + 1;
        } else {
          t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
        }
      }
    }

    int i = n, j = m;
    StringBuilder res = new StringBuilder();

    while (i > 0 && j > 0) {
      if (x.charAt(i - 1) == y.charAt(j - 1)) {
        res.append(x.charAt(i - 1));
        i--;
        j--;
      } else {
        if (t[i - 1][j] > t[i][j - 1]) {
          i--;
        } else {
          j--;
        }
      }
    }
    return res.reverse().toString();
  }
}
