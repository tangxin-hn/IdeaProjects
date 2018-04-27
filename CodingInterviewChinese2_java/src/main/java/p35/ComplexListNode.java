package p35;

public class ComplexListNode {
    public int val;
    public ComplexListNode next;
    public ComplexListNode sibling;
    ComplexListNode() { }
    ComplexListNode(int val) { this.val = val; }
    ComplexListNode(int val,ComplexListNode next,ComplexListNode sibling) {
        this.val = val;
        this.next = next;
        this.sibling = sibling;
    }
    public static void BuildNodes(ComplexListNode node,ComplexListNode next,ComplexListNode sibling) {
        if (node!=null) {
            node.next = next;
            node.sibling = sibling;
        }
    }
    public static void printList(ComplexListNode head) {
        ComplexListNode temp = head;
        while(temp != null)
        {
            System.out.print("The value of this node is: " + temp.val + ",");

            if(temp.sibling != null)
                System.out.println("The value of its sibling is: " + temp.sibling.val + ".");
            else
                System.out.println("This node does not have a sibling.");
            temp = temp.next;
        }
    }
}
