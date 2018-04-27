package p52;

import tools.ListNode;

public class FirstCommonNodesInLists {
    public static ListNode findFirstCommonNode(ListNode head1,ListNode head2) {
        if (head1==null || head2==null)
            return null;
        int len1 = getLength(head1);
        int len2 = getLength(head2);
        if (len1>len2) {
            for (int i=0;i<len1-len2;i++)
                head1 = head1.next;
        } else {
            for (int i=0;i<len2-len1;i++)
                head2 = head2.next;
        }
        while (head1!=null) {
            if (head1==head2)
                return head1;
            head1 = head1.next;
            head2 = head2.next;
        }
        return null;
    }
    public static int getLength(ListNode head) {
        int count = 0;
        while (head!=null) {
            head = head.next;
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        ListNode pNode1 = new ListNode(1);
        ListNode pNode2 =  new ListNode(2);
        ListNode pNode3 =  new ListNode(3);
        ListNode pNode4 =  new ListNode(4);
        ListNode pNode5 =  new ListNode(5);
        ListNode pNode6 =  new ListNode(6);
        ListNode pNode7 =  new ListNode(7);

        pNode1.next = pNode2;
        pNode2.next = pNode3;
        pNode3.next = pNode6;
        pNode4.next = pNode5;
        pNode5.next =pNode7;
        pNode6.next = pNode7;

        System.out.println(findFirstCommonNode(pNode1,pNode4).val);
    }
}
