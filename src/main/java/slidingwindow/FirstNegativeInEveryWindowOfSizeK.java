package slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class FirstNegativeInEveryWindowOfSizeK {

  public static void main(String[] args) {
    int[] arr = {12, -1, -7, 8, -15, 30, 16, 28};
    int k = 3;

    System.out.println(findNegatives(arr, k));
  }

  private static List<Integer> findNegatives(int[] arr, int k) {
    int size = arr.length;
    int windowStart = 0, windowEnd = size - 1;
    List<Integer> negativeList = new ArrayList<>();
    List<Integer> resultList = new ArrayList<>();

    while (windowEnd < size) {
      if (arr[windowEnd] < 0) {
        negativeList.add(arr[windowEnd]);
      }

      if (windowEnd - windowStart + 1 < k) {
        windowEnd++;
        continue;
      }

      if (windowEnd - windowStart + 1 == k) {
        if (!negativeList.isEmpty()) {
          resultList.add(negativeList.get(0));
        } else {
          resultList.add(0);
        }
        if (arr[windowStart] < 0) {
          negativeList.remove(0);
        }
        windowStart++;
      }
      windowEnd++;
    }
    return negativeList;
  }
}
