package dynamicprogramming.eggdroppingproblem;

public class EggDroppingProblemMemoization {

  public static void main(String[] args) {
    int e = 3, f = 5;
    int[][] t = new int[f + 1][f + 1];
    for (int i = 0; i < e + 1; i++) {
      for (int j = 0; j < f + 1; j++) {
        t[i][j] = -1;
      }
    }
    System.out.println("The minimum number of attempts needed to find the critical floor is: "
        + solve(e, f, t));
  }

  private static int solve(int e, int f, int[][] t) {
    if (f == 0 || f == 1) {
      return f;
    }
    if (e == 1) {
      return f;
    }
    if (t[e][f] != -1) {
      return t[e][f];
    }
    int min = Integer.MAX_VALUE;
    for (int k = 1; k < f; k++) {
      int tempAns = 1 + Math.max(solve(e - 1, k - 1, t), solve(e, f - k, t));
      min = Math.min(min, tempAns);
    }
    return t[e][f] = min;
  }
}
