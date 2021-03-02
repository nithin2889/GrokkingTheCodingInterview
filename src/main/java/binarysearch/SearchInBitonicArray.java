package binarysearch;

public class SearchInBitonicArray {

  public static void main(String[] args) {
    int[] arr = {1, 3, 8, 12, 4, 2};
    int size = arr.length;
    int ele = 4;

    int peak = findPeakElement(arr, size);
    System.out.println("The peak element is present at the index: " + peak);
    System.out.println("The element is present at index: ");
    System.out.println(binarySearch(arr, 0, peak - 1, ele));
    System.out.println(binarySearch(arr, peak, size - 1, ele));
  }

  private static int findPeakElement(int[] arr, int size) {
    int start = 0, end = size - 1;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (mid > 0 && mid < size - 1) {
        if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
          return mid;
        } else if (arr[mid - 1] > arr[mid]) {
          end = mid - 1;
        } else if (arr[mid + 1] > arr[mid]) {
          start = mid + 1;
        }
      } else if (mid == 0) {
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
