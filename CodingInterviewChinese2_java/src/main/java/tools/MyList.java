package tools;

public class MyList {
    Node head = null;
    class Node{
        Node next = null;
        int value = 0;
        public Node(int value) {
            this.value = value;
        }
    }
    public void AddToTail(int value) {
        Node tail = new Node(value);
        if (head==null) {
            head = tail;
        } else {
            Node temp = head;
            while (temp.next!=null) {
                temp = temp.next;
            }
            temp.next = tail;
        }
    }
    public void RemoveNode(int value) {
        if (head==null)
            return;
        Node temp = head;
        if (value==head.value) {
            head = head.next;
        } else {
            while (temp.next!=null && temp.next.value!=value)
                temp = temp.next;
            if (temp.next==null)
                return;
            else {
                temp.next = temp.next.next;
            }
        }
    }
}
