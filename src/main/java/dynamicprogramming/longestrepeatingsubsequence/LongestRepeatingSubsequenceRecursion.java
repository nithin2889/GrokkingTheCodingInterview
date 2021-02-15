package dynamicprogramming.longestrepeatingsubsequence;

public class LongestRepeatingSubsequenceRecursion {

  public static void main(String[] args) {
    String s1 = "AABEBCDD";
    String s2 = s1;

    int m = s1.length(), n = s2.length();
    System.out.println("Length of longest repeating subsequence is: "
        + lcs(s1, s2, m, n));
  }

  private static int lcs(String s1, String s2, int m, int n) {
    if (m == 0 || n == 0) {
      return 0;
    }
    if (s1.charAt(m - 1) == s2.charAt(n - 1) && m != n) {
      return 1 + lcs(s1, s2, m - 1, n - 1);
    } else {
      return Math.max(lcs(s1, s2, m, n - 1), lcs(s1, s2, m - 1, n));
    }
  }
}
