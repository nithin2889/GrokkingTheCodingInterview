package heaps;

import java.util.PriorityQueue;

public class ConnectRopesToMinimize {

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5};
    int size = arr.length;
    System.out.println("The minimum cost of ropes is: ");
    System.out.println(connectRopes(arr, size));
  }

  private static int connectRopes(int[] arr, int size) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int cost = 0;

    for (int i = 0; i < size; i++) {
      minHeap.add(arr[i]);
    }

    while (minHeap.size() >= 2) {
      int first = minHeap.poll();
      int second = minHeap.poll();
      cost += first + second;
      minHeap.add(first + second);
    }
    return cost;
  }
}
