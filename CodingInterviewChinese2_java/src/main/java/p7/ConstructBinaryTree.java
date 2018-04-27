package p7;

import tools.TreeNode;

public class ConstructBinaryTree {
    static TreeNode construct(int[] preorder, int[] inorder) throws Exception{
        if (preorder==null || inorder==null)
            return null;
        TreeNode root = null;
        try {
           root = constructCore(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
        } catch (Exception e) {
            throw e;
        }
        return root;
    }

    static TreeNode constructCore(int[] preorder, int startPreorder, int endPreorder,
                           int[] inorder, int startInorder, int endInorder) throws Exception{
        TreeNode root = new TreeNode(preorder[startPreorder]);
        if (startPreorder==endPreorder) {
            if (startInorder==endInorder && preorder[startPreorder]==inorder[startInorder])
                return root;
            else {
                throw new Exception("Invalid input.");
            }
        }

        int posRoot = -1;
        for (int i=startInorder;i<=endInorder;i++) {
            if (inorder[i]==root.val) {
                posRoot = i;
                break;
            }
        }
        if (posRoot==-1) {
            throw new Exception("Invalid input.");
        }
        if (posRoot>startInorder) {
            root.left = constructCore(preorder,startPreorder+1,startPreorder+posRoot-startInorder,
                    inorder,startInorder,posRoot-1);
        }
        if (posRoot<endInorder) {
            root.right = constructCore(preorder,startPreorder+posRoot-startInorder+1, endPreorder,
                    inorder,posRoot+1,endInorder);
        }
        return root;
    }
    static void test(String testName, int[] preorder, int[] inorder, int length)
    {
        if(testName != null)
            System.out.println(testName + " begins:");

        System.out.print("The preorder sequence is: ");
        for(int i = 0; i < length; ++ i)
            System.out.print(preorder[i]+" ");
        System.out.println();

        System.out.print("The inorder sequence is: ");
        for(int i = 0; i < length; ++ i)
            System.out.print(inorder[i]+" ");
        System.out.println();

        try {
            TreeNode root = construct(preorder, inorder);
            printTree(root);
            System.out.println();
        } catch(Exception e){
            System.out.println("Invalid Input.\n");
        }
    }
    static void printTree(TreeNode root) {
        if (root==null)
            return;
        System.out.print(root.val+" ");
        printTree(root.left);
        printTree(root.right);
    }

    static void test1()
    {
        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};
        test("test1", preorder, inorder,8);
    }
    static void test2()
    {
        int[] preorder = {1, 2, 3, 4, 5};
        int[] inorder = {5, 4, 3, 2, 1};
        test("test2", preorder, inorder,5);
    }
    static void test3()
    {
        int[] preorder = {1, 2, 3, 4, 5};
        int[] inorder = {1, 2, 3, 4, 5};
        test("test3", preorder, inorder,5);
    }
    static void test4()
    {
        int[] preorder = {1};
        int[] inorder = {1};
        test("test4", preorder, inorder,1);
    }
    static void test5()
    {
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = {4, 2, 5, 1, 6, 3, 7};
        test("test5", preorder, inorder,7);
    }
    static void test6()
    {
        test("test6", null, null,0);
    }
    static void test7()
    {
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = {4, 2, 8, 1, 6, 3, 7};
        test("test7", preorder, inorder,7);
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
    }
}
