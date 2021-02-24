package heaps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class PrintTopKFrequentNumbers {

  public static void main(String[] args) {
    int[] arr = {1, 1, 1, 3, 2, 2, 4};
    int k = 2;
    int size = arr.length;
    System.out.println("The top k frequent numbers are: ");
    printTopKFrequentNumbers(arr, k, size);
  }

  private static void printTopKFrequentNumbers(int[] arr, int k, int size) {
    PriorityQueue<Pair> minHeap = new PriorityQueue<>(new Pair());
    Map<Integer, Integer> hm = new HashMap<>();

    // transforming an array into a hash map
    for (int i = 0; i < size; i++) {
      if (hm.containsKey(arr[i])) {
        hm.put(arr[i], hm.get(arr[i]) + 1);
      } else {
        hm.put(arr[i], 1);
      }
    }

    // storing values from hash map in min heap
    for (int i = 0; i < size; i++) {
      minHeap.add(new Pair(arr[i], hm.get(arr[i])));
      if (minHeap.size() > k) {
        minHeap.poll();
      }
    }

    // traversing min heap to find the answer
    while (!minHeap.isEmpty()) {
      Pair pair = minHeap.poll();
      System.out.println(pair.value);
    }
  }
}
