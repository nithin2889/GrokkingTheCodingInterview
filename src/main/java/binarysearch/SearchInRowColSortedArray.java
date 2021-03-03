package binarysearch;

import java.util.Arrays;

public class SearchInRowColSortedArray {

  public static void main(String[] args) {
    int[][] mat = {{10, 20, 30, 40},
        {15, 25, 35, 45},
        {27, 29, 37, 48},
        {32, 33, 39, 50}};

    int key = 32;
    int[] result = search(mat, 4, 4, key);
    System.out.println("Element found at: " + Arrays.toString(result));
  }

  private static int[] search(int[][] mat, int m, int n, int key) {
    int i = 0, j = n - 1;
    int[] res = new int[2];
    while (i >= 0 && i < m && j >= 0 && j < n) {
      if (mat[i][j] == key) {
        res[0] = j;
        res[1] = i;
        return res;
      } else if (mat[i][j] > key) {
        j--;
      } else if (mat[i][j] < key) {
        i++;
      }
    }
    return new int[0];
  }
}
