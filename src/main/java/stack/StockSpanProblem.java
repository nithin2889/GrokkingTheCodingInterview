package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StockSpanProblem {

  public static void main(String[] args) {
    int[] arr = {100, 80, 60, 70, 60, 75, 85};
    System.out.println("Consecutive smaller or equal to left of the array is: "
        + stockSpanProblem(arr));
  }

  private static List<Integer> stockSpanProblem(int[] arr) {
    Stack<Pair> st = new Stack<>();
    List<Integer> resultList = new ArrayList<>();
    List<Integer> output = new ArrayList<>();
    int size = arr.length;

    for (int i = 0; i <= size - 1; i++) {
      if (st.isEmpty()) {
        resultList.add(-1);
      } else if (st.size() > 0 && st.peek().key > arr[i]) {
        resultList.add(st.peek().value);
      } else if (st.size() > 0 && st.peek().key <= arr[i]) {
        while (st.size() > 0 && st.peek().key <= arr[i]) {
          st.pop();
        }
        if (st.isEmpty()) {
          resultList.add(-1);
        } else {
          resultList.add(st.peek().value);
        }
      }
      st.push(new Pair(arr[i], i));
    }
    for (int i = 0; i < resultList.size(); i++) {
      output.add(i - resultList.get(i));
    }
    return output;
  }
}
