package binarysearch;

public class FloorOfAnElement {

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 8, 10, 10, 12, 19};
    int ele = 5;
    System.out.println("Floor of the element " + ele + " is: " + floor(arr, ele));
  }

  private static int floor(int[] arr, int ele) {
    int start = 0, end = arr.length - 1;
    int res = 0;

    while (start <= end) {
      int mid = start + (end - start) / 2;

      if (arr[mid] == ele) {
        return mid;
      } else if (arr[mid] < ele) {
        res = arr[mid];
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return res;
  }
}
