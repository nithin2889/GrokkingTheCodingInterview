package dynamicprogramming.shortestsupersequence;

public class ShortestCommonSuperSequenceRecursion {

  public static void main(String[] args) {
    String s1 = "AGGTAB", s2 = "GXTXAYB";
    int m = s1.length(), n = s2.length();
    System.out.println("The length of the shortest super sequence is: "
        + superSeqCount(s1, s2, m, n));
  }

  private static int superSeqCount(String s1, String s2, int m, int n) {
    if (m == 0) {
      return n;
    }
    if (n == 0) {
      return m;
    }
    if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
      return 1 + superSeqCount(s1, s2, m - 1, n - 1);
    } else {
      return 1 + Math.min(superSeqCount(s1, s2, m - 1, n),
          superSeqCount(s1, s2, m, n - 1));
    }
  }
}
