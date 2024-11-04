import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

//preorder-->   Left <-> Root <-> Right

class Node {
    int data;
    Node left;
    Node right;

    public Node(int val) {
        data = val;
        left = null;
        right = null;
    }
}

public class q3_preOrder_Traversal {

    // Function to initiate preorder traversal and return the resulting list

    static List<Integer> preOrder(Node root) {
        List<Integer> arr = new ArrayList<>();

        preorder(root, arr);
        return arr;

    }
    // function to perform preorder traversal of the tree and store values in 'arr'

    static void preorder(Node root, List<Integer> arr) {
        // if the current node is NULL (base case for recursion ),return

        if (root == null) {
            return;
        }
        // Push the current node's value into the list
        arr.add(root.data);
        // Recursively traverse the lest subtree
        preorder(root.left, arr);
        // Recursively traverse the right subtree
        preorder(root.right, arr);

    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(6);

        // Getting preorder traversal
        List<Integer> result = preOrder(root);

        // Displaying the preorder traversal result

        System.out.println("Preorder Traversal: ");

        // output each value in the preorder traversal result

        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

}
