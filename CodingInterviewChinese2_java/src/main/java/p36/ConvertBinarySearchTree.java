package p36;

import tools.TreeNode;

public class ConvertBinarySearchTree {
    public static TreeNode Convert(TreeNode root) {
        TreeNode lastNode = null;
        lastNode = ConvertNode(root,lastNode);
        while (lastNode!=null && lastNode.left!=null) {
            lastNode = lastNode.left;
        }
        return lastNode;
    }
    public static TreeNode ConvertNode(TreeNode root,TreeNode lastNode) {
        if (root==null)
            return null;
        if (root.left!=null)
            lastNode = ConvertNode(root.left,lastNode);
        root.left = lastNode;
        if (lastNode!=null)
            lastNode.right = root;
        lastNode = root;
        if (root.right!=null)
            lastNode = ConvertNode(root.right,lastNode);
        return lastNode;
    }

    // ====================测试代码====================
    public static void printDoubleLinkedList(TreeNode head) {
        TreeNode node = head;

        System.out.println("The nodes from left to right are:");
        while(node != null) {
            System.out.print(node.val + " ");
            if (node.right==null)
                break;
            node = node.right;
        }
        System.out.println();
        System.out.println("The nodes from right to left are:");
        while(node != null) {
            System.out.print(node.val + " ");
            if (node.left==null)
                break;
            node = node.left;
        }
        System.out.println();
    }
    public static void printTree(TreeNode root) {
        if (root==null)
            return;
        printTree(root.left);
        System.out.print(root.val + " ");
        printTree(root.right);
    }
    public static void test(String testName, TreeNode root)
    {
        if(testName != null)
            System.out.println(testName + " begins:");
        printTree(root);
        System.out.println();
        TreeNode head = Convert(root);
        printDoubleLinkedList(head);
    }
    public static void test1()
    {
        TreeNode pNode10 = new TreeNode(10);
        TreeNode pNode6 = new TreeNode(6);
        TreeNode pNode14 = new TreeNode(14);
        TreeNode pNode4 = new TreeNode(4);
        TreeNode pNode8 = new TreeNode(8);
        TreeNode pNode12 = new TreeNode(12);
        TreeNode pNode16 = new TreeNode(16);

        pNode10.left = pNode6;
        pNode10.right = pNode14;
        pNode6.left = pNode4;
        pNode6.right = pNode8;
        pNode14.left = pNode12;
        pNode14.right = pNode16;

        test("Test1", pNode10);
    }
    public static void main(String[] args) {
        test1();
    }
}
