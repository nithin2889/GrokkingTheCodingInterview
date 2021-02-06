package dynamicprogramming.equalsumpartition;

public class EqualSumBottomUp {

  public static void main(String[] args) {
    int[] arr = {1, 5, 11, 5, 1};
    int size = arr.length;

    if (canPartition(arr, size)) {
      System.out.println("The array can be partitioned into two subsets of equal sum");
    } else {
      System.out.println("The array cannot be partitioned into two subsets of equal sum");
    }
  }

  private static boolean canPartition(int[] arr, int n) {
    // Calculate sum of the elements in array
    int sum = 0;

    for (int i = 0; i < n; i++) {
      sum += arr[i];
    }

    boolean[][] t = new boolean[n + 1][sum + 1];
    // fill the table initially with true and false
    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < sum + 1; j++) {
        if (i == 0) {
          t[i][j] = false;
        }
        if (j == 0) {
          t[i][j] = true;
        }
      }
    }

    // If sum is odd, there cannot be two subsets with equal sum
    if (sum % 2 != 0) {
      return false;
    }
    // Find if there is subset with sum equal to half of total sum
    return isEqualSubsetSum(arr, sum / 2, n, t);
  }

  private static boolean isEqualSubsetSum(int[] arr, int sum, int n, boolean[][] t) {
    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < sum + 1; j++) {
        if (arr[i - 1] <= sum) {
          t[i][j] = isEqualSubsetSum(arr, sum - arr[i - 1], i - 1, t)
              || isEqualSubsetSum(arr, sum, i - 1, t);
        } else {
          t[i][j] = isEqualSubsetSum(arr, sum, i - 1, t);
        }
      }
    }
    return t[n][sum];
  }
}
