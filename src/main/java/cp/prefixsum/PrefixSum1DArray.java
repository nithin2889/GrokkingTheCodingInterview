package cp.prefixsum;

public class PrefixSum1DArray {

  public static void main(String[] args) {
    int[] arr = {2, 1, 3, 3, 1, 4};
    int l = 2, r = 5;

    System.out.println("sum of all numbers in the given range in brute force is: "
        + prefixSumBruteForce(arr, l, r));

    System.out.println("sum of all numbers in the given range after optimization is: "
        + prefixSumOptimized(arr, l, r));
  }

  private static int prefixSumBruteForce(int[] arr, int l, int r) {
    int sum = 0;
    for (int i = l; i <= r; i++) {
      sum += arr[i];
    }
    return sum;
  }

  private static int prefixSumOptimized(int[] arr, int l, int r) {
    int sum;
    int[] prefixSum = new int[arr.length];

    // Predetermining the prefix sum array
    for (int i = 0; i < arr.length; i++) {
      if (i == 0) {
        prefixSum[i] = arr[i];
      } else {
        prefixSum[i] = prefixSum[i - 1] + arr[i];
      }
    }

    // querying in prefixSum array to get the sum for the given range
    sum = prefixSum[r];

    // since the prefix sum is in the middle,
    // we remove the element from the sum from the front of array.
    if (l > 0) {
      sum -= prefixSum[l - 1];
    }
    return sum;
  }
}
