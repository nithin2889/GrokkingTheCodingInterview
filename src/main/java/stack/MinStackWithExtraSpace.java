package stack;

import java.util.Stack;

public class MinStackWithExtraSpace {

  private static Stack<Integer> s = new Stack<>();
  private static Stack<Integer> ss = new Stack<>();

  public static void main(String[] args) {
    System.out.println(isEmpty() ? "Stack is empty" : "Stack is not empty");
    push(18);
    push(19);
    push(29);
    push(15);
    pop();
    push(16);
    System.out.println(isEmpty() ? "Stack is empty" : "Stack is not empty");
    System.out.println("minimum element is: " + getMin());
  }

  private static void push(int el) {
    s.push(el);

    if (ss.size() == 0 || el <= ss.peek()) {
      ss.push(el);
    }
  }

  private static int pop() {
    if (s.size() == 0) {
      return -1;
    }
    int ans = s.pop();
    s.pop();
    if (ans == ss.peek()) {
      ss.pop();
    }
    return ans;
  }

  private static boolean isEmpty() {
    return s.size() == 0;
  }

  private static int getMin() {
    if (ss.size() == 0) {
      return -1;
    }
    return ss.peek();
  }
}
