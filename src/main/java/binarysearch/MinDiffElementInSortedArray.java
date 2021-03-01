package binarysearch;

public class MinDiffElementInSortedArray {

  public static void main(String[] args) {
    int[] arr = {1, 3, 8, 10, 15};
    int ele = 12;
    System.out.println("Minimum difference element is: " + minDiff(arr, ele));
  }

  private static int minDiff(int[] arr, int ele) {
    int start = 0, end = arr.length - 1;

    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (arr[mid] == ele) {
        return arr[mid];
      } else if (arr[mid] < ele) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    int prev = Math.abs(arr[start] - ele);
    int next = Math.abs(arr[end] - ele);

    return prev < next ? arr[start] : arr[end];
  }
}
