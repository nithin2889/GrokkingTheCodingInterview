package stack;

import java.util.Stack;

public class MinStackWithoutExtraSpace {

  static int minElement;
  private static Stack<Integer> s = new Stack<>();
  private static Stack<Integer> ss = new Stack<>();

  public static void main(String[] args) throws Exception {
    System.out.println(isEmpty() ? "Stack is empty" : "Stack is not empty");
    push(18);
    push(19);
    push(29);
    System.out.println("Element at the top of the stack is: " + top());
    push(15);
    pop();
    push(16);
    System.out.println(isEmpty() ? "Stack is empty" : "Stack is not empty");
    System.out.println("minimum element is: " + getMin());
  }

  private static void push(int el) {
    if (s.size() == 0) {
      s.push(el);
      minElement = el;
    } else {
      if (el > minElement) {
        s.push(el);
      } else if (el < minElement) {
        s.push((2 * el) - minElement);
        minElement = el;
      }
    }
  }

  private static void pop() throws Exception {
    if (s.size() == 0) {
      throw new Exception("Stack underflow");
    } else {
      if (s.peek() >= minElement) {
        s.pop();
      } else if (s.peek() < minElement) {
        minElement = (2 * minElement) - s.peek();
        s.pop();
      }
    }
  }

  private static int top() {
    if (s.size() == 0) {
      return -1;
    }
    if (s.peek() >= minElement) {
      return s.peek();
    }
    return minElement;
  }

  private static int getMin() {
    if (s.size() == 0) {
      return -1;
    }
    return minElement;
  }

  private static boolean isEmpty() {
    return s.size() == 0;
  }
}
