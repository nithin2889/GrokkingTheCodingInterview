package heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SortKSortedArray {

  public static void main(String[] args) {
    int[] arr = {6, 5, 3, 2, 8, 10, 9};
    int k = 3;
    int size = arr.length;

    System.out.println("The K sorted array is: ");
    List<Integer> sortedArray = sortKSortedArray(arr, k, size);
    sortedArray.forEach(System.out::println);
  }

  private static List<Integer> sortKSortedArray(int[] arr, int k, int size) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      minHeap.add(arr[i]);
      if (minHeap.size() > k) {
        res.add(minHeap.poll());
      }
    }

    while (minHeap.size() > 0) {
      res.add(minHeap.poll());
    }
    return res;
  }
}
