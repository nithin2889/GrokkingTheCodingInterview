package dynamicprogramming;

public class Knapsack01Problem {

  public static void main(String[] args) {
    int[] val = new int[]{60, 100, 120};
    int[] wt = new int[]{10, 20, 30};
    int w = 50;
    int n = val.length;
    System.out.println("Max profit obtained: " + knapsack(wt, val, w, n));
  }

  public static int knapsack(int[] wt, int[] val, int w, int n) {
    // base condition
    if (w == 0 || n == 0) {
      return 0;
    }

    if (wt[n - 1] <= w) {
      // Return the maximum of two cases:
      // (1) nth item included
      // (2) not included
      return Math.max(val[n - 1] + knapsack(wt, val, w - wt[n - 1], n - 1),
          knapsack(wt, val, w, n - 1));
    } else {
      // If weight of the nth item is more than knapsack capacity W,
      // then this item cannot be included in the optimal solution.
      return knapsack(wt, val, w, n - 1);
    }
  }
}
