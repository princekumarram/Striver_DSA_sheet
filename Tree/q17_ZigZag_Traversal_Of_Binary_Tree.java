// Create a hard coded tree.
//         20
//       /   \
//      8     22
//    /  \     \
//   4   12    11
//      /  \
//     10   14

//output

//      20
//     22 8
//   4 12 11 
//    14 10 

import java.util.*;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}

public class q17_ZigZag_Traversal_Of_Binary_Tree {

    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        q17_ZigZag_Traversal_Of_Binary_Tree solution = new q17_ZigZag_Traversal_Of_Binary_Tree();

        // Get the zigzag level order traversal
        List<List<Integer>> result = solution.ZigZagLevelOrder(root);

        // Print the result
        printResult(result);
    }

}
