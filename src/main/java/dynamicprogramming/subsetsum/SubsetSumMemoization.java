package dynamicprogramming.subsetsum;

public class SubsetSumMemoization {

  public static void main(String[] args) {
    int[] arr = {2, 3, 7, 8, 10};
    int sum = 11;
    int n = arr.length;
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
    System.out.println("Is the sum present in the subset? " + subsetSum(arr, sum, n, t));
  }

  private static boolean subsetSum(int[] arr, int sum, int n, boolean[][] t) {
    if (sum > 0 && n == 0) {
      return false;
    }

    if(sum == 0) {
      return true;
    }

    if (t[n][sum]) {
      return t[n][sum];
    }

    if (arr[n - 1] <= sum) {
      return t[n][sum] = subsetSum(arr, sum - arr[n - 1], n - 1, t) ||
          subsetSum(arr, sum, n - 1, t);
    } else {
      return t[n][sum] = subsetSum(arr, sum, n - 1, t);
    }
  }
}
