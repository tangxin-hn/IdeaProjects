package p68;

import tools.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class CommonParentInTree {
    public static TreeNode getLastCommonParent(TreeNode root,TreeNode node1, TreeNode node2) {
        if (root==null || node1==null || node2==null)
            return null;
        List<TreeNode> list1 = new LinkedList<>();
        getNodePath(root,node1,list1);
        List<TreeNode> list2 = new LinkedList<>();
        getNodePath(root,node2,list2);
        return getLastCommonNode(list1,list2);
    }
    public static boolean getNodePath(TreeNode root,TreeNode node,List<TreeNode> list) {
        if (root==node) {
            return true;
        }
        list.add(root);
        if (root.left!=null && getNodePath(root.left,node,list)) {
            return true;
        }
        if (root.right!=null && getNodePath(root.left,node,list)) {
            return true;
        }
        list.remove(list.size()-1);
        return false;
    }
    private static TreeNode getLastCommonNode(List<TreeNode> list1,List<TreeNode> list2) {
        if (list1.size()==0 || list2.size()==0)
            return null;
        TreeNode temp = null;
        while (list1.size()>0 && list2.size()>0 && list1.get(0)==list2.get(0)) {
            temp = list1.remove(0);
            list2.remove(0);
        }
        return temp;
    }
}
