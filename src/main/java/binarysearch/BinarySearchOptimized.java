package binarysearch;

public class BinarySearchOptimized {

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int ele = 11;
    System.out.println("Element found at index: " + binarySearch(arr, ele));
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
}
