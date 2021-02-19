package dynamicprogramming.matrixchainmultiplication;

public class MatrixChainMultiplicationRecursive {

  public static void main(String[] args) {
    int[] arr = new int[]{40, 20, 30, 10, 30};
    int i = 1, j = arr.length - 1;
    System.out.println("The minimum cost after matrix multiplication is: "
        + solve(arr, i, j));
  }

  public static int solve(int[] arr, int i, int j) {
    if (i >= j) {
      return 0;
    }
    int min = Integer.MAX_VALUE;
    for (int k = i; k <= j - 1; k++) {
      int tempAns = solve(arr, i, k) + solve(arr, k + 1, j) + (arr[i - 1] * arr[k] * arr[j]);
      if (tempAns < min) {
        min = tempAns;
      }
    }
    return min;
  }
}
