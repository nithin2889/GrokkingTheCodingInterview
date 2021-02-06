package dynamicprogramming.countofsubsetsum;

public class CountOfSubsetSumMemoization {

  public static void main(String[] args) {
    int[] arr = {2, 3, 5, 6, 8, 10};
    int sum = 10;
    int n = arr.length;

    int[][] t = new int[n + 1][sum + 1];
    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < sum + 1; j++) {
        if (i == 0) {
          t[i][j] = 0;
        }

        if (j == 0) {
          t[i][j] = 1;
        }
      }
    }

    System.out.println("Number of subset matching the sum are: "
        + countSubset(arr, sum, n, t));
  }

  private static int countSubset(int[] arr, int sum, int n, int[][] t) {
    if (n == 0 && sum != 0) {
      return 0;
    }
    if (sum == 0) {
      return 1;
    }
    if (t[n][sum] != 0) {
      return t[n][sum];
    }

    if (arr[n - 1] <= sum) {
      t[n][sum] = countSubset(arr, sum - arr[n - 1], n - 1, t)
          + countSubset(arr, sum, n - 1, t);
    } else {
      t[n][sum] = countSubset(arr, sum, n - 1, t);
    }
    return t[n][sum];
  }
}
