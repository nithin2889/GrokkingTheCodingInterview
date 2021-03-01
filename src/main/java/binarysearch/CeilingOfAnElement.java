package binarysearch;

public class CeilingOfAnElement {

  public static void main(String[] args) {
    int[] arr = {1, 2, 8, 10, 10, 12, 19};
    int ele = 5;
    System.out.println("Ceil of the element " + ele + " is: " + ceil(arr, ele));
  }

  private static int ceil(int[] arr, int ele) {
    int start = 0, end = arr.length - 1;
    int res = 0;

    while (start <= end) {
      int mid = start + (end - start) / 2;

      if (arr[mid] == ele) {
        return mid;
      } else if (arr[mid] < ele) {
        start = mid + 1;
      } else {
        res = arr[mid];
        end = mid - 1;
      }
    }
    return res;
  }
}
