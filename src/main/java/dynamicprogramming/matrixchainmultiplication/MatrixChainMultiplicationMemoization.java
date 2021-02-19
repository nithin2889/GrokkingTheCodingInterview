package dynamicprogramming.matrixchainmultiplication;

public class MatrixChainMultiplicationMemoization {

  public static void main(String[] args) {
    int[] arr = new int[]{40, 20, 30, 10, 30};
    int i = 1, j = arr.length - 1;
    int[][] t = new int[1001][1001];
    for (int r = 0; r < i + 1; r++) {
      for (int c = 0; c < j + 1; c++) {
        t[r][c] = -1;
      }
    }
    System.out.println("The minimum cost after matrix multiplication is: "
        + solve(arr, i, j, t));
  }

  public static int solve(int[] arr, int i, int j, int[][] t) {
    if (i >= j) {
      return 0;
    }
    if (t[i][j] != -1) {
      return t[i][j];
    }
    int min = Integer.MAX_VALUE;
    for (int k = i; k <= j - 1; k++) {
      int temp = solve(arr, i, k, t) + solve(arr, k + 1, j, t) + (arr[i - 1] * arr[k] * arr[j]);
      if (temp < min) {
        min = temp;
      }
    }
    return t[i][j] = min;
  }
}
