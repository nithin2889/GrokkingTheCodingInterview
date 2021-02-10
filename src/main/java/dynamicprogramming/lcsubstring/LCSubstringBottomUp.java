package dynamicprogramming.lcsubstring;

public class LCSubstringBottomUp {

  public static void main(String[] args) {
    String X = "abcdexyz";
    String Y = "xyzabcde";

    int n = X.length();
    int m = Y.length();

    int[][] t = new int[n + 1][m + 1];
    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < m + 1; j++) {
        if (i == 0 || j == 0) {
          t[i][j] = 0;
        }
      }
    }

    System.out.println("The length of longest common substring is: "
        + lcs(X, Y, n, m, t, 0));
  }

  private static int lcs(String x, String y, int n, int m, int[][] t, int count) {
    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < m + 1; j++) {
        if (x.charAt(i - 1) == y.charAt(j - 1)) {
          t[i][j] = t[i - 1][j - 1] + 1;
          if (t[i][j] > count) {
            count = t[i][j];
          }
        } else {
          t[i][j] = 0;
        }
      }
    }
    return count;
  }
}
