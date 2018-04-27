package p26;

import sort.HeapSort;
import tools.TreeNode;

public class SubstructureInTree {
    public static boolean HasSubtree(TreeNode tree1,TreeNode tree2){
        if (tree2==null) {
            return true;
        } else if (tree1==null) {
            return false;
        }
        if (Double.doubleToLongBits(tree1.val)==Double.doubleToLongBits(tree2.val))
            if (doesTree1HaveTree2(tree1,tree2))
                return true;
        return HasSubtree(tree1.left,tree2) || HasSubtree(tree1.right,tree2);
    }
    public static boolean doesTree1HaveTree2 (TreeNode tree1, TreeNode tree2) {
        if (tree2==null)
            return true;
        else if (tree1==null)
            return false;
        if (Double.doubleToLongBits(tree1.val)!=Double.doubleToLongBits(tree2.val))
            return false;
        return doesTree1HaveTree2(tree1.left,tree2.left) && doesTree1HaveTree2(tree1.right,tree2.right);
    }
}
