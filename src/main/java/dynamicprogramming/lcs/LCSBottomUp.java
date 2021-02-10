package dynamicprogramming.lcs;

public class LCSBottomUp {

  public static void main(String[] args) {
    String x = "AGGTAB";
    String y = "GXTXAYB";

    int n = x.length(), m = y.length();
    int[][] t = new int[n + 1][m + 1];
    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < m + 1; j++) {
        if (i == 0 || j == 0) {
          t[i][j] = 0;
        }
      }
    }
    System.out.println("The max length of common subsequence is: "
        + lcs(x, y, n, m, t));
  }

  private static int lcs(String x, String y, int n, int m, int[][] t) {
    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < m + 1; j++) {
        if (x.charAt(i - 1) == y.charAt(j - 1)) {
          t[i][j] = t[i - 1][j - 1] + 1;
        } else {
          t[i][j] = Math.max(t[i][j - 1], t[i - 1][j]);
        }
      }
    }
    return t[n][m];
  }
}
