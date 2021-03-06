package dynamicprogramming.rodcutting;

public class RodCuttingMemoization {

  public static void main(String[] args) {
    int[] price = new int[]{1, 5, 8, 9, 10, 17, 17, 20};
    int n = price.length;
    int[] length = new int[n];
    for (int i = 0; i < n; i++) {
      length[i] = i + 1;
    }
    int maxRodLen = n;

    int[][] t = new int[n + 1][maxRodLen + 1];
    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < maxRodLen + 1; j++) {
        if (i == 0) {
          t[i][j] = 0;
        }
        if (j == 0) {
          t[i][j] = 0;
        }
      }
    }

    System.out.println("Maximum Obtainable Value is " +
        cutRod(length, price, maxRodLen, n, t));
  }

  public static int cutRod(int[] length, int[] price, int maxRodLen, int n, int[][] t) {
    if (n == 0 || maxRodLen == 0) {
      return 0;
    }

    if (length[n - 1] <= maxRodLen) {
      t[n][maxRodLen] = Math
          .max(price[n - 1] + cutRod(length, price, maxRodLen - length[n - 1], n, t),
              cutRod(length, price, maxRodLen, n - 1, t));
    } else {
      t[n][maxRodLen] = cutRod(length, price, maxRodLen, n - 1, t);
    }
    return t[n][maxRodLen];
  }
}
