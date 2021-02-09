package dynamicprogramming.coinchangeminnum;

public class CoinChangeMinNumberBottomUp {

  public static void main(String[] args) {
    int[] coins = {1, 2, 3};
    int n = coins.length;
    int sum = 5;

    int[][] t = new int[n + 1][sum + 1];
    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < sum + 1; j++) {
        if (i == 0) {
          t[i][j] = Integer.MAX_VALUE - 1;
        }
        if (j == 0) {
          t[i][j] = 0;
        }
      }
    }
    System.out.println("Minimum number of coins needed to make a change is: "
        + count(coins, n, sum, t));
  }

  private static int count(int[] coins, int n, int sum, int[][] t) {
    for (int j = 1; j < sum + 1; j++) {
      if ((j % coins[0]) == 0) {
        t[1][j] = j / coins[0];
      } else {
        t[1][j] = Integer.MAX_VALUE - 1;
      }
    }

    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < sum + 1; j++) {
        if (coins[i - 1] <= j) {
          t[i][j] = Math.min(t[i][j - coins[i - 1]] + 1, t[i - 1][j]);
        } else {
          t[i][j] = t[i - 1][j];
        }
      }
    }
    return t[n][sum];
  }
}
