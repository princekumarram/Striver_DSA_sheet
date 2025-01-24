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

public class q14_Calculate_the_Diameter_Binary_Tree {

    static int diameter = 0; // Make diameter static

    public static int getDiameter(TreeNode root) {
        diameter = 0; // Reset diameter before calculation
        calculateHeight(root);
        return diameter;
    }

    static int calculateHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lh = calculateHeight(root.left);
        int rh = calculateHeight(root.right);

        // Update diameter
        diameter = Math.max(diameter, lh + rh);

        // Return height of the current node
        return 1 + Math.max(lh, rh);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        int ans = getDiameter(root); // Call the static method directly

        System.out.println("The diameter of the tree is: " + ans);
    }
}

// public class q14_Calculate_the_Diameter_Binary_Tree {

// public static int getDiameter(TreeNode root) {
// // Use an array to hold the diameter
// int[] diameter = new int[1]; // Mutable object to hold diameter

// help(root, diameter);

// return diameter[0]; // Return the diameter
// }

// public static int help(TreeNode root, int[] diameter) {
// if (root == null) {
// return 0;
// }

// int lh = help(root.left, diameter);
// int rh = help(root.right, diameter);

// // Update diameter
// diameter[0] = Math.max(diameter[0], lh + rh);

// // Return height of the current node
// return 1 + Math.max(lh, rh);
// }

// public static void main(String[] args) {
// TreeNode root = new TreeNode(1);
// root.left = new TreeNode(2);
// root.right = new TreeNode(3);
// root.left.left = new TreeNode(4);
// root.left.right = new TreeNode(5);

// int ans = getDiameter(root); // Call the static method directly

// System.out.println("The diameter of the tree is: " + ans);
// }
// }