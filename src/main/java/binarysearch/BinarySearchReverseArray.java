package binarysearch;

public class BinarySearchReverseArray {

  public static void main(String[] args) {
    int[] arr = {20, 17, 15, 14, 13, 12, 10, 9, 8, 4};
    int ele = 4;
    System.out.println("Element found at index: " + binarySearchReverse(arr, ele));
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
