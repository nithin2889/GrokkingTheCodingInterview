package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NearestSmallerToLeft {

  public static void main(String[] args) {
    int[] arr = {4, 5, 2, 10, 8};
    System.out.println("Nearest smallest to left of the array is: "
        + nearestSmallestToLeft(arr));
  }

  private static List<Integer> nearestSmallestToLeft(int[] arr) {
    Stack<Integer> st = new Stack<>();
    List<Integer> resultList = new ArrayList<>();
    int size = arr.length;

    for (int i = 0; i < size; i++) {
      if (st.isEmpty()) {
        resultList.add(-1);
      } else if (st.size() > 0 && st.peek() < arr[i]) {
        resultList.add(st.peek());
      } else if (st.size() > 0 && st.peek() >= arr[i]) {
        while (st.size() > 0 && st.peek() >= arr[i]) {
          st.pop();
        }
        if (st.isEmpty()) {
          resultList.add(-1);
        } else {
          resultList.add(st.peek());
        }
      }
      st.push(arr[i]);
    }
    return resultList;
  }
}
