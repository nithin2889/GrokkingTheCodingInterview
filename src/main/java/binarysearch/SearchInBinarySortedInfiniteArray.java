package binarysearch;

public class SearchInBinarySortedInfiniteArray {

  public static void main(String[] args) {
    int[] arr = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

    System.out.println("Index of the first '1' in a binary sorted infinite array is present at: "
        + findLowerBound(arr, 1));
  }

  private static int findLowerBound(int[] arr, int key) {
    int start = 0;
    int end = 1;
    while (key > arr[end]) {
      start = end;
      end *= 2;
    }
    return binarySearch(arr, start, end, key);
  }

  private static int binarySearch(int[] arr, int start, int end, int ele) {
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
}
