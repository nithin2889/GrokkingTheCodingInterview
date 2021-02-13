package dynamicprogramming.printscsupersequence;

public class PrintSCSuperSequenceBottomUp {

  public static void main(String[] args) {
    String x = "acbcf";
    String y = "abcdaf";

    int m = x.length();
    int n = y.length();

    int[][] t = new int[m + 1][n + 1];
    for (int i = 0; i < m + 1; i++) {
      for (int j = 0; j < n + 1; j++) {
        if (i == 0 || j == 0) {
          t[i][j] = 0;
        }
      }
    }

    System.out.println("The shortest common super sequence is: "
        + lcs(x, y, m, n, t));
  }

  private static String lcs(String x, String y, int m, int n, int[][] t) {
    // find the longest common subsequence (LCS)
    for (int i = 1; i < m + 1; i++) {
      for (int j = 1; j < n + 1; j++) {
        if (x.charAt(m - 1) == y.charAt(n - 1)) {
          t[i][j] = t[i - 1][j - 1] + 1;
        } else {
          t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
        }
      }
    }

    int i = m, j = n;
    StringBuilder res = new StringBuilder();

    // starting from the last element of the last column,
    // appending to resultant string.
    while (i > 0 && j > 0) {
      if (x.charAt(i - 1) == y.charAt(j - 1)) {
        res.append(x.charAt(i - 1));
        i--;
        j--;
      } else if (t[i - 1][j] > t[i][j - 1]) {
        res.append(x.charAt(i - 1));
        i--;
      } else {
        res.append(y.charAt(j - 1));
        j--;
      }
    }

    // if one string length is not yet 0, run the loop and add them.
    while (i > 0) {
      res.append(x.charAt(i - 1));
      i--;
    }

    // if one string length is not yet 0, run the loop and add them.
    while (j > 0) {
      res.append(y.charAt(j - 1));
      j--;
    }
    // reverse the final string and return
    return res.reverse().toString();
  }
}
