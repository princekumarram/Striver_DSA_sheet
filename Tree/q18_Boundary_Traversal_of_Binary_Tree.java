import java.util.*;

class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}

public class q18_Boundary_Traversal_of_Binary_Tree {

    // Check if the node is a leaf
    public static boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    // Add left boundary nodes (excluding leaves)
    public static void addLeftBoundary(TreeNode root, List<Integer> res) {
        TreeNode curr = root.left;
        while (curr != null) {
            if (!isLeaf(curr)) {
                res.add(curr.data);
            }
            if (curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }

    // Add leaf nodes
    public static void addLeaves(TreeNode root, List<Integer> res) {
        if (isLeaf(root)) {
            res.add(root.data);
            return;
        }
        if (root.left != null) {
            addLeaves(root.left, res);
        }
        if (root.right != null) {
            addLeaves(root.right, res);
        }
    }

    // Add right boundary nodes (excluding leaves)
    public static void addRightBoundary(TreeNode root, List<Integer> res) {
        TreeNode curr = root.right;
        List<Integer> temp = new ArrayList<>();
        while (curr != null) {
            if (!isLeaf(curr)) {
                temp.add(curr.data);
            }
            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        // Add the nodes in reverse order
        for (int i = temp.size() - 1; i >= 0; --i) {
            res.add(temp.get(i));
        }
    }

    // Get the boundary traversal of the tree
    public static List<Integer> printBoundary(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        if (!isLeaf(root)) {
            res.add(root.data); // Add the root if it is not a leaf
        }
        addLeftBoundary(root, res);
        addLeaves(root, res);
        addRightBoundary(root, res);
        return res;
    }

    // Helper method to print the result
    public static void printResult(List<Integer> result) {
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // Get the boundary traversal
        List<Integer> result = printBoundary(root);

        // Print the result
        System.out.print("Boundary Traversal: ");
        printResult(result);
    }
}
