package binarysearch;

public class PeakElementUsingBinarySearchAnswer {

  public static void main(String[] args) {
    int[] arr = {5, 10, 15, 5};
    int size = arr.length;
    System.out.println("The peak element in the array is: " + findPeakElement(arr, size));
  }

  private static int findPeakElement(int[] arr, int size) {
    int start = 0, end = size - 1;

    while (start <= end) {
      int mid = start + (end - start) / 2;

      if (mid > 0 && mid < end) {
        // if mid is greater than both of its left and right neighbors, return mid.
        if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
          return mid;
        } else if (arr[mid - 1] > arr[mid]) {
          // if mid - 1 is greater than mid, then go towards the left part of the array
          end = mid - 1;
        } else {
          // if mid + 1 is greater than mid, then go towards the right part of the array
          start = mid + 1;
        }
      } else if (mid == 0) {
        // if mid is at the left most of the array then check only with the first element
        if (arr[0] > arr[1]) {
          return 0;
        } else {
          return 1;
        }
      } else if (mid == size - 1) {
        // if mid is at the right most of the array then check only with the last but one element
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
