package dynamicprogramming.mindeltomakepalindrome;

public class MinDeletionToMakePalindromeRecursion {

  public static void main(String[] args) {
    String s1 = "agbcba";
    String s2 = new StringBuilder(s1).reverse().toString();
    int m = s1.length(), n = s2.length();
    int minLength = m - lps(s1, s2, m, n);
    System.out.println("The minimum deletion made in the string to make it palindromic is: "
        + minLength);
  }

  private static int lps(String s1, String s2, int m, int n) {
    if (m == 0) {
      return 0;
    }
    if (n == 0) {
      return 0;
    }
    if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
      return 1 + lps(s1, s2, m - 1, n - 1);
    } else {
      return Math.max(lps(s1, s2, m - 1, n), lps(s1, s2, m, n - 1));
    }
  }
}
