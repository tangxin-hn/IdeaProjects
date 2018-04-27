package p18;

import tools.ListNode;

public class DeleteNodeInList {
    public static ListNode deleteNode(ListNode head, ListNode deleted) {
        if (head==null || deleted==null)
            return head;
        System.out.println(deleted.val);
        if (head==deleted) {
            head = head.next;
        }
        if (deleted.next!=null) {
            deleted.val = deleted.next.val;
            deleted.next = deleted.next.next;
        } else {
            ListNode temp = head;
            while (temp.next!=deleted)
                temp = temp.next;
            temp.next = null;
        }
        return head;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for (int i=2;i<10;i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        for (int i=0;i<4;i++) {
            head = deleteNode(head, head);
            head = deleteNode(head, head.next);
        }
        head = deleteNode(head,head.next);
        head = deleteNode(head,head.next);
    }
}
