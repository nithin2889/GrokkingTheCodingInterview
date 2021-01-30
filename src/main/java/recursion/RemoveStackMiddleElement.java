package recursion;

import java.util.Stack;

public class RemoveStackMiddleElement {

  public static void main(String[] args) {
    Stack<Integer> st = new Stack<>();
    st.push(1);
    st.push(2);
    st.push(3);
    st.push(4);
    st.push(5);

    int mid = st.size() / 2 + 1;
    Stack<Integer> res = solve(st, mid);
    for (Integer s : res) {
      System.out.print(s + " ");
    }
  }

  public static Stack<Integer> solve(Stack<Integer> st, int k) {
    // Base condition
    if (k == 1) {
      st.pop();
      return st;
    }
    int el = st.pop();

    // Hypotheses
    st = solve(st, k - 1);

    // Induction
    st.push(el);
    return st;
  }
}
