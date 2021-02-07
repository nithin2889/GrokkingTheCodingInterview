package dynamicprogramming.minsubsetsum;

public class MinSubsetSumDifferentRecursion {

  public static void main(String[] args) {
    int[] arr = {1, 6, 11, 5};
    int n = arr.length;
    int calculatedSum = 0, totalSum = 0;

    for (int i : arr) {
      totalSum += i;
    }

    System.out.println("The minimum difference between two sets is: "
        + minSubsetSumDiff(arr, n, calculatedSum, totalSum));
  }

  // returns the minimum sum between two subsets.
  private static int minSubsetSumDiff(int[] arr, int n, int calculatedSum, int totalSum) {
    if (n == 0) {
      return Math.abs((totalSum - calculatedSum) - calculatedSum);
    }

    return Math.min(minSubsetSumDiff(arr, n - 1, calculatedSum + arr[n - 1], totalSum),
        minSubsetSumDiff(arr, n - 1, calculatedSum, totalSum));
  }
}
