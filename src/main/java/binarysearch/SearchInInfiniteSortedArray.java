package binarysearch;

public class SearchInInfiniteSortedArray {

  public static void main(String[] args) {
    int[] arr = {3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
    int ele = 130;
    System.out.println("Element found at index: " + findPos(arr, ele));
  }

  private static int findPos(int[] arr, int key) {
    int start = 0, end = 1;
    // until the given key is greater than arr[end] this loop runs.
    while (key > arr[end]) {
      start = end;
      end *= 2;
    }
    return binarySearch(arr, start, end, key);
  }

  private static int binarySearch(int[] arr, int start, int end, int ele) {
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
