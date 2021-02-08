package dynamicprogramming.coinchangemaxways;

public class CoinChangeMaxWaysRecursion {

  public static void main(String[] args) {
    int[] coin = {1, 2, 3};
    int n = coin.length;
    System.out.println("Number of ways we can make a change is: "
        + count(coin, n, 4));
  }

  private static int count(int[] coin, int n, int sum) {
    if (n <= 0) {
      return 0;
    }

    if (sum == 0) {
      return 1;
    }

    if (coin[n - 1] <= sum) {
      return count(coin, n, sum - coin[n - 1]) + count(coin, n - 1, sum);
    } else {
      return count(coin, n - 1, sum);
    }
  }
}
