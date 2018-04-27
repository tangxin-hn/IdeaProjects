package p24;

import tools.ListNode;

public class ReverseList {
    public static ListNode reverseList(ListNode head) {
        if (head==null || head.next==null)
            return head;
        ListNode fast = head.next;
        ListNode mid = head;
        ListNode slow = null;
        while (fast!=null) {
            mid.next = slow;
            slow = mid;
            mid = fast;
            fast = fast.next;
        }
        mid.next = slow;
        return mid;
    }

    public static ListNode reverseList2(ListNode head) {
        if (head==null || head.next==null)
            return head;
        ListNode newHead = head;
        while (newHead.next!=null)
            newHead = newHead.next;
        recursion(head);
        return newHead;
    }
    private static ListNode recursion(ListNode node) {
        if (node.next==null)
            return node;
        recursion(node.next).next = node;
        return node;
    }
}
