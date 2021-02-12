package dynamicprogramming.lpsubsequence;

public class LongestPalindromicSubsequenceMemoization {

  public static void main(String[] args) {
    String s1 = "agbcba";
    String s2 = new StringBuilder(s1).reverse().toString();
    int m = s1.length(), n = s2.length();
    int[][] t = new int[m + 1][n + 1];
    for (int i = 0; i < m + 1; i++) {
      for (int j = 0; j < n + 1; j++) {
        t[i][j] = -1;
      }
    }
    System.out.println("The longest palindromic subsequence is: " + lps(s1, s2, m, n, t));
  }

  private static int lps(String s1, String s2, int m, int n, int[][] t) {
    if (m == 0) {
      return 0;
    }
    if (n == 0) {
      return 0;
    }
    if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
      t[m][n] = 1 + lps(s1, s2, m - 1, n - 1, t);
    } else {
      t[m][n] = Math.max(lps(s1, s2, m - 1, n, t), lps(s1, s2, m, n - 1, t));
    }
    return t[m][n];
  }
}
