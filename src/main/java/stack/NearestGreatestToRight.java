package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NearestGreatestToRight {

  public static void main(String[] args) {
    int[] arr = {1, 3, 2, 4};
    System.out.println("Nearest greatest to right of the array is: "
        + nearestGreatestToRight(arr));
  }

  private static List<Integer> nearestGreatestToRight(int[] arr) {
    Stack<Integer> st = new Stack<>();
    List<Integer> reverseList = new ArrayList<>();
    List<Integer> resList = new ArrayList<>();
    int size = arr.length;

    for (int i = size - 1; i >= 0; i--) {
      if (st.isEmpty()) {
        reverseList.add(-1);
      } else if (st.size() > 0 && st.peek() > arr[i]) {
        reverseList.add(st.peek());
      } else if (st.size() > 0 && st.peek() <= arr[i]) {
        while (!st.isEmpty() && arr[i] >= st.peek()) {
          st.pop();
        }
        if (st.isEmpty()) {
          reverseList.add(-1);
        } else {
          reverseList.add(st.peek());
        }
      }
      st.push(arr[i]);
    }
    reverse(reverseList, resList);
    return resList;
  }

  private static void reverse(List<Integer> reverseList, List<Integer> resList) {
    for (int i = reverseList.size() - 1; i >= 0; i--) {
      resList.add(reverseList.get(i));
    }
  }
}
