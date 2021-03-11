package fastslowpointers;

public class PalindromeLinkedList {

  /**
   * Given the head of a Singly LinkedList, write a method to check if the LinkedList is a
   * palindrome or not.
   * <p>
   * Your algorithm should use constant space and the input LinkedList should be in the original
   * form once the algorithm is finished. The algorithm should have O(N) time complexity where ‘N’
   * is the number of nodes in the LinkedList.
   * <p>
   * Input: 2 -> 4 -> 6 -> 4 -> 2 -> null Output: true
   * <p>
   * Input: 2 -> 4 -> 6 -> 4 -> 2 -> 2 -> null Output: false
   * <p>
   *
   * Solution: As we know, a palindrome LinkedList will have nodes values that read the same
   * backward or forward. This means that if we divide the LinkedList into two halves, the node
   * values of the first half in the forward direction should be similar to the node values of the
   * second half in the backward direction. As we have been given a Singly LinkedList, we can’t move
   * in the backward direction. To handle this, we will perform the following steps:
   * <p>
   * 1. We can use the Fast & Slow pointers method similar to Middle of the LinkedList to find the
   * middle node of the LinkedList.
   * 2. Once we have the middle of the LinkedList, we will reverse the
   * second half.
   * 3. Then, we will compare the first half with the reversed second half to see if the
   * LinkedList represents a palindrome.
   * 4. Finally, we will reverse the second half of the LinkedList
   * again to revert and bring the LinkedList back to its original form.
   *
   * Time complexity:
   * The above algorithm will have a time complexity of O(N) where ‘N’ is the number of nodes in the LinkedList.
   *
   * Space complexity:
   * The algorithm runs in constant space O(1).
   */
  public static boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) {
      return true;
    }

    // find middle of the LinkedList
    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    // reverse the second half
    ListNode headSecondHalf = reverse(slow);
    ListNode copyHeadSecondHalf = headSecondHalf;

    while (head != null && headSecondHalf != null) {
      if (head.value != headSecondHalf.value) {
        break; //not palindrome
      }

      head = head.next;
      headSecondHalf = headSecondHalf.next;
    }

    // revert the reverse of the second half
    headSecondHalf = reverse(copyHeadSecondHalf);

    // if both halves match, return true else return false
    if (head == null || headSecondHalf == null) {
      return true;
    }
    return false;
  }

  private static ListNode reverse(ListNode slow) {
    ListNode prev = null;
    while (slow != null) {
      ListNode next = slow.next;
      slow.next = prev;
      prev = slow;
      slow = next;
    }
    return prev;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(2);
    head.next = new ListNode(4);
    head.next.next = new ListNode(6);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(2);
    System.out.println("Linked List has cycle: " + PalindromeLinkedList.isPalindrome(head));

    head.next.next.next.next.next = new ListNode(2);
    System.out.println("Linked List has cycle: " + PalindromeLinkedList.isPalindrome(head));
  }
}
