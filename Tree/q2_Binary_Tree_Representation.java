
import java.util.*;
import java.util.ArrayList;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class q2_Binary_Tree_Representation {
    public static Node createTree(List<Integer> arr) {
        if (arr == null || arr.isEmpty())
            return null;

        Node root = new Node(arr.get(0));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int index = 1;

        while (!queue.isEmpty() && index < arr.size()) {
            Node current = queue.poll();

            // Assign left child if there's an available element
            if (index < arr.size()) {
                current.left = new Node(arr.get(index++));
                queue.add(current.left);
            }

            // Assign right child if there's an available element
            if (index < arr.size()) {
                current.right = new Node(arr.get(index++));
                queue.add(current.right);
            }
        }
        return root;
    }

    // Preorder traversal to print the tree
    public static void printTreePreOrder(Node root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        printTreePreOrder(root.left);
        printTreePreOrder(root.right);
    }

    // Level order traversal to display the structure
    public static void printTreeLevelOrder(Node root) {
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");
            if (current.left != null)
                queue.add(current.left);
            if (current.right != null)
                queue.add(current.right);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Integer> nodes = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        Node root = createTree(nodes);

        System.out.println("Preorder traversal:");
        printTreePreOrder(root);

        System.out.println("\nLevel order traversal:");
        printTreeLevelOrder(root);
    }
}
