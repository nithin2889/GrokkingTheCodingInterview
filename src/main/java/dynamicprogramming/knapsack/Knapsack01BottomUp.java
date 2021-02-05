package dynamicprogramming.knapsack;

public class Knapsack01BottomUp {

  public static void main(String[] args) {
    int[] val = new int[]{160, 100, 120};
    int[] wt = new int[]{10, 20, 30};
    int w = 50;
    int n = val.length;

    System.out.println("Max profit obtained: " + knapsack(wt, val, w, n));
  }

  // Returns the maximum value that can be put in a knapsack of capacity w
  public static int knapsack(int[] wt, int[] val, int w, int n) {
    int[][] t = new int[n + 1][w + 1];

    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < w + 1; j++) {
        t[i][j] = 0;
      }
    }

    // Build table K[][] in bottom up manner
    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < w + 1; j++) {
        if (wt[i - 1] <= j) {
          t[i][j] = Math.max(val[i - 1] + t[i - 1][j - wt[i - 1]], t[i - 1][j]);
        } else {
          t[i][j] = t[i - 1][j];
        }
      }
    }
    return t[n][w];
  }
}
