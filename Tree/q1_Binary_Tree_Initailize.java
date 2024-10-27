
class Node {
    // Stores the vlue of the node
    int data;

    // Reference to the left child node
    Node left;
    // Refrence to the rigth child node
    Node right;

    public Node(int key) {
        // Assigns the provided key to the data field of the node
        data = key;
        // Initializes left child refrences as null
        left = null;
        right = null;
    }
}

public class q1_Binary_Tree_Initailize {

    public static void main(String[] args) {

        // Creates the root node with a key value of 1
        Node root = new Node(1);
        // Creates a left child node for
        // the root with a key value of 2
        root.left = new Node(2);
        // Creates a right child node for
        // the root with a key value of 3
        root.right = new Node(3);

        // Creates a left child node for the right
        // child node with a key value of 4

        root.right.left = new Node(5);
    }
}
