package heaps;

import java.util.PriorityQueue;

public class SumOfElementsBetweenK1K2 {

  public static void main(String[] args) {
    int[] arr = {1, 3, 12, 5, 15, 11};
    int k1 = 2, k2 = 5;
    int size = arr.length;

    int k1Smallest = kthSmallest(arr, k1, size);
    int k2Smallest = kthSmallest(arr, k2, size);

    System.out.println("The sum of elements between " + k1 + " smallest and "
        + k2 + " smallest is: ");
    System.out.println(sumOfElementsBetweenK1K2(arr, k1Smallest, k2Smallest));
  }

  private static int kthSmallest(int[] arr, int k, int size) {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
    for (int i = 0; i < size; i++) {
      maxHeap.add(arr[i]);
      if (maxHeap.size() > k) {
        maxHeap.poll();
      }
    }
    return maxHeap.peek();
  }

  private static int sumOfElementsBetweenK1K2(int[] arr, int k1, int k2) {
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > k1 && arr[i] < k2) {
        sum += arr[i];
      }
    }
    return sum;
  }
}
