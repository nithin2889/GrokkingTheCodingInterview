package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class MaxRectangleAreaInBinaryMatrix {

  public static void main(String[] args) {
    int[][] arr = {
        {0, 1, 1, 0},
        {1, 1, 1, 1},
        {1, 1, 1, 1},
        {1, 1, 0, 0}
    };
    int m = 4, n = 4;
    List<Integer> ls = new ArrayList<>();

    for (int j = 0; j < n; j++) {
      ls.add(arr[0][j]);
    }

    int max;
    int[] arr1 = ls.stream().mapToInt(Integer::intValue).toArray();
    List<Integer> nsr = findNSR(arr1);
    List<Integer> nsl = findNSL(arr1);
    max = maxHistogramArea(arr1, nsr, nsl);

    for (int i = 1; i < m; i++) {
      for (int j = 0; j < n; j++) {
        ls.add(ls.get(i) + arr[i][j]);
      }
    }
    int[] arr2 = ls.stream().mapToInt(Integer::intValue).toArray();
    nsr = findNSR(arr2);
    nsl = findNSL(arr2);

    max = Math.max(max, maxHistogramArea(arr2, nsr, nsl));
    System.out.println("Maximum rectangle area in the binary matrix is: " + max);
  }

  private static int maxHistogramArea(int[] arr, List<Integer> nsr, List<Integer> nsl) {
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
    return Arrays.stream(area).max().getAsInt();
  }

  private static List<Integer> findNSR(int[] arr) {
    Stack<Integer> st = new Stack<>();
    List<Integer> right = new ArrayList<>();
    List<Integer> res = new ArrayList<>();
    int size = arr.length;

    for (int i = size - 1; i >= 0; i--) {
      if (st.isEmpty()) {
        right.add(-1);
      } else if (st.size() > 0 && st.peek() < arr[i]) {
        right.add(st.peek());
      } else if (st.size() > 0 && st.peek() >= arr[i]) {
        while (!st.isEmpty() && st.peek() >= arr[i]) {
          st.pop();
        }
        if (st.isEmpty()) {
          right.add(-1);
        } else {
          right.add(st.peek());
        }
      }
      st.push(arr[i]);
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
    Stack<Integer> st = new Stack<>();
    List<Integer> left = new ArrayList<>();
    int size = arr.length;

    for (int i = 0; i <= size - 1; i++) {
      if (st.isEmpty()) {
        left.add(-1);
      } else if (st.size() > 0 && st.peek() < arr[i]) {
        left.add(st.peek());
      } else if (st.size() > 0 && st.peek() >= arr[i]) {
        while (!st.isEmpty() && st.peek() >= arr[i]) {
          st.pop();
        }
        if (st.isEmpty()) {
          left.add(-1);
        } else {
          left.add(st.peek());
        }
      }
      st.push(arr[i]);
    }
    return left;
  }
}
