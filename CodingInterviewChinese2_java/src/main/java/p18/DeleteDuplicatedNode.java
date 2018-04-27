package p18;

import tools.ListNode;

public class DeleteDuplicatedNode {
    public static ListNode deleteDuplicatedNode(ListNode head) {
        if (head==null)
            return head;
        ListNode redundancy = new ListNode(0);
        redundancy.next = head;
        ListNode first = redundancy;
        ListNode second = first.next;
        while (second!=null && second.next!=null) {
            if (second.next.val!=second.val) {
                first = second;
                second = second.next;
            } else {
                while (second.next!=null && second.next.val==second.val){
                    second = second.next;
                }
                second = second.next;
                first.next = second;
            }
        }
        return redundancy.next;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        temp.next = new ListNode(1);
        temp = temp.next;
        temp.next = new ListNode(2);
        temp = temp.next;
        temp.next = new ListNode(3);
        temp = temp.next;
        temp.next = new ListNode(3);
        temp = temp.next;
        temp.next = new ListNode(4);
        temp = temp.next;
        temp.next = new ListNode(4);
        temp = temp.next;
        temp.next = new ListNode(5);
        temp = temp.next;
        temp.next = new ListNode(5);
        temp = temp.next;

        head = deleteDuplicatedNode(head);

        temp = head;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
