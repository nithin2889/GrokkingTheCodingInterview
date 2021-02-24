package heaps;

import java.util.PriorityQueue;

public class PrintKClosestNumbers {

  public static void main(String[] args) {
    int[] arr = {5, 6, 7, 8, 9};
    int k = 3, x = 7;
    int size = arr.length;
    System.out.println("The k closest numbers to the number " + x + " are: ");
    printKClosestNumbers(arr, k, size, x);
  }

  private static void printKClosestNumbers(int[] arr, int k, int size, int x) {
    PriorityQueue<Pair> maxHeap = new PriorityQueue<>(new Pair());

    for (int i = 0; i < size; i++) {
      maxHeap.add(new Pair(Math.abs(x - arr[i]), arr[i]));

      if (maxHeap.size() > k) {
        maxHeap.poll();
      }
    }
    // poll the remaining elements from the max heap.
    while (!maxHeap.isEmpty()) {
      System.out.println(maxHeap.poll().value);
    }
  }
}
