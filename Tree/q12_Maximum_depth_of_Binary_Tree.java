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

public class q12_Maximum_depth_of_Binary_Tree {

    public static int getMaxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int lh = getMaxDepth(root.left);
        int rh = getMaxDepth(root.right);

        return 1 + Math.max(lh, rh);
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(5);

        q12_Maximum_depth_of_Binary_Tree solution = new q12_Maximum_depth_of_Binary_Tree();
        int depth = solution.getMaxDepth(root);
        System.out.println("Maximum depth of binary tree " + depth);

    }

}
