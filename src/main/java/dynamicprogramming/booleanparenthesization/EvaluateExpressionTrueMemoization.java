package dynamicprogramming.booleanparenthesization;

import java.util.Arrays;

public class EvaluateExpressionTrueMemoization {

  public static void main(String[] args) {
    String s = "T&F|T^F";
    int n = s.length();
    int i = 0, j = n - 1;

    int[][][] t = new int[n + 1][n + 1][2];
    for (int[][] row : t) {
      for (int[] col : row) {
        Arrays.fill(col, -1);
      }
    }

    System.out.println("Number of ways to make the expression true are: "
        + evaluate(s, i, j, 1, t));
  }

  private static int evaluate(String s, int i, int j, int isTrue, int[][][] t) {
    if (i > j) {
      return 0;
    }
    if (i == j) {
      if (isTrue == 1) {
        return (s.charAt(i) == 'T') ? 1 : 0;
      } else {
        return (s.charAt(i) == 'F') ? 1 : 0;
      }
    }
    if (t[i][j][isTrue] != -1) {
      return t[i][j][isTrue];
    }
    int count = 0;
    int leftTrue, leftFalse, rightTrue, rightFalse;
    for (int k = i + 1; k <= j - 1; k += 2) {
      if (t[i][k - 1][1] != -1) {
        leftTrue = t[i][k - 1][1];
      } else {
        leftTrue = evaluate(s, i, k - 1, 1, t);
      }

      if (t[i][k - 1][0] != -1) {
        leftFalse = t[i][k - 1][0];
      } else {
        leftFalse = evaluate(s, i, k - 1, 0, t);
      }

      if (t[k + 1][j][1] != -1) {
        rightTrue = t[k + 1][j][1];
      } else {
        rightTrue = evaluate(s, k + 1, j, 1, t);
      }

      if (t[k + 1][j][0] != -1) {
        rightFalse = t[k + 1][j][0];
      } else {
        rightFalse = evaluate(s, k + 1, j, 0, t);
      }

      if (s.charAt(k) == '&') {
        if (isTrue == 1) {
          count += leftTrue * rightTrue;
        } else {
          count += leftTrue * rightFalse + leftFalse * rightTrue + leftFalse * rightFalse;
        }
      } else if (s.charAt(k) == '|') {
        if (isTrue == 1) {
          count += leftTrue * rightFalse + leftFalse * rightTrue + leftTrue * rightTrue;
        } else {
          count += leftFalse * rightFalse;
        }
      } else if (s.charAt(k) == '^') {
        if (isTrue == 1) {
          count += leftTrue * rightFalse + leftFalse * rightTrue;
        } else {
          count += leftTrue * rightTrue;
        }
      }
      t[i][j][isTrue] = count;
    }
    return count;
  }
}
