package dynamicprogramming.countofsubsetgivendiff;

public class CountSubsetGivenDiffMemoization {

  public static void main(String[] args) {
    int[] arr = {1, 1, 2, 3};
    int diff = 1, s1;
    int totalSum = 0;
    int n = arr.length;

    for (int i : arr) {
      totalSum += i;
    }

    s1 = diff + totalSum / 2;
    int[][] t = new int[n + 1][s1 + 1];
    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < s1 + 1; j++) {
        if (i == 0) {
          t[i][j] = 0;
        }

        if (j == 0) {
          t[i][j] = 1;
        }
      }
    }
    System.out.println("Number of subset matching the sum are: "
        + countSubset(arr, s1, n, t));
  }

  private static int countSubset(int[] arr, int s1, int n, int[][] t) {
    if (n == 0 && s1 != 0) {
      return 0;
    }
    if (s1 == 0) {
      return 1;
    }
    if (t[n][s1] != 0) {
      return t[n][s1];
    }

    if (arr[n - 1] <= s1) {
      t[n][s1] = countSubset(arr, s1 - arr[n - 1], n - 1, t)
          + countSubset(arr, s1, n - 1, t);
    } else {
      t[n][s1] = countSubset(arr, s1, n - 1, t);
    }
    return t[n][s1];
  }
}
