package fastslowpointers;

public class RearrangeLinkedList {

  public static void reorder(ListNode head) {
    if(head == null || head.next == null)
      return;

    // find the middle node
    ListNode slow = head, fast = head;
    while(fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }

    ListNode headFirstHalf = head;
    // reverse the second half of the linked list.
    ListNode headSecondHalf = reverse(slow);

    // rearrange to produce the linked list in the required order
    while(headFirstHalf != null && headSecondHalf != null) {

    }
  }

  public static ListNode reverse(ListNode slow) {
    return null;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(2);
    head.next = new ListNode(4);
    head.next.next = new ListNode(6);
    head.next.next.next = new ListNode(8);
    head.next.next.next.next = new ListNode(10);
    head.next.next.next.next.next = new ListNode(12);
  }
}
