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

public class q10_Iterative_Postorder_1_Stacks {

    public static List<Integer> IterativePostoder(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        TreeNode lastVisited = null;

        while (curr != null || !st.isEmpty()) {
            // Reach the leftmost node of the current node
            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }

            // Peek the node from the stack
            curr = st.peek();

            // If the right child is null or already visited, process the current node
            if (curr.right == null || curr.right == lastVisited) {
                result.add(curr.data);
                lastVisited = st.pop(); // Mark this node as visited
                curr = null; // Set current to null to process the next node in stack
            } else {
                // If right child exists, go to the right child
                curr = curr.right;
            }
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