package dynamicprogramming.subsetsum;

public class SubsetSumBottomUp {

  public static void main(String[] args) {
    int[] arr = {2, 3, 7, 8, 10};
    int sum = 6;
    int n = arr.length;
    System.out.println("Is the sum present in the subset? " + subsetSum(arr, sum, n));
  }

  public static boolean subsetSum(int[] arr, int sum, int n) {
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

    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < sum + 1; j++) {
        if (arr[i - 1] <= sum) {
          t[i][j] = subsetSum(arr, sum - arr[i - 1], i - 1) ||
              subsetSum(arr, sum, i - 1);
        } else {
          t[i][j] = subsetSum(arr, sum, i - 1);
        }
      }
    }
    return t[n][sum];
  }
}
