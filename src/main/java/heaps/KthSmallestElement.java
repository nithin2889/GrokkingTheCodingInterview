package heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthSmallestElement {

  public static void main(String[] args) {
    int[] arr = {7, 10, 4, 3, 20, 15};
    int k = 3;
    int size = arr.length;
    System.out.println("The kth smallest element using a brute force technique is: "
        + findKthSmallestElementBruteForce(arr, k, size));
    System.out.println("The kth smallest element using a MaxHeap is: "
        + findKthSmallestElement(arr, k, size));
  }

  private static int findKthSmallestElementBruteForce(int[] arr, int k, int size) {
    int item = 0;
    Arrays.sort(arr);
    for (int i = 0; i < size; i++) {
      if (k > 0 && k < size) {
        item = arr[k - 1];
      }
    }
    return item;
  }

  private static int findKthSmallestElement(int[] arr, int k, int size) {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
    for (int i = 0; i < size; i++) {
      maxHeap.add(arr[i]);
      if (maxHeap.size() > k) {
        maxHeap.poll();
      }
    }
    return maxHeap.peek();
  }
}
