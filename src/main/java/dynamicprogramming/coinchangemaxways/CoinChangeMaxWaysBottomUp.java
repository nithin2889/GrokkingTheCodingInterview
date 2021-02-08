package dynamicprogramming.coinchangemaxways;

public class CoinChangeMaxWaysBottomUp {

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
    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < sum + 1; j++) {
        if (coin[i - 1] <= j) {
          t[i][j] = count(coin, i, sum - coin[i - 1], t)
              + count(coin, i - 1, sum, t);
        } else {
          t[i][j] = count(coin, i - 1, sum, t);
        }
      }
    }
    return t[n][sum];
  }
}
