package p35;

public class CopyComplexList {
    public static ComplexListNode cloneList(ComplexListNode head){
        if (head==null)
            return null;
        CloneNodes(head);
        ConnectSiblingNodes(head);
        return ReconnectNodes(head);
    }
    public static void CloneNodes(ComplexListNode head) {
        ComplexListNode temp = head;
        while (temp!=null) {
            ComplexListNode newNode = new ComplexListNode(temp.val);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = newNode.next;
        }
    }
    public static void ConnectSiblingNodes(ComplexListNode head){
        ComplexListNode temp = head;
        while (temp!=null) {
            if (temp.sibling!=null) {
                temp.next.sibling = temp.sibling.next;
            }
            temp = temp.next.next;
        }
    }
    public static ComplexListNode ReconnectNodes(ComplexListNode head) {
        ComplexListNode newHead = head.next;
        ComplexListNode temp1 = head;
        ComplexListNode temp2 = newHead;
        while (temp1!=null) {
            temp1.next = temp1.next.next;
            if (temp2.next!=null)
                temp2.next = temp2.next.next;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return newHead;
    }
}
