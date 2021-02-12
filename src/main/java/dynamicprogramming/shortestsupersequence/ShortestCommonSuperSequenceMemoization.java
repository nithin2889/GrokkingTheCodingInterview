package dynamicprogramming.shortestsupersequence;

public class ShortestCommonSuperSequenceMemoization {

  public static void main(String[] args) {
    String s1 = "AGGTAB", s2 = "GXTXAYB";
    int m = s1.length(), n = s2.length();
    int inputStrLength = m + n;
    int[][] t = new int[m + 1][n + 1];
    for (int i = 0; i < m + 1; i++) {
      for (int j = 0; j < n + 1; j++) {
        t[i][j] = -1;
      }
    }
    int lcsLength = inputStrLength - superSeqCount(s1, s2, m, n, t);
    System.out.println("The length of the shortest super sequence is: "
        + lcsLength);
  }

  private static int superSeqCount(String s1, String s2, int m, int n, int[][] t) {
    if (m == 0) {
      return 0;
    }
    if (n == 0) {
      return 0;
    }
    if (t[m][n] != -1) {
      return t[m][n];
    }
    if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
      t[m][n] = 1 + superSeqCount(s1, s2, m - 1, n - 1, t);
    } else {
      t[m][n] = Math.max(superSeqCount(s1, s2, m - 1, n, t),
          superSeqCount(s1, s2, m, n - 1, t));
    }
    return t[m][n];
  }
}
