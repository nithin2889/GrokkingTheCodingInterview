package twopointers;

public class SortedArraySquares {

  public static void main(String[] args) {
    int[] result = SortedArraySquares.makeSquares(new int[] {-2, -1, 0, 2, 3});
    for (int num : result) {
      System.out.print(num + " ");
    }
  }

  /**
   * Given a sorted array, create a new array containing squares of all the number of the input
   * array in the sorted order.
   *
   * Input: [-2, -1, 0, 2, 3]
   * Output: [0, 1, 4, 4, 9]
   *
   * Input: [-3, -1, 0, 1, 2]
   * Output: [0 1 1 4 9]
   *
   * Solution:
   * This is a straightforward question. The only trick is that we can have negative numbers in
   * the input array, which will make it a bit difficult to generate the output array with squares
   * in sorted order.
   *
   * An easier approach could be to first find the index of the first non-negative number
   * in the array. After that, we can use Two Pointers to iterate the array. One pointer will
   * move forward to iterate the non-negative numbers and the other pointer will move backward
   * to iterate the negative numbers. At any step, whichever number gives us a bigger square
   * will be added to the output array.
   *
   * Since the numbers at both the ends can give us the largest square, an alternate approach
   * could be to use two pointers starting at both the ends of the input array. At any step,
   * whichever pointer gives us the bigger square we add it to the result array and move to
   * the next/previous number according to the pointer.
   */
  public static int[] makeSquares(int[] arr) {
    int n = arr.length;
    int highestSquaredIdx = n - 1;
    int[] result = new int[n];
    int left = 0;
    int right = arr.length - 1;

    while (left <= right) {
      int leftSquare = arr[left] * arr[left];
      int rightSquare = arr[right] * arr[right];

      if (leftSquare > rightSquare) {
        result[highestSquaredIdx--] = leftSquare;
        left++;
      } else {
        result[highestSquaredIdx--] = rightSquare;
        right--;
      }
    }
    return result;
  }
}
