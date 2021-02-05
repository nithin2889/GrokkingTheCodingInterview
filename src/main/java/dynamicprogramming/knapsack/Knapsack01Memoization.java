package dynamicprogramming.knapsack;

import java.util.Arrays;

public class Knapsack01Memoization {

  public static void main(String[] args) {
    int[] val = new int[]{160, 100, 120};
    int[] wt = new int[]{10, 20, 30};
    int w = 50;
    int n = val.length;

    // Declare the table dynamically
    int[][] t = new int[n + 1][w + 1];
    // fill the table initially with -1
    for (int[] v : t) {
      Arrays.fill(v, -1);
    }

    System.out.println("Max profit obtained: " + knapsack(wt, val, w, n, t));
  }

  public static int knapsack(int[] wt, int[] val, int w, int n, int[][] t) {
    if (n == 0 || w == 0) {
      return 0;
    }

    // check for valid value in the table.
    if (t[n][w] != -1) {
      return t[n][w];
    }

    if (wt[n - 1] <= w) {
      // Return value of table after storing
      t[n][w] = Math.max(val[n - 1] + knapsack(wt, val, w - wt[n - 1], n - 1, t),
          knapsack(wt, val, w, n - 1, t));
    } else {
      // Store the value of function call stack in table before return
      t[n][w] = knapsack(wt, val, w, n - 1, t);
    }
    return t[n][w];
  }
}
