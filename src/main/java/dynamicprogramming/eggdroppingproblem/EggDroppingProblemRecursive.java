package dynamicprogramming.eggdroppingproblem;

public class EggDroppingProblemRecursive {

  public static void main(String[] args) {
    int e = 3, f = 5;
    System.out.println("The minimum number of attempts needed to find the critical floor is: "
        + solve(e, f));
  }

  private static int solve(int e, int f) {
    if (f == 0 || f == 1) {
      return f;
    }
    if (e == 1) {
      return f;
    }
    int min = Integer.MAX_VALUE;
    for (int k = 1; k < f; k++) {
      int tempAns = 1 + Math.max(solve(e - 1, k - 1), solve(e, f - k));
      min = Math.min(min, tempAns);
    }
    return min;
  }
}
