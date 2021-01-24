package twopointers;

public class RemoveFromUnsortedArrayGivenKey002 {

  public static void main(String[] args) {
    System.out.println(RemoveFromUnsortedArrayGivenKey002
        .remove(new int[]{3, 2, 3, 6, 3, 10, 9, 3}, 3));
  }

  /**
   * Problem 1: Given an unsorted array of numbers and a target ‘key’, remove all instances of ‘key’
   * in-place and return the new length of the array.
   *
   * Input: [3, 2, 3, 6, 3, 10, 9, 3], Key=3
   * Output: 4
   * Explanation: The first four elements after removing every 'Key' will be [2, 6, 10, 9].
   *
   * Input: [2, 11, 2, 2, 1], Key=2
   * Output: 2
   * Explanation: The first two elements after removing every 'Key' will be [11, 1].
   *
   * Time and Space Complexity: The time complexity of the above algorithm will be O(N),
   * where ‘N’ is the total number of elements in the given array.
   *
   * The algorithm runs in constant space O(1).
   */
  public static int remove(int[] arr, int key) {
    // arr = 3, 2, 3, 6, 3, 10, 9, 3
    // key = 3
    int nextElement = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] != key) {
        arr[nextElement] = arr[i];
        nextElement++;
      }
    }
    return nextElement;
  }
}
