package p54;

import tools.TreeNode;

public class KthNodeInBST {
    private static int count = 0;
    public static TreeNode getKthNode(TreeNode root, int k) {
        if (root==null)
            return null;
        TreeNode treeNode = getKthNode(root.left,k);
        if (treeNode != null)
            return treeNode;
        count++;
        if (count==k)
            return root;
        treeNode = getKthNode(root,k);
        if (treeNode != null)
            return treeNode.right;
        return null;
    }
}
