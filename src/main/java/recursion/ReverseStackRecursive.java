package recursion;

import java.util.Stack;

public class ReverseStackRecursive {

  public static void main(String[] args) {
    Stack<Integer> st = new Stack<>();
    st.push(5);
    st.push(4);
    st.push(3);
    st.push(2);
    st.push(1);

    System.out.println("Stack to be reversed is: ");
    for (Integer item : st) {
      System.out.print(item + " ");
    }

    System.out.println("\nReversed stack is: ");
    System.out.print(ReverseStackRecursive.reverse(st));
  }

  public static Stack<Integer> reverse(Stack<Integer> st) {
    // base condition
    if (st.size() == 1) {
      return st;
    }

    // induction
    int temp = st.pop();

    // hypotheses
    reverse(st);
    return insertElement(st, temp);
  }

  public static Stack<Integer> insertElement(Stack<Integer> st, int el) {
    // base condition
    if (st.size() == 0) {
      st.push(el);
      return st;
    }
    int temp = st.pop();
    // induction
    insertElement(st, el);
    st.push(temp);
    return st;
  }
}
