import java.util.*;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}

public class q16_Check_Two_Tree_Same_Or_not {

    public static boolean isIdentical(TreeNode root1, TreeNode root2) {

        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        boolean lh = isIdentical(root1.left, root2.left);
        boolean rh = isIdentical(root1.right, root2.right);

        return (root1.data == root2.data) && lh && rh;
    }

    public static void main(String[] args) {
        // Node1
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);

        // Node2
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);

        q16_Check_Two_Tree_Same_Or_not solution = new q16_Check_Two_Tree_Same_Or_not();

        if (solution.isIdentical(root1, root2)) {
            System.out.println("The binary trees are identical.");
        } else {
            System.out.println("The binary trees are not identical.");
        }
    }
}