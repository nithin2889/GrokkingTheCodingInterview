package slidingwindow;

import java.util.Arrays;

public class AverageOfSubarrayOfSizeK001 {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(AverageOfSubarrayOfSizeK001
        .findAverages(5, new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2})));

    System.out.println(Arrays.toString(AverageOfSubarrayOfSizeK001
        .findAveragesEfficiently(5, new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2})));
  }

  public static double[] findAverages(int K, int[] arr) {
    /**
     * A brute-force algorithm will be to calculate the sum of
     * every 5-element contiguous subarray of the given array
     * and divide the sum by ‘5’ to find the average.
     *
     * Time complexity: Since for every element of the input array,
     * we are calculating the sum of its next ‘K’ elements,
     * the time complexity of the above algorithm will be O(N*K).
     *
     * O(N∗K) where ‘N’ is the number of elements in the input array.
     */
    double[] result = new double[arr.length-K+1];

    for(int i = 0; i <= arr.length-K; i++) {
      double sum = 0;
      for(int j=i; j<i+K; j++) {
        sum += arr[j];
      }
      result[i] = sum / K;
    }
    return result;
  }

  /**
   * The efficient way to solve this problem would be to visualize
   * each contiguous subarray as a sliding window of ‘5’ elements.
   * This means that when we move on to the next subarray,
   * we will slide the window by one element.
   * So, to reuse the sum from the previous subarray, we will subtract
   * the element going out of the window and add the element now being
   * included in the sliding window. This will save us from going through
   * the whole subarray to find the sum and, as a result, the algorithm
   * complexity will reduce to O(N).
   */
  public static double[] findAveragesEfficiently(int K, int[] arr) {
    double[] result = new double[arr.length-K+1];
    double windowSum = 0;
    int windowStart = 0;
    for(int windowEnd=0; windowEnd<arr.length; windowEnd++) {
      windowSum += arr[windowEnd];
      if(windowEnd >= K-1) {
        result[windowStart] = windowSum / K;
        windowSum -= arr[windowStart];
        windowStart++;
      }
    }
    return result;
  }
}
