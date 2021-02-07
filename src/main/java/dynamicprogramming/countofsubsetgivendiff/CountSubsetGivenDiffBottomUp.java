package dynamicprogramming.countofsubsetgivendiff;

public class CountSubsetGivenDiffBottomUp {

  public static void main(String[] args) {
    int[] arr = {2, 3, 5, 6, 8, 10};
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
    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < s1 + 1; j++) {
        if (arr[i - 1] <= j) {
          t[i][j] = t[i - 1][j - arr[i - 1]] + t[i - 1][j];
        } else {
          t[i][j] = t[i - 1][j];
        }
      }
    }
    return t[n][s1];
  }
}
