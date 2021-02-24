package heaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {

  public static void main(String[] args) {
    int[] arr = {1, 1, 1, 3, 2, 2, 2, 4};
    int size = arr.length;
    System.out.println("The top k frequent numbers are: ");
    System.out.println(frequencySort(arr, size));
  }

  private static List<Integer> frequencySort(int[] arr, int size) {
    PriorityQueue<Pair> maxHeap = new PriorityQueue<>(new Pair());
    Map<Integer, Integer> hm = new HashMap<>();

    for (int i = 0; i < size; i++) {
      hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
    }

    // get all the pair values in the max heap.
    for (int key : hm.keySet()) {
      maxHeap.add(new Pair(key, hm.get(key)));
    }

    List<Integer> res = new ArrayList<>();
    while (!maxHeap.isEmpty()) {
      Pair obj = maxHeap.poll();
      for (int i = 0; i < obj.value; i++) {
        res.add(obj.key);
      }
    }
    maxHeap.poll();
    return res;
  }
}
