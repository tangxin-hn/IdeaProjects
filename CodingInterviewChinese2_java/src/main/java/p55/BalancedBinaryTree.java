package p55;

import tools.TreeNode;

public class BalancedBinaryTree {
    public static boolean isBalanced(TreeNode root) {
        if (root==null)
            return true;
        return isBalanced(root.left) && isBalanced(root.right) &&
                    Math.abs(TreeDepth.getTreeDepth(root.left)-TreeDepth.getTreeDepth(root.right))<=0;
    }
    public static boolean isBalanced2(TreeNode root) {
        int[] depth = new int[1];
        return isBalanced2(root,depth);
    }
    public static boolean isBalanced2(TreeNode root,int[] depth) {
        if (root==null) {
            depth[0] = 0;
            return true;
        }
        int[] left = new int[1];
        int[] right = new int[1];
        if (isBalanced2(root.left,left) && isBalanced2(root.right,right)) {
            int diff = left[0] - right[0];
            if (diff >= -1 && diff <= 1) {
                depth[0] = 1 + (left[0]>right[0]?left[0]:right[0]);
                return true;
            }
        }
        return false;
    }
}
