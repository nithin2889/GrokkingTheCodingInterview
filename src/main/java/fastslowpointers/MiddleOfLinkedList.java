package fastslowpointers;

public class MiddleOfLinkedList {

  /**
   * Given the head of a Singly LinkedList, write a method to return the middle node of the
   * LinkedList. If the total number of nodes in the LinkedList is even, return the second middle
   * node.
   *
   * Input: 1 -> 2 -> 3 -> 4 -> 5 -> null
   * Output: 3
   *
   * Input: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
   * Output: 4
   *
   * Input: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> null
   * Output: 4
   *
   * Solution:
   * One brute force strategy could be to first count the number of nodes in the LinkedList
   * and then find the middle node in the second iteration. Can we do this in one iteration?
   *
   * We can use the Fast & Slow pointers method such that the fast pointer is always twice
   * the nodes ahead of the slow pointer. This way, when the fast pointer reaches the end of
   * the LinkedList, the slow pointer will be pointing at the middle node.
   *
   * Time complexity:
   * The above algorithm will have a time complexity of O(N) where 'N' is the number of nodes
   * in the LinkedList.
   *
   * Space complexity #
   * The algorithm runs in constant space O(1).
   */
  public static ListNode findMiddle(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    System.out.println("Middle node: " + MiddleOfLinkedList.findMiddle(head).value);

    head.next.next.next.next.next = new ListNode(6);
    System.out.println("Middle node: " + MiddleOfLinkedList.findMiddle(head).value);

    head.next.next.next.next.next.next = new ListNode(7);
    System.out.println("Middle node: " + MiddleOfLinkedList.findMiddle(head).value);
  }
}
