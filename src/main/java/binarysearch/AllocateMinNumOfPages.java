package binarysearch;

import java.util.Arrays;

public class AllocateMinNumOfPages {

  public static void main(String[] args) {
    int[] arr = {10, 20, 30, 40};
    int n = arr.length;
    int k = 2;

    System.out.println("Minimum number of pages a student should study is: "
        + findPages(arr, n, k));
  }

  private static int findPages(int[] arr, int n, int k) {
    if (n < k) {
      return -1;
    }

    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += arr[i];
    }

    // at least one student should have one book to study from.
    // choosing the largest element in the array to start with.
    int start = Arrays.stream(arr).max().getAsInt();
    int end = sum;
    int res = -1;

    while (start <= end) {
      int mid = start + (end - start) / 2;

      // the isValid function checks whether the element chosen as mid is right
      if (isValid(arr, n, k, mid)) {
        res = mid;
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return res;
  }

  private static boolean isValid(int[] arr, int n, int k, int mid) {
    int student = 1;
    int sum = 0;

    for (int i = 0; i < n; i++) {
      sum += arr[i];
      if (sum > mid) {
        student++;
        sum = arr[i];
      }
      // checking within the loop to improve the efficiency.
      if (student > k) {
        return false;
      }
    }
    return true;
  }
}
