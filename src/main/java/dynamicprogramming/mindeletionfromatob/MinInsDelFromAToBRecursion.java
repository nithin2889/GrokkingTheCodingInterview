package dynamicprogramming.mindeletionfromatob;

public class MinInsDelFromAToBRecursion {

  public static void main(String[] args) {
    String s1 = "heap";
    String s2 = "pea";
    int m = s1.length(), n = s2.length();
    int minDeletion = m - lcs(s1, s2, m, n);
    int minInsertion = n - lcs(s1, s2, m, n);
    System.out.println("Min deletions is: " + minDeletion);
    System.out.println("Min insertions is: " + minInsertion);
  }

  private static int lcs(String s1, String s2, int m, int n) {
    if (m == 0) {
      return 0;
    }
    if (n == 0) {
      return 0;
    }
    if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
      return lcs(s1, s2, m - 1, n - 1) + 1;
    } else {
      return Math.max(lcs(s1, s2, m, n - 1), lcs(s1, s2, m - 1, n));
    }
  }
}
