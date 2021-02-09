package dynamicprogramming.coinchangeminnum;

public class CoinChangeMinNumberRecursion {

  public static void main(String[] args) {
    int[] coins = {1, 2, 3};
    int n = coins.length;
    int sum = 5;
    System.out.println("Minimum number of coins needed to make a change is: "
        + count(coins, n, sum));
  }

  private static int count(int[] coins, int n, int sum) {
    if (sum > 0 && n <= 0) {
      return 0;
    }
    if (sum == 0) {
      return 1;
    }
    if (coins[n - 1] <= sum) {
      return Math.min(count(coins, n, sum - coins[n - 1]) + 1,
          count(coins, n - 1, sum));
    } else {
      return count(coins, n - 1, sum);
    }
  }
}
