package p55;

import tools.TreeNode;

public class TreeDepth {
    public static int getTreeDepth(TreeNode root) {
        if (root==null)
            return 0;
        int left = getTreeDepth(root.left);
        int right = getTreeDepth(root.right);
        return Math.max(left,right) + 1;
    }
}
