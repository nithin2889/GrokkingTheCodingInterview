package binarysearch;

public class PeakElementUsingBinarySearchAnswer {

  public static void main(String[] args) {
    int[] arr = {5, 10, 15, 5};
    int size = arr.length;
    System.out.println(findPeakElement(arr, size));
  }

  private static int findPeakElement(int[] arr, int size) {
    int start = 0, end = size - 1;

    while (start <= end) {
      int mid = start + (end - start) / 2;
      if(mid > 0 && mid < end) {
        if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
          return mid;
        } else if (arr[mid - 1] > arr[mid]) {
          end = mid - 1;
        } else {
          start = mid + 1;
        }
      } else if(mid == 0) {
        if (arr[0] > arr[1]) {
          return 0;
        } else {
          return 1;
        }
      } else if (mid == size - 1) {
        if (arr[size - 1] > arr[size - 2]) {
          return size - 1;
        } else {
          return size - 2;
        }
      }
    }
    return -1;
  }
}
