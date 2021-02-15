package dynamicprogramming.sequencepatternmatching;

public class SequencePatternMatchingBottomUp {

  public static void main(String[] args) {
    String x = "AXY";
    String y = "ADXCPY";

    int m = x.length(), n = y.length();
    int[][] t = new int[m + 1][n + 1];
    for (int i = 0; i < m + 1; i++) {
      for (int j = 0; j < n + 1; j++) {
        t[i][j] = 0;
      }
    }
    int lengthOfLCS = lcs(x, y, m, n, t);
    int len = x.length();
    System.out.println("Is the given sequence is a subsequence in the given string?: "
        + (lengthOfLCS == len));
  }

  private static int lcs(String x, String y, int m, int n, int[][] t) {
    for (int i = 1; i < m + 1; i++) {
      for (int j = 1; j < n + 1; j++) {
        if (x.charAt(i - 1) == y.charAt(j - 1)) {
          t[i][j] = t[i - 1][j - 1] + 1;
        } else {
          t[i][j] = Math.max(t[i][j - 1], t[i - 1][j]);
        }
      }
    }
    return t[m][n];
  }
}
