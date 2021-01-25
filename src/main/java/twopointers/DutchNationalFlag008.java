package twopointers;

public class DutchNationalFlag008 {

  /**
   * Given an array containing 0s, 1s and 2s, sort the array in-place.
   * You should treat numbers of the array as objects, hence, we can’t
   * count 0s, 1s, and 2s to recreate the array.
   *
   * The flag of the Netherlands consists of three colors: red, white and blue;
   * and since our input array also consists of three different numbers that is
   * why it is called Dutch National Flag problem.
   *
   * Input: [1, 0, 2, 1, 0]
   * Output: [0 0 1 1 2]
   *
   * Input: [2, 2, 0, 1, 2, 0]
   * Output: [0 0 1 2 2 2 ]
   *
   * Solution:
   * The brute force solution will be to use an in-place sorting algorithm like
   * Heapsort which will take O(N*logN). Can we do better than this? Is it possible
   * to sort the array in one iteration?
   *
   * We can use a Two Pointers approach while iterating through the array.
   * Let’s say the two pointers are called low and high which are pointing to the
   * first and the last element of the array respectively. So while iterating,
   * we will move all 0s before low and all 2s after high so that in the end,
   * all 1s will be between low and high.
   *
   * Time complexity #
   * The time complexity of the above algorithm will be O(N) as we are iterating
   * the input array only once.
   *
   * Space complexity #
   * The algorithm runs in constant space O(1).
   */
  public static void sort(int[] arr) {
    // all elements < low are and all elements > high are 2
    // all elements from >= low < i are 1
    int low=0, high=arr.length-1;
    for(int i=0; i<=high;){
      if(arr[i] == 0) {
        swap(arr, i, low);
        // increment i and low
        i++;
        low++;
      } else if(arr[i] == 1) {
        i++;
      } else { // the case for arr[i] == 2
        swap(arr, i, high);
        // decrement high only, after the swap the number at index i could be 0, 1, or 2.
        high--;
      }
    }
  }

  public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void main(String[] args) {
    int[] arr = new int[] {1, 0, 2, 1, 0};
    DutchNationalFlag008.sort(arr);
    for (int num : arr) {
      System.out.print(num + " ");
    }
    System.out.println();

    arr = new int[] {2, 2, 0, 1, 2, 0};
    DutchNationalFlag008.sort(arr);
    for (int num : arr) {
      System.out.print(num + " ");
    }
  }
}
