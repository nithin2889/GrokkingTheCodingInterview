package dynamicprogramming.minsubsetsum;

public class MinSubsetSumDifferenceMemoization {

  public static void main(String[] args) {
    int[] arr = {1, 6, 11, 5};
    int n = arr.length;
    int calculatedSum = 0, totalSum = 0;

    for (int i : arr) {
      totalSum += i;
    }

    int[][] t = new int[n + 1][totalSum + 1];

    System.out.println("The minimum difference between two sets is: "
        + minSubsetSumDiff(arr, n, calculatedSum, totalSum, t));
  }

  private static int minSubsetSumDiff(int[] arr, int n, int calculatedSum, int totalSum,
      int[][] t) {
    if (n == 0) {
      return t[n][totalSum] = Math.abs((totalSum - calculatedSum) - calculatedSum);
    }

    return t[n][totalSum] = Math
        .min(minSubsetSumDiff(arr, n - 1, calculatedSum + arr[n - 1], totalSum, t),
            minSubsetSumDiff(arr, n - 1, calculatedSum, totalSum, t));
  }
}
