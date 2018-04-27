package p34;

import tools.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PathInTree {
    public static void findPath(TreeNode root, int expectedSum) {
        if (root==null)
            return;
        List<TreeNode> list = new LinkedList<>();
        findPath(root,expectedSum,list);
    }
    public static void findPath(TreeNode root, int expectedSum,List<TreeNode> list) {
        if (root==null && expectedSum==0) {
            System.out.print("A path is found: ");
            for (int i=0;i<list.size();i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        } else if (root==null)
            return;
        list.add(root);
        findPath(root.left,expectedSum-root.val,list);
        findPath(root.right,expectedSum-root.val,list);
        list.remove(list.size()-1);
    }
}
