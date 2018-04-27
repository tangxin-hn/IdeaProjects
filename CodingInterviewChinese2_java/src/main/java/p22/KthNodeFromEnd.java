package p22;

import tools.ListNode;

public class KthNodeFromEnd {
    public static ListNode findKthToTail(ListNode head,int k) {
        if (k<=0 || head==null)
            return null;
        ListNode temp = head;
        for (int i=0;i<k;i++) {
            if (temp==null)
                return null;
            temp = temp.next;
        }
        while (temp!=null) {
            temp = temp.next;
            head = head.next;
        }
        return head;
    }
}
