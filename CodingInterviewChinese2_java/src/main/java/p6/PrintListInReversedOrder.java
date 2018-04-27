package p6;

import tools.ListNode;

import java.util.Stack;

public class PrintListInReversedOrder {
    void printListReversingly_Iteratively(ListNode head){
        ListNode temp=head;
        Stack<ListNode> stack = new Stack<>();
        while (temp!=null) {
            stack.push(temp);
            temp = temp.next;
        }
        while (!stack.empty()) {
            temp = stack.pop();
            System.out.println(temp.val);
        }
    }
}
