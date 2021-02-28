package binarysearch;

public class FindElementInSortedArray {

  public static void main(String[] args) {
    int[] arr = {11, 12, 15, 18, 2, 5, 6, 8};
    int size = arr.length;
    System.out.println("Element to be searched in present in the array at index: "
        + search(arr, 0, size - 1, 15));
  }

  private static int search(int[] arr, int low, int high, int target) {
    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (arr[mid] == target) {
        return mid;
      } else if (arr[low] <= arr[mid]) { // left side of the array is sorted
        if (arr[low] <= target && target < arr[mid]) {
          return search(arr, low, mid - 1, target);
        } else {
          return search(arr, mid + 1, high, target);
        }
      } else { // right side of the array is sorted
        if (arr[mid] < target && target <= arr[high]) {
          return search(arr, mid + 1, high, target);
        } else {
          return search(arr, low, mid - 1, target);
        }
      }
    }
    return -1;
  }
}
