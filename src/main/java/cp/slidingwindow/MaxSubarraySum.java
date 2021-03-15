package cp.slidingwindow;

public class MaxSubarraySum {

  public static void main(String[] args) {
    int[] arr = {2, 1, 3, 2, 3};
    int k = 3;
    System.out.println("Using brute force the maximum sum subarray of " + k + " size is: "
        + maxSubarraySumUsingPrefixSum(arr, k));

    System.out.println("Using sliding window the maximum sum subarray of " + k + " size is: "
        + maxSubarraySumUsingSlidingWindow(arr, k));
  }

  private static int[] prefixSum(int[] arr) {
    int[] prefix = new int[arr.length];

    // predetermining the prefix sum
    for (int i = 0; i < arr.length; i++) {
      if (i == 0) {
        prefix[0] = arr[0];
      } else {
        prefix[i] = prefix[i - 1] + arr[i];
      }
    }
    return prefix;
  }

  private static int maxSubarraySumUsingPrefixSum(int[] arr, int k) {
    int n = arr.length;
    int max = Integer.MIN_VALUE;

    int[] prefixSum = prefixSum(arr);

    for (int i = 0; i <= n - k; i++) {
      int start = i, end = i + k - 1;

      int sum = prefixSum[end];
      if (start > 0) {
        sum -= prefixSum[start - 1];
      }

      if (sum > max) {
        max = sum;
      }
    }
    return max;
  }

  private static int maxSubarraySumUsingSlidingWindow(int[] arr, int k) {
    int n = arr.length;
    int sum = 0;
    int max = Integer.MIN_VALUE;

    for (int i = 0; i < k; i++) {
      sum += arr[i];
    }

    int l = 0, r = k - 1;
    while (r < n - 1) {
      // first move and then remove
      r = r + 1;
      sum += arr[r];

      // first remove and then move
      sum -= arr[l];
      l = l + 1;

      if (sum > max) {
        max = sum;
      }
    }
    return max;
  }
}
