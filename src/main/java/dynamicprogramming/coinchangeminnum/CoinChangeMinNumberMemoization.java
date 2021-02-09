package dynamicprogramming.coinchangeminnum;

public class CoinChangeMinNumberMemoization {

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
    if (sum == 0) {
      return 0;
    }
    if (t[n][sum] != 0) {
      return t[n][sum];
    }
    if (coins[n - 1] <= sum) {
      t[n][sum] = Math.min(count(coins, n, sum - coins[n - 1], t) + 1,
          count(coins, n - 1, sum, t));
    } else {
      t[n][sum] = count(coins, n - 1, sum, t);
    }
    return t[n][sum];
  }
}
