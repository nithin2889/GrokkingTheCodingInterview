package dynamicprogramming.rodcutting;

public class RodCuttingBottomUp {

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
        t[i][j] = 0;
      }
    }
    System.out.println("Maximum Obtainable Value is " +
        cutRod(length, price, maxRodLen, n, t));
  }

  public static int cutRod(int[] length, int[] price, int maxRodLen, int n, int[][] t) {
    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < maxRodLen + 1; j++) {
        if (length[i - 1] <= j) {
          t[i][j] = Math
              .max(price[i - 1] + cutRod(length, price, j - length[i - 1], i, t),
                  cutRod(length, price, j, i - 1, t));
        } else {
          t[i][j] = cutRod(length, price, j, i - 1, t);
        }
      }
    }
    return t[n][maxRodLen];
  }
}
