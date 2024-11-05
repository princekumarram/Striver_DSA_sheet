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

public class q8_Inorder_Traversal_of_Binary_Tree {

    // BY USING STACK METHOD-1

    /*
     * public static List<Integer> InorderTraversal(TreeNode root) {
     * 
     * if (root == null)
     * return null;
     * 
     * List<Integer> result = new ArrayList<>();
     * 
     * Stack<TreeNode> st = new Stack<>();
     * 
     * TreeNode curr = root;
     * 
     * while (curr != null || !st.isEmpty()) {
     * 
     * while (curr != null) {
     * st.push(curr);
     * curr = curr.left;
     * }
     * 
     * curr = st.pop();
     * 
     * result.add(curr.data);
     * 
     * curr = curr.right;
     * 
     * }
     * 
     * return result;
     * 
     * }
     * 
     */

    // BY USING RECURSION METHODE -2
    public static List<Integer> InorderTraversal(TreeNode root) {

        List<Integer> arr = new ArrayList<>();

        preorder(root, arr);

        return arr;

    }

    public static void preorder(TreeNode root, List<Integer> arr) {

        if (root == null) {
            return;
        }

        preorder(root.left, arr);

        arr.add(root.data);

        preorder(root.right, arr);
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(InorderTraversal(root));

    }

}
