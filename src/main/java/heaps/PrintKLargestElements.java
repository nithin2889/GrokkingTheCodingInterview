package heaps;

import java.util.PriorityQueue;

public class PrintKLargestElements {

  public static void main(String[] args) {
    int[] arr = {7, 10, 4, 3, 20, 15};
    int k = 3;
    int size = arr.length;
    System.out.println("The k largest elements in the array are: ");
    printKLargestElements(arr, k, size);
  }

  private static void printKLargestElements(int[] arr, int k, int size) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    for (int i = 0; i < size; i++) {
      minHeap.add(arr[i]);
      if (minHeap.size() > k) {
        minHeap.poll();
      }
    }

    while (minHeap.size() > 0) {
      System.out.println(minHeap.peek());
      minHeap.poll();
    }
  }
}
