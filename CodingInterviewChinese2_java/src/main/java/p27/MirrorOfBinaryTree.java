package p27;

import tools.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class MirrorOfBinaryTree {
    public static void mirrorRecursively(TreeNode treeNode) {
        if (treeNode==null)
            return;
        TreeNode temp = treeNode.left;
        treeNode.left = treeNode.right;
        treeNode.right = temp;
        mirrorRecursively(treeNode.left);
        mirrorRecursively(treeNode.right);
    }
    public static void mirrorIteratively(TreeNode treeNode) {
        if (treeNode==null)
            return;
        List<TreeNode> list = new LinkedList<>();
        list.add(treeNode);
        TreeNode temp;
        while (!list.isEmpty()) {
            treeNode = list.remove(0);
            temp = treeNode.left;
            treeNode.left = treeNode.right;
            treeNode.right = temp;
            if (treeNode.left!=null)
                list.add(treeNode.left);
            if (treeNode.right!=null)
                list.add(treeNode.right);
        }
    }
}
