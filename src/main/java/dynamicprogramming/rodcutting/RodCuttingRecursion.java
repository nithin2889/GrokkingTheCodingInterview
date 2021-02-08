package dynamicprogramming.rodcutting;

public class RodCuttingRecursion {

  public static void main(String[] args) {
    int[] price = new int[]{1, 5, 8, 9, 10, 17, 17, 20};
    int n = price.length;
    int[] length = new int[n];
    for (int i = 0; i < n; i++) {
      length[i] = i + 1;
    }
    int maxRodLen = n;
    System.out.println("Maximum Obtainable Value is " +
        cutRod(length, price, maxRodLen, n));
  }

  public static int cutRod(int[] length, int[] price, int maxRodLen, int n) {
    if (n <= 0) {
      return 0;
    }

    if (length[n - 1] <= maxRodLen) {
      return Math
          .max(price[n - 1] + cutRod(length, price, maxRodLen - length[n - 1], n),
              cutRod(length, price, maxRodLen, n - 1));
    } else {
      return cutRod(length, price, maxRodLen, n - 1);
    }
  }
}
