package heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PrintKClosestPointsToOrigin {

  public static void main(String[] args) {
    int[][] arr = {{1, 3}, {-2, 2}, {5, 8}, {0, 1}};
    int k = 2;
    int size = arr.length;
    System.out.println(Arrays.deepToString(printKClosestPoints(arr, k, size)));
  }

  private static int[][] printKClosestPoints(int[][] arr, int k, int size) {
    PriorityQueue<Pair> maxHeap = new PriorityQueue<>(new Pair());

    for (int i = 0; i < size; i++) {
      int squares = square(arr);
      maxHeap.add(new Pair(i, squares));

      if (maxHeap.size() > k) {
        maxHeap.poll();
      }
    }

    int[][] res = new int[maxHeap.size()][2];
    int row = 0;
    while (!maxHeap.isEmpty()) {
      Pair pair = maxHeap.poll();
      res[row][0] = arr[pair.key][0];
      res[row][1] = arr[pair.key][1];
      row++;
    }
    return res;
  }

  private static int square(int[][] arr) {
    return (arr[0][0] * arr[1][1]);
  }
}
