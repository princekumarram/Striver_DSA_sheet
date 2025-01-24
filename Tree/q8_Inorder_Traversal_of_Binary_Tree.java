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

        List<Integer> result = new ArrayList<>();

        Stack<TreeNode> st = new Stack<>();

        TreeNode current = root;

        while (current != null || !st.isEmpty()) {

            while (current != null) {
                st.push(current);
                current = current.left;
            }

            current = st.pop();

            result.add(current.data);

            current = current.right;

        }
        return result;

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
