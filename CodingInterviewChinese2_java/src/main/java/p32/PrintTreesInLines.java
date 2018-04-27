package p32;

import tools.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class PrintTreesInLines {
    public static void print(TreeNode root) {
        if (root==null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode temp = null;
        int count = queue.size();
        while (!queue.isEmpty()) {
            if (count==0) {
                System.out.println();
                count = queue.size();
            }
            temp = queue.poll();
            System.out.print(temp.val + " ");
            if (temp.left!=null)
                queue.offer(temp.left);
            if (temp.right!=null)
                queue.offer(temp.right);
            count--;
        }
    }
}
