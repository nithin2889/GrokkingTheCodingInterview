package dynamicprogramming.lcsubstring;

public class LCSubstringMemoization {

  public static void main(String[] args) {
    String X = "abcdxyz";
    String Y = "xyzabcd";

    int n = X.length();
    int m = Y.length();

    int[][] t = new int[n + 1][m + 1];
    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < m + 1; j++) {
        t[i][j] = -1;
      }
    }

    System.out.println("The length of longest common substring is: "
        + lcs(X, Y, n, m, t, 0));
  }

  private static int lcs(String x, String y, int n, int m, int[][] t, int count) {
    if (n == 0 || m == 0) {
      return 0;
    }
    if (t[n][m] != -1) {
      return t[n][m];
    }
    if (x.charAt(n - 1) == y.charAt(m - 1)) {
      t[n][m] = lcs(x, y, n - 1, m - 1, t, count + 1);
    } else {
      t[n][m] = Math.max(count, Math.max(lcs(x, y, n, m - 1, t, 0),
          lcs(x, y, n - 1, m, t, 0)));
    }
    return t[n][m];
  }
}
