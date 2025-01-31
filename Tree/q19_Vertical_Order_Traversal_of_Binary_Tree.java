import java.util.*;

// Node class for the binary tree
class Node {
    int data;
    Node left, right;

    // Constructor to initialize the node with a value
    public Node(int val) {
        data = val;
        left = null;
        right = null;
    }
}

// Helper Pair class to store two values together
class Pair<U, V> {
    U first;
    V second;

    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }

    public U getKey() {
        return first;
    }

    public V getValue() {
        return second;
    }
}

public class q19_Vertical_Order_Traversal_of_Binary_Tree {

    // Function to perform vertical order traversal and return a 2D List of node
    // values
    public List<List<Integer>> findVertical(Node root) {
        if (root == null)
            return new ArrayList<>();

        // TreeMap to store nodes based on vertical and level information
        Map<Integer, Map<Integer, TreeSet<Integer>>> nodes = new TreeMap<>();

        // Queue for BFS traversal: each element is a pair containing node and its
        // vertical and level information
        Queue<Pair<Node, Pair<Integer, Integer>>> todo = new LinkedList<>();

        // Push the root node with initial vertical and level values (0,0)
        todo.add(new Pair<>(root, new Pair<>(0, 0)));

        // BFS traversal
        while (!todo.isEmpty()) {
            // Retrieve the node and its vertical and level information from the front of
            // the queue
            Pair<Node, Pair<Integer, Integer>> p = todo.poll();
            Node temp = p.getKey();
            int x = p.getValue().getKey();
            int y = p.getValue().getValue();

            // Store nodes based on vertical and level order
            nodes.computeIfAbsent(x, k -> new TreeMap<>())
                    .computeIfAbsent(y, k -> new TreeSet<>())
                    .add(temp.data);

            // Process left child
            if (temp.left != null) {
                todo.add(new Pair<>(temp.left, new Pair<>(x - 1, y + 1)));
            }

            // Process right child
            if (temp.right != null) {
                todo.add(new Pair<>(temp.right, new Pair<>(x + 1, y + 1)));
            }
        }

        // Prepare the final result list by combining values from the map
        List<List<Integer>> ans = new ArrayList<>();
        for (Map<Integer, TreeSet<Integer>> verticalNodes : nodes.values()) {
            List<Integer> col = new ArrayList<>();
            for (TreeSet<Integer> set : verticalNodes.values()) {
                col.addAll(set);
            }
            ans.add(col);
        }
        return ans;
    }

    // Helper function to print the result
    private static void printResult(List<List<Integer>> result) {
        for (List<Integer> level : result) {
            for (int node : level) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.left.left.right = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(3);
        root.right.right = new Node(10);
        root.right.left = new Node(9);

        // Create an instance of the class
        q19_Vertical_Order_Traversal_of_Binary_Tree tree = new q19_Vertical_Order_Traversal_of_Binary_Tree();

        // Get the vertical traversal
        List<List<Integer>> verticalTraversal = tree.findVertical(root);

        // Print the result
        System.out.println("Vertical Traversal");
        printResult(verticalTraversal);
    }
}
