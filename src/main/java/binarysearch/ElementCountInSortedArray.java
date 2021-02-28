package binarysearch;

public class ElementCountInSortedArray {

  public static void main(String[] args) {
    int[] arr = {2, 4, 10, 10, 10, 18, 20};
    int ele = 10;

    int firstOccurrence = firstIndex(arr, ele);
    int lastOccurrence = lastIndex(arr, ele);
    System.out.println("Count of element " + ele + " is: " + (lastOccurrence - firstOccurrence + 1));
  }

  private static int firstIndex(int[] arr, int ele) {
    int start = 0, end = arr.length - 1;
    int res = -1;

    while (start <= end) {
      int mid = start + (end - start) / 2;

      if (ele == arr[mid]) {
        res = mid;
        end = mid - 1;
      } else if (ele < arr[mid]) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return res;
  }

  private static int lastIndex(int[] arr, int ele) {
    int start = 0, end = arr.length - 1;
    int res = -1;

    while (start <= end) {
      int mid = start + (end - start) / 2;

      if (ele == arr[mid]) {
        res = mid;
        start = mid + 1;
      } else if (ele < arr[mid]) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return res;
  }
}
