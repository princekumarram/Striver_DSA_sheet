import java.util.*;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}

public class q7_Iterative_Preorder_Traversal_of_Binary_Tree {

    public List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>(); // Use ArrayList instead of List

        if (root == null) {
            return preorder;
        }

        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while (!st.isEmpty()) {
            root = st.pop();
            preorder.add(root.data); // Use root.data instead of root.val

            if (root.right != null) {
                st.push(root.right);
            }

            if (root.left != null) {
                st.push(root.left);
            }
        }
        return preorder;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        q7_Iterative_Preorder_Traversal_of_Binary_Tree sol = new q7_Iterative_Preorder_Traversal_of_Binary_Tree();
        List<Integer> result = sol.preOrderTraversal(root);

        for (int val : result) {
            System.out.print(val + " ");
        }

        System.out.println();
    }
}