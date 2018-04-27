package p32;

import tools.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class PrintTreeFromTopToBottom {
    public static void printFromTopToBottom(TreeNode root) {
        if (root==null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode temp = null;
        while (!queue.isEmpty()) {
            temp = queue.poll();
            System.out.print(temp.val + " ");
            if (temp.left!=null)
                queue.offer(temp.left);
            if (temp.right!=null)
                queue.offer(temp.right);
        }
    }
}
