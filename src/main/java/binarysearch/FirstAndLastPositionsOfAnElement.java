package binarysearch;

public class FirstAndLastPositionsOfAnElement {

  public static void main(String[] args) {
    int[] arr = {2, 4, 10, 10, 10, 18, 20};
    int ele = 10;

    System.out.println("First occurrence of element "
        + ele + " found at index: " + firstOccurrence(arr, ele));
    System.out.println("Last occurrence of element "
        + ele + " found at index: " + lastOccurrence(arr, ele));
  }

  private static int firstOccurrence(int[] arr, int ele) {
    int start = 0, end = arr.length - 1;
    int res = -1;

    while (start <= end) {
      int mid = (start + (end - start)) / 2;

      if (arr[mid] == ele) {
        // since mid is a possible answer, store it
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

  private static int lastOccurrence(int[] arr, int ele) {
    int start = 0, end = arr.length - 1;
    int res = -1;

    while (start <= end) {
      int mid = (start + (end - start)) / 2;

      if (arr[mid] == ele) {
        // since mid is a possible answer, store it
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
