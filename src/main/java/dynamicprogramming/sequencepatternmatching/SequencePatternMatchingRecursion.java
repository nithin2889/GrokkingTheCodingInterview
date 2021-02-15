package dynamicprogramming.sequencepatternmatching;

public class SequencePatternMatchingRecursion {

  public static void main(String[] args) {
    String x = "AXY";
    String y = "ADXCPY";

    int m = x.length(), n = y.length();
    int lengthOfLCS = lcs(x, y, m, n);
    int len = x.length();
    System.out.println("Is the given sequence is a subsequence in the given string?: "
        + (lengthOfLCS == len));
  }

  private static int lcs(String x, String y, int m, int n) {
    if (m == 0 || n == 0) {
      return 0;
    }
    if (x.charAt(m - 1) == y.charAt(n - 1)) {
      return 1 + lcs(x, y, m - 1, n - 1);
    } else {
      return Math.max(lcs(x, y, m, n - 1), lcs(x, y, m - 1, n));
    }
  }
}
