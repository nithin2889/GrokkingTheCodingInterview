package heaps;

import java.util.PriorityQueue;

public class KthSmallestElement {

  public static void main(String[] args) {
    int[] arr = {7, 10, 4, 3, 20, 15};
    int k = 3;
    int size = arr.length;
    System.out.println("The kth smallest element is: " + findKthSmallestElement(arr, k, size));
  }

  private static int findKthSmallestElement(int[] arr, int k, int size) {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
    for (int i = 0; i < size; i++) {
      maxHeap.add(arr[i]);
      if (maxHeap.size() > k) {
        // remove the topmost element from the heap and add the next element from the array.
        maxHeap.poll();
        maxHeap.add(arr[i]);
      }
    }
    return maxHeap.peek();
  }
}
