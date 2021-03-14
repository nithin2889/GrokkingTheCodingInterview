package cp.prefixsum;

public class PrefixSum2DArray {

  public static void main(String[] args) {
    int m = 4, n = 5;
    int[][] arr = {
        {2, 4, 1, 3, 2},
        {1, 2, 3, 1, 1},
        {2, 1, 2, 3, 0},
        {4, 2, 2, 5, 4}};
    int[][] prefixSum = findPrefixSum(arr, m, n);

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(prefixSum[i][j] + " ");
      }
    }
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
}
