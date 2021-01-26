package fastslowpointers;

public class CyclicLinkedListLength002 {

  public static int findCycleLength(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;

    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;

      if (fast == slow) {
        return calculateLength(slow);
      }
    }
    return 0;
  }

  private static int calculateLength(ListNode slow) {
    ListNode current = slow;
    int cycleLength = 0;

    do {
      current = current.next;
      cycleLength++;
    } while (current != slow);
    return cycleLength;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next = new ListNode(6);
    head.next.next.next.next.next.next = head.next.next;

    System.out
        .println("Linked List cycle length: " + CyclicLinkedListLength002.findCycleLength(head));

    head.next.next.next.next.next.next = head.next.next.next;
    System.out
        .println("Linked List cycle length: " + CyclicLinkedListLength002.findCycleLength(head));
  }
}
