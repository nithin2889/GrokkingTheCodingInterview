package binarysearch;

public class BinarySearchOrderAgnostic {

  public static void main(String[] args) {
    // int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int[] arr = {20, 17, 15, 14, 13, 12, 10, 9, 8, 4};
    int ele = 9;
    int size = arr.length;

    if (arr[0] < arr[size - 1]) {
      System.out.println("Element found at index: " + binarySearch(arr, ele));
    } else {
      System.out.println("Element found at index: " + binarySearchReverse(arr, ele));
    }
  }

  private static int binarySearch(int[] arr, int ele) {
    int start = 0;
    int end = arr.length - 1;

    while (start <= end) {
      int mid = start + (end - start) / 2;

      if (ele == arr[mid]) {
        return mid;
      } else if (ele < arr[mid]) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return -1;
  }

  private static int binarySearchReverse(int[] arr, int ele) {
    int start = 0;
    int end = arr.length - 1;

    while (start <= end) {
      int mid = start + (end - start) / 2;

      if (ele == arr[mid]) {
        return mid;
      } else if (ele < arr[mid]) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return -1;
  }
}
