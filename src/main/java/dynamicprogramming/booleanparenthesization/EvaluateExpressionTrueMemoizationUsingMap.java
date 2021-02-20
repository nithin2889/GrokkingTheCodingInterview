package dynamicprogramming.booleanparenthesization;

import java.util.HashMap;
import java.util.Map;

public class EvaluateExpressionTrueMemoizationUsingMap {

  public static void main(String[] args) {
    String s = "T&F|T^F";
    int n = s.length();
    int i = 0, j = n - 1;

    Map<String, Integer> map = new HashMap<>();
    System.out.println("Number of ways to make the expression true are: "
        + evaluate(s, i, j, true, map));
  }

  private static int evaluate(String s, int i, int j, boolean isTrue, Map<String, Integer> map) {
    if (i > j) {
      return 0;
    }
    if (i == j) {
      if (isTrue) {
        return (s.charAt(i) == 'T') ? 1 : 0;
      } else {
        return (s.charAt(i) == 'F') ? 1 : 0;
      }
    }
    String tempKey = i + " " + j + " " + isTrue;
    if (map.containsKey(tempKey)) {
      return map.get(tempKey);
    }
    int count = 0;
    int leftTrue, leftFalse, rightTrue, rightFalse;
    for (int k = i + 1; k <= j - 1; k += 2) {
      leftTrue = evaluate(s, i, k - 1, true, map);
      leftFalse = evaluate(s, i, k - 1, false, map);
      rightTrue = evaluate(s, k + 1, j, true, map);
      rightFalse = evaluate(s, k + 1, j, false, map);

      if (s.charAt(k) == '&') {
        if (isTrue) {
          count += leftTrue * rightTrue;
        } else {
          count += leftTrue * rightFalse + leftFalse * rightTrue + leftFalse * rightFalse;
        }
      } else if (s.charAt(k) == '|') {
        if (isTrue) {
          count += leftTrue * rightFalse + leftFalse * rightTrue + leftTrue * rightTrue;
        } else {
          count += leftFalse * rightFalse;
        }
      } else if (s.charAt(k) == '^') {
        if (isTrue) {
          count += leftTrue * rightFalse + leftFalse * rightTrue;
        } else {
          count += leftTrue * rightTrue;
        }
      }
      map.put(i + " " + j + " " + isTrue, count);
    }
    return count;
  }
}
