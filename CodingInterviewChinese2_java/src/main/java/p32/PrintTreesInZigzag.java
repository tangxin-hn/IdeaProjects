package p32;

import tools.TreeNode;

import java.util.Stack;

public class PrintTreesInZigzag {
    public static void print(TreeNode root) {
        if (root==null)
            return;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        TreeNode temp = null;
        while (!stack1.empty()) {
            temp = stack1.pop();
            System.out.print(temp.val + " ");
            if (temp.right!=null)
                stack2.push(temp.right);
            if (temp.left!=null)
                stack2.push(temp.left);
            if (stack1.empty()) {
                System.out.println();
                Stack<TreeNode> stack = stack1;
                stack1 = stack2;
                stack2 = stack;
            }
        }
    }
}
