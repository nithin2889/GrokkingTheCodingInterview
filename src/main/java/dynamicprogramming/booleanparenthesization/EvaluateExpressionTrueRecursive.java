package dynamicprogramming.booleanparenthesization;

public class EvaluateExpressionTrueRecursive {

  public static void main(String[] args) {
    String s = "T^F&T";
    int i = 0, j = s.length() - 1;

    System.out.println("Number of ways to make the expression true are: "
        + evaluate(s, i, j, true));
  }

  private static int evaluate(String s, int i, int j, boolean isTrue) {
    if (i > j) {
      return 0;
    }
    if (i == j) {
      if (isTrue) {
        return s.charAt(i) == 'T' ? 1 : 0;
      } else {
        return s.charAt(i) == 'F' ? 1 : 0;
      }
    }
    int ans = 0;
    for (int k = i + 1; k <= j - 1; k += 2) {
      int leftTrue = evaluate(s, i, k - 1, true);
      int leftFalse = evaluate(s, i, k - 1, false);
      int rightTrue = evaluate(s, k + 1, j, true);
      int rightFalse = evaluate(s, k + 1, j, false);

      if (s.charAt(k) == '&') {
        if (isTrue) {
          ans += leftTrue * rightTrue;
        } else {
          ans += leftTrue * rightFalse + leftFalse * rightTrue + leftFalse * rightFalse;
        }
      } else if (s.charAt(k) == '|') {
        if (isTrue) {
          ans += leftTrue * rightFalse + leftFalse * rightTrue + leftTrue * rightTrue;
        } else {
          ans += leftFalse * rightFalse;
        }
      } else if (s.charAt(k) == '^') {
        if (isTrue) {
          ans += leftTrue * rightFalse + leftFalse * rightTrue;
        } else {
          ans += leftTrue * rightTrue + leftFalse * rightFalse;
        }
      }
    }
    return ans;
  }
}
