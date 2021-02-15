package dynamicprogramming.sequencepatternmatching;

public class SequencePatternMatchingMemoization {

  public static void main(String[] args) {
    String x = "AXY";
    String y = "ADXCPY";

    int m = x.length(), n = y.length();
    int[][] t = new int[m + 1][n + 1];
    for (int i = 0; i < m + 1; i++) {
      for (int j = 0; j < n + 1; j++) {
        t[i][j] = -1;
      }
    }
    int lengthOfLCS = lcs(x, y, m, n, t);
    int len = x.length();
    System.out.println("Is the given sequence is a subsequence in the given string?: "
        + (lengthOfLCS == len));
  }

  private static int lcs(String x, String y, int m, int n, int[][] t) {
    if (m == 0 || n == 0) {
      return 0;
    }
    if (t[m][n] != -1) {
      return t[m][n];
    }
    if (x.charAt(m - 1) == y.charAt(n - 1)) {
      t[m][n] = 1 + lcs(x, y, m - 1, n - 1, t);
    } else {
      t[m][n] = Math.max(lcs(x, y, m, n - 1, t), lcs(x, y, m - 1, n, t));
    }
    return t[m][n];
  }
}
