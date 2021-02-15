package dynamicprogramming.longestrepeatingsubsequence;

public class LongestRepeatingSubsequenceMemoization {

  public static void main(String[] args) {
    String s1 = "AABEBCDD";
    String s2 = s1;

    int m = s1.length(), n = s2.length();
    int[][] t = new int[m + 1][n + 1];
    for (int i = 0; i < m + 1; i++) {
      for (int j = 0; j < n + 1; j++) {
        t[i][j] = -1;
      }
    }
    System.out.println("Length of longest repeating subsequence is: "
        + lcs(s1, s2, m, n, t));
  }

  private static int lcs(String s1, String s2, int m, int n, int[][] t) {
    if (m == 0 || n == 0) {
      return 0;
    }
    if (t[m][n] != -1) {
      return t[m][n];
    }
    if (s1.charAt(m - 1) == s2.charAt(n - 1) && m != n) {
      t[m][n] = 1 + lcs(s1, s2, m - 1, n - 1, t);
    } else {
      t[m][n] = Math.max(lcs(s1, s2, m, n - 1, t), lcs(s1, s2, m - 1, n, t));
    }
    return t[m][n];
  }
}
