package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NearestGreaterToLeft {

  public static void main(String[] args) {
    int[] arr = {1, 3, 2, 4};
    System.out.println(nearestGreatestToLeft(arr));
  }

  private static List<Integer> nearestGreatestToLeft(int[] arr) {
    Stack<Integer> st = new Stack<>();
    List<Integer> resultList = new ArrayList<>();
    int size = arr.length;

    for (int i = 0; i < size; i++) {
      if (st.isEmpty()) {
        resultList.add(-1);
      } else if (st.size() > 0 && st.peek() > arr[i]) {
        resultList.add(st.peek());
      } else if (st.size() > 0 && st.peek() <= arr[i]) {
        while (!st.isEmpty() && arr[i] >= st.peek()) {
          st.pop();
        }
        if (st.isEmpty()) {
          resultList.add(-1);
        } else {
          resultList.add(st.peek());
        }
      }
      // before moving to next array element, we push the current element onto the stack.
      st.push(arr[i]);
    }
    return resultList;
  }
}
