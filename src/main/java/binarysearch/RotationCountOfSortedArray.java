package binarysearch;

public class RotationCountOfSortedArray {

  public static void main(String[] args) {
    int[] arr = {2, 5, 6, 8, 11, 12, 15};
    int size = arr.length;
    System.out.println("Number of times an array rotated is: " + rotationCount(arr, size));
  }

  private static int rotationCount(int[] arr, int size) {
    int start = 0, end = arr.length - 1;
    int pivot = -1;

    if (arr[start] <= arr[end]) {
      return 0;
    }

    while (start <= end) {
      int mid = start + (end - start) / 2;
      int next = (mid + 1) % size;
      int prev = (mid + size - 1) % size;

      if (arr[mid] <= arr[prev] && arr[mid] <= arr[next]) {
        pivot = mid;
      }

      if (arr[start] <= arr[mid]) {
        start = mid + 1;
      } else if (arr[mid] <= arr[end]) {
        end = mid - 1;
      }
    }
    return pivot;
  }
}
