package p25;

import tools.ListNode;

public class MergeSortedLists {
    public static ListNode merge(ListNode head1,ListNode head2) {
        if (head1==null)
            return head2;
        else if (head2==null)
            return head1;
        ListNode head = null;
        if (head1.val<head2.val) {
            head = head1;
            head1 = head1.next;
        } else {
            head = head2;
            head2 = head2.next;
        }
        ListNode node = head;
        while (head1!=null && head2!=null) {
            if (head1.val<head2.val) {
                node.next = head1;
                node = node.next;
                head1 = head1.next;
            } else {
                node.next = head2;
                node = node.next;
                head2 = head2.next;
            }
        }
        if (head1==null)
            node.next = head2;
        else if (head2==null)
            node.next = head1;
        return head;
    }
}
