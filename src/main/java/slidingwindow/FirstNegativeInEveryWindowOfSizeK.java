package slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class FirstNegativeInEveryWindowOfSizeK {

  public static void main(String[] args) {
    int[] arr = {12, -1, -7, 8, -15, 30, 16, 28};
    int k = 3;

    System.out.println("First negatives in every window are: " + findNegatives(arr, k));
  }

  private static List<Integer> findNegatives(int[] arr, int k) {
    int size = arr.length;
    int windowStart = 0, windowEnd = 0;

    List<Integer> ans = new ArrayList<>();

    while (windowEnd < size) {
      if (windowEnd - windowStart + 1 < k) {
        windowEnd++;
      } else if (windowEnd - windowStart + 1 == k) {
        for (int s = windowStart; s <= windowEnd; s++) {
          if (arr[s] < 0) {
            ans.add(arr[s]);
            break;
          } else if (arr[s] > 0 && s == windowEnd) {
            ans.add(0);
          }
        }
        windowEnd++;
        windowStart++;
      }
    }
    return ans;
  }
}
