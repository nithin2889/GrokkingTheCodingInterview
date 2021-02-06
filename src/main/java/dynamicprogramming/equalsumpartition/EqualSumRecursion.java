package dynamicprogramming.equalsumpartition;

public class EqualSumRecursion {

  public static void main(String[] args) {
    int[] arr = {1, 5, 11, 5};
    int size = arr.length;

    if (canPartition(arr, size)) {
      System.out.println("The array can be partitioned into two subsets of equal sum");
    } else {
      System.out.println("The array cannot be partitioned into two subsets of equal sum");
    }
  }

  // Returns true if arr[] can be partitioned in two subsets of equal sum, otherwise false
  public static boolean canPartition(int[] arr, int n) {
    // Calculate sum of the elements in array
    int sum = 0;

    for (int i = 0; i < n; i++) {
      sum += arr[i];
    }

    // If sum is odd, there cannot be two subsets with equal sum
    if (sum % 2 != 0) {
      return false;
    }
    // Find if there is subset with sum equal to half of total sum
    return isEqualSubsetSum(arr, sum / 2, n);
  }

  public static boolean isEqualSubsetSum(int[] arr, int sum, int n) {
    // base cases
    if (n == 0 && sum != 0) {
      return false;
    }
    if (sum == 0) {
      return true;
    }

    if (arr[n - 1] <= sum) {
      // check if the sum can be obtained by any of the following
      //  (a) including the last element
      //  (b) excluding the last element
      return isEqualSubsetSum(arr, sum - arr[n - 1], n - 1)
          || isEqualSubsetSum(arr, sum, n - 1);
    } else {
      // else if last element is greater than sum, then ignore it
      return isEqualSubsetSum(arr, sum, n - 1);
    }
  }
}
