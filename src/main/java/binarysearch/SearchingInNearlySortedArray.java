package binarysearch;

public class SearchingInNearlySortedArray {

  public static void main(String[] args) {
    int[] arr = {5, 10, 30, 20, 40};
    int size = arr.length;
    System.out.println("Number of times an array rotated is: " + search(arr, 20));
  }

  // modified binary search
  private static int search(int[] arr, int ele) {
    int start = 0, end = arr.length - 1;

    while (start <= end) {
      int mid = start + (end - start) / 2;

      if (arr[mid] == ele) {
        return mid;
      } else if (mid - 1 >= start && arr[mid - 1] == ele) {
        return mid - 1;
      } else if (mid + 1 <= end && arr[mid + 1] == ele) {
        return mid + 1;
      } else if (arr[mid] < ele) {
        start = mid + 2;
      } else {
        end = mid - 2;
      }
    }
    return -1;
  }
}
