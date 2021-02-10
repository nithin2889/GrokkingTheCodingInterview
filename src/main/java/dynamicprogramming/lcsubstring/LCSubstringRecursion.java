package dynamicprogramming.lcsubstring;

public class LCSubstringRecursion {

  public static void main(String[] args) {
    int n, m;
    String X = "abcdexyz";
    String Y = "xyzabcde";

    n = X.length();
    m = Y.length();

    System.out.println("The length of longest common substring is: "
        + lcs(X, Y, n, m, 0));
  }

  private static int lcs(String X, String Y, int n, int m, int count) {
    if (m == 0 || n == 0) {
      return 0;
    }
    if (X.charAt(m - 1) == Y.charAt(n - 1)) {
      return 1 + lcs(X, Y, n - 1, m - 1, count + 1);
    } else {
      return Math.max(count, Math.max(lcs(X, Y, n, m - 1, 0),
          lcs(X, Y, n - 1, m, 0)));
    }
  }
}
