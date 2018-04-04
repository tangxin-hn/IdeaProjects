package p7;

import tools.TreeNode;

public class ConstructBinaryTree {
    static TreeNode Construct(int[] preorder, int[] inorder) throws Exception{
        if (preorder==null || inorder==null)
            return null;
        TreeNode root = null;
        try {
           root = ConstructCore(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
        } catch (Exception e) {
            throw e;
        }
        return root;
    }

    static TreeNode ConstructCore(int[] preorder, int startPreorder, int endPreorder,
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
            root.left = ConstructCore(preorder,startPreorder+1,startPreorder+posRoot-startInorder,
                    inorder,startInorder,posRoot-1);
        }
        if (posRoot<endInorder) {
            root.right = ConstructCore(preorder,startPreorder+posRoot-startInorder+1, endPreorder,
                    inorder,posRoot+1,endInorder);
        }
        return root;
    }
    static void Test(String testName, int[] preorder, int[] inorder, int length)
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
            TreeNode root = Construct(preorder, inorder);
            PrintTree(root);
            System.out.println();
        } catch(Exception e){
            System.out.println("Invalid Input.\n");
        }
    }
    static void PrintTree(TreeNode root) {
        if (root==null)
            return;
        System.out.print(root.val+" ");
        PrintTree(root.left);
        PrintTree(root.right);
    }

    static void Test1()
    {
        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};
        Test("Test1", preorder, inorder,8);
    }
    static void Test2()
    {
        int[] preorder = {1, 2, 3, 4, 5};
        int[] inorder = {5, 4, 3, 2, 1};
        Test("Test2", preorder, inorder,5);
    }
    static void Test3()
    {
        int[] preorder = {1, 2, 3, 4, 5};
        int[] inorder = {1, 2, 3, 4, 5};
        Test("Test3", preorder, inorder,5);
    }
    static void Test4()
    {
        int[] preorder = {1};
        int[] inorder = {1};
        Test("Test4", preorder, inorder,1);
    }
    static void Test5()
    {
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = {4, 2, 5, 1, 6, 3, 7};
        Test("Test5", preorder, inorder,7);
    }
    static void Test6()
    {
        Test("Test6", null, null,0);
    }
    static void Test7()
    {
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = {4, 2, 8, 1, 6, 3, 7};
        Test("Test7", preorder, inorder,7);
    }

    public static void main(String[] args) {
        Test1();
        Test2();
        Test3();
        Test4();
        Test5();
        Test6();
        Test7();
    }
}
