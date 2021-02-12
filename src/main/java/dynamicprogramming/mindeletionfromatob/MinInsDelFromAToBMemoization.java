package dynamicprogramming.mindeletionfromatob;

public class MinInsDelFromAToBMemoization {

  public static void main(String[] args) {
    String s1 = "heap";
    String s2 = "pea";
    int m = s1.length(), n = s2.length();

    int[][] t = new int[m + 1][n + 1];
    for (int i = 0; i < m + 1; i++) {
      for (int j = 0; j < n + 1; j++) {
        t[i][j] = -1;
      }
    }
    int minDeletion = m - lcs(s1, s2, m, n, t);
    int minInsertion = n - lcs(s1, s2, m, n, t);
    System.out.println("Min deletions is: " + minDeletion);
    System.out.println("Min insertions is: " + minInsertion);
  }

  private static int lcs(String s1, String s2, int m, int n, int[][] t) {
    if (m == 0) {
      return 0;
    }
    if (n == 0) {
      return 0;
    }
    if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
      t[m][n] = lcs(s1, s2, m - 1, n - 1, t) + 1;
    } else {
      t[m][n] = Math.max(lcs(s1, s2, m, n - 1, t), lcs(s1, s2, m - 1, n, t));
    }
    return t[m][n];
  }
}
