import java.util.*;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class q9_Iterative_Postorder_2_Stacks {

    public static List<Integer> IterativePostoder(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();

        TreeNode curr = root;

        st1.push(curr);

        while (!st1.isEmpty()) {
            curr = st1.pop();
            st2.push(curr);

            if (curr.left != null) {
                st1.push(curr.left);
            }

            if (curr.right != null) {
                st1.push(curr.right);
            }

        }

        while (!st2.isEmpty()) {
            curr = st2.pop();
            result.add(curr.data);
        }
        return result;

    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(IterativePostoder(root));

    }

}
