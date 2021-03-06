package dynamicprogramming.mindeletionfromatob;

public class MinInsDelFromAToBBottomUp {

  public static void main(String[] args) {
    String s1 = "heap";
    String s2 = "pea";
    int m = s1.length(), n = s2.length();

    int[][] t = new int[m + 1][n + 1];
    for (int i = 0; i < m + 1; i++) {
      for (int j = 0; j < n + 1; j++) {
        if (i == 0) {
          t[i][j] = 0;
        }
        if (j == 0) {
          t[i][j] = 0;
        }
      }
    }
    int minDeletion = m - lcs(s1, s2, m, n, t);
    int minInsertion = n - lcs(s1, s2, m, n, t);
    System.out.println("Min deletions is: " + minDeletion);
    System.out.println("Min insertions is: " + minInsertion);
  }

  private static int lcs(String s1, String s2, int m, int n, int[][] t) {
    for (int i = 1; i < m + 1; i++) {
      for (int j = 1; j < n + 1; j++) {
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
          t[i][j] = t[i - 1][j - 1] + 1;
        } else {
          t[i][j] = Math.max(t[i][j - 1], t[i - 1][j]);
        }
      }
    }
    return t[m][n];
  }
}
