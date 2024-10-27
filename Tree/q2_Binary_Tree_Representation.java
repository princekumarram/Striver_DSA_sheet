import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//Definition for the binary tree node

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

public class q2_Binary_Tree_Representation {

    public static void CreateTree(Node root0, ArrayList<Integer> v) {
        if (root0 == null || v == null || v.isEmpty())
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root0);
        int index = 0;

        // Start filling the tree in level order
        while (!queue.isEmpty() && index < v.size()) {
            Node current = queue.poll();

            // Set the value for the current node
            current.data = v.get(index++);

            // Creates left and right children if there are more elements
            if (index < v.size()) {
                current.left = new Node(v.get(index++));
                queue.add(current.left);
            }

            if (index < v.size()) {
                current.right = new Node(v.get(index++));
                queue.add(current.right);
            }
        }
    }

    public static void main(String[] args) {

    }

}
