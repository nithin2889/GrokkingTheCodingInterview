package dynamicprogramming.equalsumpartition;

public class EqualSumMemoization {

  public static void main(String[] args) {
    int[] arr = {1, 5, 11, 5};
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
          t[i][j] = true;
        }
        if (j == 0) {
          t[i][j] = false;
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
    if (n == 0 && sum != 0) {
      return false;
    }

    if (sum == 0) {
      return true;
    }

    if (t[n][sum]) {
      return true;
    }

    if (arr[n - 1] <= sum) {
      return t[n][sum] = isEqualSubsetSum(arr, sum - arr[n - 1], n - 1, t)
          || isEqualSubsetSum(arr, sum, n - 1, t);
    } else {
      return t[n][sum] = isEqualSubsetSum(arr, sum, n - 1, t);
    }
  }
}
