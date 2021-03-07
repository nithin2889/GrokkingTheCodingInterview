package slidingwindow;

public class MaximumSumSubarrayOfSizeK {

  public static void main(String[] args) {
    System.out.println("Maximum sum of a subarray of size K: "
        + MaximumSumSubarrayOfSizeK.findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 }));

    System.out.println("Maximum sum of a subarray of size K efficiently: " +
        MaximumSumSubarrayOfSizeK
        .findMaxSumSubArrayEfficiently(3, new int[] { 2, 1, 5, 1, 3, 2 }));

    System.out.println("Maximum sum of a subarray of size K using while loop: " +
        MaximumSumSubarrayOfSizeK
            .findMaxSumSubArrayUsingWhile(3, new int[] { 2, 1, 5, 1, 3, 2 }));
  }

  /**
   * Problem: Given an array of positive numbers and a positive number ‘k,’
   * find the maximum sum of any contiguous subarray of size ‘k’.
   *
   * Example:
   * Input: [2, 1, 5, 1, 3, 2], k=3
   * Output: 9
   * Explanation: Subarray with maximum sum is [5, 1, 3].
   */
  public static int findMaxSumSubArray(int k, int[] arr) {
    int maxSum = 0, windowSum;

    for(int i=0; i<=arr.length-k; i++) {
      windowSum = 0;
      for(int j=i; j<i+k; j++) {
        windowSum += arr[j];
      }
      maxSum = Math.max(maxSum, windowSum);
    }
    return maxSum;
  }

  /**
   * A better approach:
   * If you observe closely, you will realize that to calculate the
   * sum of a contiguous subarray, we can utilize the sum of the previous subarray.
   * For this, consider each subarray as a Sliding Window of size ‘k.’
   * To calculate the sum of the next subarray, we need to slide the window ahead
   * by one element. So to slide the window forward and calculate the sum of the
   * new position of the sliding window, we need to do two things:
   *
   * a. Subtract the element going out of the sliding window,
   *    i.e., subtract the first element of the window.
   * b. Add the new element getting included in the sliding window,
   *    i.e., the element coming right after the end of the window.
   *
   * This approach will save us from re-calculating the sum of the overlapping
   * part of the sliding window.
   *
   * The time complexity of the above algorithm will be O(N).
   */
  public static int findMaxSumSubArrayEfficiently(int k, int[] arr) {
    int maxSum = 0, windowSum = 0;
    int windowStart = 0;

    for (int windowEnd=0; windowEnd < arr.length; windowEnd++) {
      windowSum += arr[windowEnd];
      if(windowEnd >= k-1) {
        maxSum = Math.max(maxSum, windowSum);
        windowSum -= arr[windowStart];
        windowStart++;
      }
    }
    return maxSum;
  }

  public static int findMaxSumSubArrayUsingWhile(int k, int[] arr) {
    int maxSum = 0, windowStart = 0, windowEnd = 0, windowSum = 0;

    while(windowEnd < arr.length) {
      windowSum += arr[windowEnd];
      if (windowEnd - windowStart + 1 >= k) {
        maxSum = Math.max(maxSum, windowSum);
        windowSum -= arr[windowStart];
        windowStart++;
      }
      windowEnd++;
    }
    return maxSum;
  }
}
