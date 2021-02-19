package dynamicprogramming.palindromepartitioning;

import java.util.Arrays;

public class PalindromePartitioningMemoizationOptimized {

  public static void main(String[] args) {
    String inStr = "nitin";
    int n = inStr.length();
    int i = 0, j = n - 1;

    int[][] t = new int[n][n];
    for (int[] row : t) {
      Arrays.fill(row, -1);
    }
    System.out.println("Min number of partitions in the string is: "
        + minPartitions(inStr, i, j, t));
  }

  private static int minPartitions(String s, int i, int j, int[][] t) {
    if (i >= j) {
      return 0;
    }
    if (isPalindrome(s)) {
      return 0;
    }
    if (t[i][j] != -1) {
      return t[i][j];
    }
    int min = Integer.MAX_VALUE;
    int left, right;

    for (int k = i; k <= j - 1; k++) {
      if (t[i][k] != -1) {
        left = t[i][k];
      } else {
        left = minPartitions(s, i, k, t);
        t[i][k] = left;
      }

      if (t[k + 1][j] != -1) {
        right = t[k + 1][j];
      } else {
        right = minPartitions(s, k + 1, j, t);
        t[k + 1][j] = right;
      }
      int tempAns = 1 + left + right;
      min = Math.min(min, tempAns);
    }
    return t[i][j] = min;
  }

  private static boolean isPalindrome(String s) {
    int n = s.length();
    int i = 0, j = n - i - 1;
    if (i == j) {
      return true;
    }
    if (i > j) {
      return true;
    }
    while (i < j) {
      if (s.charAt(i) != s.charAt(j)) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }
}
