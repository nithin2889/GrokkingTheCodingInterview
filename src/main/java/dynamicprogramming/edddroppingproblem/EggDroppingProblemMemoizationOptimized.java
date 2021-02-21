package dynamicprogramming.edddroppingproblem;

public class EggDroppingProblemMemoizationOptimized {

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
    int upperFloors, lowerFloors;
    
    for (int k = 1; k < f; k++) {
      if (t[e][f - k] != -1) {
        upperFloors = t[e][f - k];
      } else {
        upperFloors = solve(e, f - k, t);
        t[e][f - k] = upperFloors;
      }

      if (t[e - 1][k - 1] != -1) {
        lowerFloors = t[e - 1][k - 1];
      } else {
        lowerFloors = solve(e - 1, k - 1, t);
        t[e - 1][k - 1] = lowerFloors;
      }
      int tempAns = 1 + Math.max(upperFloors, lowerFloors);
      min = Math.min(min, tempAns);
    }
    return t[e][f] = min;
  }
}
