package cp.prefixsum;

public class PrefixSum2DArray {

  public static void main(String[] args) {
    int m = 5, n = 6;
    int[][] arr = {
        {2, 4, 1, 3, 2, 3},
        {1, 2, 3, 1, 1, 9},
        {2, 1, 2, 3, 0, 5},
        {4, 2, 2, 5, 4, 3},
        {3, 9, 5, 0, 1, 2}};

    int[][] prefixSum = findPrefixSum(arr, m, n);
    int l1 = 2, l2 = 4, r1 = 2, r2 = 5;
    System.out.println("The LR sum of prefixSum[" + l2 + "]" + "[" + r2 + "] is: ");
    System.out.println(findLRSum(prefixSum, l1, l2, r1, r2));
  }

  private static int[][] findPrefixSum(int[][] arr, int m, int n) {
    int[][] prefixSum = new int[m][n];
    // prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] + arr[i][j] - prefixSum[i - 1][j - 1]
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        prefixSum[i][j] = arr[i][j];

        if (i - 1 >= 0) {
          prefixSum[i][j] += prefixSum[i - 1][j];
        }
        if (j - 1 >= 0) {
          prefixSum[i][j] += prefixSum[i][j - 1];
        }
        if (i - 1 >= 0 && j - 1 >= 0) {
          prefixSum[i][j] -= prefixSum[i - 1][j - 1];
        }
      }
    }
    return prefixSum;
  }

  private static int findLRSum(int[][] prefixSum, int l1, int l2, int r1, int r2) {
    int sum = prefixSum[l2][r2];
    if (l1 - 1 >= 0) {
      sum -= prefixSum[l1 - 1][r2];
    }
    if (r1 - 1 >= 0) {
      sum -= prefixSum[l2][r1 - 1];
    }
    if (l1 - 1 >= 0 && r1 - 1 >= 0) {
      sum += prefixSum[l1 - 1][r1 - 1];
    }
    return sum;
  }
}
