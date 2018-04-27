package p8;

import tools.TreeNode;

public class NextNodeInBinaryTrees {
    TreeNode getNext(TreeNode pNode){
        if (pNode==null)
            return null;
        if (pNode.right!=null) {
            pNode = pNode.right;
            while (pNode.left!=null)
                pNode = pNode.left;
        } else if (pNode.parent!=null) {
            while (pNode.parent!=null && pNode==pNode.parent.right)
                pNode = pNode.parent;
            pNode = pNode.parent;
        } else {
            pNode = null;
        }
        return pNode;
    }
}
