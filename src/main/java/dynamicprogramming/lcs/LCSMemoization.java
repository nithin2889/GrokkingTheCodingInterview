package dynamicprogramming.lcs;

public class LCSMemoization {

  public static void main(String[] args) {
    String x = "AGGTAB";
    String y = "GXTXAYB";

    int n = x.length(), m = y.length();
    int[][] t = new int[n + 1][m + 1];
    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < m + 1; j++) {
        t[i][j] = -1;
      }
    }
    System.out.println("The max length of common subsequence is: "
        + lcs(x, y, n, m, t));
  }

  private static int lcs(String x, String y, int n, int m, int[][] t) {
    if (n == 0 || m == 0) {
      return 0;
    }
    if (t[n][m] != -1) {
      return t[n][m];
    }
    if (x.charAt(n - 1) == y.charAt(m - 1)) {
      t[n][m] = lcs(x, y, n - 1, m - 1, t) + 1;
    } else {
      t[n][m] = Math.max(lcs(x, y, n, m - 1, t), lcs(x, y, n - 1, m, t));
    }
    return t[n][m];
  }
}
