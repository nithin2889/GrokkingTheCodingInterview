package dynamicprogramming.coinchangemaxways;

public class CoinChangeMaxWaysMemoization {

  public static void main(String[] args) {
    int[] coin = {1, 2, 3};
    int n = coin.length;
    int sum = 4;
    int t[][] = new int[n + 1][sum + 1];
    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < sum + 1; j++) {
        if (i == 0) {
          t[i][j] = 0;
        }
        if (j == 0) {
          t[i][j] = 1;
        }
      }
    }
    System.out.println("Number of ways we can make a change is: "
        + count(coin, n, sum, t));
  }

  private static int count(int[] coin, int n, int sum, int[][] t) {
    if (n <= 0) {
      return 0;
    }
    if (sum == 0) {
      return 1;
    }
    if (t[n][sum] != 0) {
      return t[n][sum];
    }

    if (coin[n - 1] <= sum) {
      t[n][sum] = count(coin, n, sum - coin[n - 1], t) + count(coin, n - 1, sum, t);
    } else {
      t[n][sum] = count(coin, n - 1, sum, t);
    }
    return t[n][sum];
  }
}
