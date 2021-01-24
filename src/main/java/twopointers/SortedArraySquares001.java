package twopointers;

public class SortedArraySquares001 {

  public static void main(String[] args) {
    int[] result = SortedArraySquares001.makeSquares(new int[] {-2, -1, 0, 2, 3});
    for (int num : result) {
      System.out.print(num + " ");
    }
  }

  public static int[] makeSquares(int[] arr) {
    int n = arr.length;
    int highestSquaredIdx = n - 1;
    int[] result = new int[n];
    int left = 0, right = arr.length - 1;

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
