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

public class q13_Check_Binary_Tree_is_Balanced_BT {

    /*
     * public static boolean checkBalance(TreeNode root) {
     * if (root == null)
     * return true;
     * 
     * int leftHeight = getHeight(root.left);
     * int rightHeight = getHeight(root.right);
     * 
     * if (Math.abs(leftHeight - rightHeight) <= 1 && checkBalance(root.left) &&
     * checkBalance(root.right)) {
     * return true;
     * }
     * return false;
     * }
     * 
     * static int getHeight(TreeNode root) {
     * if (root == null) {
     * return 0;
     * }
     * 
     * int lh = getHeight(root.left);
     * int rh = getHeight(root.right);
     * 
     * return 1 + Math.max(lh, rh);
     * }
     * 
     * public static void main(String[] args) {
     * 
     * TreeNode root = new TreeNode(1);
     * root.left = new TreeNode(2);
     * root.right = new TreeNode(3);
     * root.right.left = new TreeNode(4);
     * root.right.right = new TreeNode(6);
     * root.right.left.left = new TreeNode(5);
     * 
     * q13_Check_Binary_Tree_is_Balanced_BT solution = new
     * q13_Check_Binary_Tree_is_Balanced_BT();
     * 
     * if (solution.checkBalance(root)) {
     * System.out.println("This is balance Tree");
     * } else {
     * System.out.println("This is not balanced Tree");
     * }
     * }
     * 
     */

    public static boolean checkBalance(TreeNode root) {
        return checkHeight(root) != -1;
    }

    private static int checkHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1)
            return -1; // Left subtree is not balanced

        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1)
            return -1; // Right subtree is not balanced

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1; // Current node is not balanced
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(5);

        q13_Check_Binary_Tree_is_Balanced_BT solution = new q13_Check_Binary_Tree_is_Balanced_BT();

        if (solution.checkBalance(root)) {
            System.out.println("This is balance Tree");
        } else {
            System.out.println("This is not balanced Tree");
        }
    }
}
