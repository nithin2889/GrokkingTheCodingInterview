package slidingwindow;

public class MinimumSumSubarrayWithAGivenSum {

  public static void main(String[] args) {
    System.out.println("Smallest subarray length: "
        + MinimumSumSubarrayWithAGivenSum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 }));
  }

  /**
   * This problem follows the Sliding Window pattern, and we can use
   * a similar strategy as discussed in Maximum Sum Subarray of Size K.
   * There is one difference though: in this problem, the sliding window
   * size is not fixed. Here is how we will solve this problem:
   *
   * a. First, we will add-up elements from the beginning of the array until
   * their sum becomes greater than or equal to ‘S.’
   *
   * b. These elements will constitute our sliding window. We are asked to
   * find the smallest such window having a sum greater than or equal to ‘S.’
   * We will remember the length of this window as the smallest window so far.
   *
   * c. After this, we will keep adding one element in the sliding window
   * (i.e., slide the window ahead) in a stepwise fashion.
   *
   * d. In each step, we will also try to shrink the window from the beginning.
   * We will shrink the window until the window’s sum is smaller than ‘S’ again.
   * This is needed as we intend to find the smallest window. This shrinking
   * will also happen in multiple steps; in each step, we will do two things:
   *    i.  Check if the current window length is the smallest so far, and if so,
   *        remember its length.
   *    ii. Subtract the first element of the window from the running sum to shrink
   *        the sliding window.
   *
   * Time Complexity #
   * The time complexity of the above algorithm will be O(N).
   * The outer for loop runs for all elements, and the inner while loop
   * processes each element only once; therefore, the time complexity of
   * the algorithm will be O(N+N), which is asymptotically equivalent to O(N).
   *
   */
  public static int findMinSubArray(int S, int[] arr) {
    int windowSum = 0, minLength = Integer.MAX_VALUE;
    int windowStart = 0;

    for(int windowEnd=0; windowEnd < arr.length; windowEnd++) {
      windowSum += arr[windowEnd];

      while(windowSum >= S) {
        minLength = Math.min(minLength, windowEnd-windowStart+1);
        windowSum -= arr[windowStart];
        windowStart++;
      }
    }
    return minLength == Integer.MAX_VALUE ? 0 : minLength;
  }
}
