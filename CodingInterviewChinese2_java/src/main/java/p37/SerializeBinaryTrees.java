package p37;

import tools.TreeNode;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class SerializeBinaryTrees {
    public static void serializeBinaryTrees(TreeNode root, OutputStreamWriter os) throws IOException{
        if (root==null) {
            os.write("$ ");
            return;
        }
        os.write(root.val + " ");
        serializeBinaryTrees(root.left,os);
        serializeBinaryTrees(root.right,os);
    }
    public static TreeNode rebuildBinaryTrees(Scanner is) throws IOException {
        if (!is.hasNextInt()) {
            is.next();
            return null;
        }
        TreeNode root = new TreeNode(is.nextInt());
        root.left = rebuildBinaryTrees(is);
        root.right = rebuildBinaryTrees(is);
        return root;
    }
    public static boolean isSameTree(TreeNode root1,TreeNode root2) {
        if (root1==null && root2==null)
            return true;
        else if (root1==null || root2==null)
            return false;
        if (root1.val!=root2.val)
            return false;
        return isSameTree(root1.left,root2.left) && isSameTree(root1.right,root2.right);
    }
    public static void test(String testName, TreeNode root) throws IOException {
        if (testName!=null)
            System.out.print(testName + " begins:");
        File f = new File("tree.txt");
        FileOutputStream fop = new FileOutputStream(f);
        OutputStreamWriter writer = new OutputStreamWriter(fop, "UTF-8");
        serializeBinaryTrees(root,writer);
        writer.close();
        fop.close();

        Scanner scanner = new Scanner(f);
        TreeNode root2 = rebuildBinaryTrees(scanner);
        scanner.close();
        System.out.println(isSameTree(root,root2));
    }
    public static void test1() throws IOException {
        TreeNode pNode8 = new TreeNode(8);
        TreeNode pNode6 = new TreeNode(6);
        TreeNode pNode10 = new TreeNode(10);
        TreeNode pNode5 = new TreeNode(5);
        TreeNode pNode7 = new TreeNode(7);
        TreeNode pNode9 = new TreeNode(9);
        TreeNode pNode11 = new TreeNode(11);

        pNode8.left = pNode6;
        pNode8.right = pNode10;
        pNode6.left = pNode5;
        pNode6.right = pNode7;
        pNode10.left = pNode9;
        pNode10.right = pNode11;

        test("Test1", pNode8);
    }
    public static void main(String[] args) throws IOException {
        test1();
    }
}
