import java.util.*;

//Node structure for the binary tree

class Node {
    int data;
    Node left;
    Node right;

    // Constructor to initialize the node with a value

    public Node(int val) {
        data = val;
        left = null;
        right = null;
    }
}

public class q20_Top_View_of_Binary_Tree {

    // function to return the top view of the binary tree
    public List<Integer> topView(Node root) {
        List<Integer> ans = new ArrayList<>();

        // check if the tree is empty
        if (root == null) {
            return ans;
        }

        // Map to store top view
        Map<Integer, Integer> mpp = new TreeMap<>();

        Queue<Pair<Node, Integer>> q = new LinkedList<>();

        q.add(new Pair<>(root, 0));

        // BFS traversal
        while (!q.isEmpty()) {
            Pair<Node, Integer> pair = q.poll();
            Node node = pair.getKey();
            int line = pair.getValue();

            if (!mpp.containsKey(line)) {
                mpp.put(line, node.data);
            }

            // Process left child
            if (node.left != null) {
                q.add(new Pair<>(node.left, line - 1));
            }

            // Process right child
            if (node.right != null) {
                q.add(new Pair<>(node.right, line + 1));
            }
        }

        for (int value : mpp.values()) {
            ans.add(value);
        }

        return ans;
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.left.left.right = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(3);
        root.right.right = new Node(10);
        root.right.left = new Node(9);

        q20_Top_View_of_Binary_Tree solution = new q20_Top_View_of_Binary_Tree();

        // Get the top view traversal
        List<Integer> topView = solution.topView(root);

        // Print the result
        System.out.println("Vertical Traversal: ");
        for (int node : topView) {
            System.out.print(node + " ");
        }
    }
}
