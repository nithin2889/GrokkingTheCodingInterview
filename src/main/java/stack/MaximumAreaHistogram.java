package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class MaximumAreaHistogram {

  public static void main(String[] args) {
    int[] arr = {6, 2, 5, 4, 5, 1, 6};

    // Finding NSR and NSL
    List<Integer> nsr = findNSR(arr);
    List<Integer> nsl = findNSL(arr);

    int[] area = maxHistogramArea(arr, nsr, nsl);

    System.out.println("Maximum area of histogram is: "
        + Arrays.stream(area).max().getAsInt() + " units");
  }

  private static int[] maxHistogramArea(int[] arr, List<Integer> nsr, List<Integer> nsl) {
    int[] width = new int[nsr.size()];
    int[] area = new int[nsr.size()];

    // calculating width from both NSR and NSL
    for (int i = 0; i < nsr.size(); i++) {
      width[i] = nsr.get(i) - nsl.get(i) - 1;
    }

    // calculating area from the height of the building and the width calculated.
    for (int i = 0; i < width.length; i++) {
      area[i] = arr[i] * width[i];
    }
    return area;
  }

  private static List<Integer> findNSR(int[] arr) {
    Stack<Pair> st = new Stack<>();
    List<Integer> right = new ArrayList<>();
    List<Integer> res = new ArrayList<>();
    int size = arr.length;
    // pseudo index for the right part of the array is 7 as the array has 7 elements (indexed 0)
    int pseudoIndex = 7;

    for (int i = size - 1; i >= 0; i--) {
      if (st.isEmpty()) {
        right.add(pseudoIndex);
      } else if (st.size() > 0 && st.peek().key < arr[i]) {
        right.add(st.peek().value);
      } else if (st.size() > 0 && st.peek().key >= arr[i]) {
        while (!st.isEmpty() && st.peek().key >= arr[i]) {
          st.pop();
        }
        if (st.isEmpty()) {
          right.add(pseudoIndex);
        } else {
          right.add(st.peek().value);
        }
      }
      st.push(new Pair(arr[i], i));
    }
    reverse(right, res);
    return res;
  }

  private static void reverse(List<Integer> right, List<Integer> output) {
    for (int i = right.size() - 1; i >= 0; i--) {
      output.add(right.get(i));
    }
  }

  private static List<Integer> findNSL(int[] arr) {
    Stack<Pair> st = new Stack<>();
    List<Integer> left = new ArrayList<>();
    int size = arr.length;
    // pseudo index for the left part of the array is -1 as the array starts from 0th index.
    int pseudoIndex = -1;

    for (int i = 0; i <= size - 1; i++) {
      if (st.isEmpty()) {
        left.add(pseudoIndex);
      } else if (st.size() > 0 && st.peek().key < arr[i]) {
        left.add(st.peek().value);
      } else if (st.size() > 0 && st.peek().key >= arr[i]) {
        while (!st.isEmpty() && st.peek().key >= arr[i]) {
          st.pop();
        }
        if (st.isEmpty()) {
          left.add(pseudoIndex);
        } else {
          left.add(st.peek().value);
        }
      }
      st.push(new Pair(arr[i], i));
    }
    return left;
  }
}
