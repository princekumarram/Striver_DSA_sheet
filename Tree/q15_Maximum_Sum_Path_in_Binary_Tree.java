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

public class q15_Maximum_Sum_Path_in_Binary_Tree {

    public static int getMaxPath(TreeNode root) {

        int maxi[] = { Integer.MIN_VALUE };

        maxPath(root, maxi);

        return maxi[0];
    }

    public static int maxPath(TreeNode root, int[] maxi) {

        if (root == null) {
            return 0;
        }

        int lh = Math.max(0, maxPath(root.left, maxi));
        int rh = Math.max(0, maxPath(root.right, maxi));

        // Update the overall maximum
        // path sum including the current node

        maxi[0] = Math.max(maxi[0], lh + rh + root.data);

        // Return the maximum sum considering
        // only one branch (either left or right)
        // along with the current node

        return Math.max(lh, rh) + root.data;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);
        root.left.right.right.right = new TreeNode(7);

        int ans = getMaxPath(root); // Call the static method directly

        System.out.println("The diameter of the tree is: " + ans);
    }

}
