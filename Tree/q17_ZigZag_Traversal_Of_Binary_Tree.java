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

// import java.util.*;
// import java.util.ArrayList;
// import java.util.LinkedList;
// import java.util.List;
// import java.util.Queue;

// class TreeNode {
//     int data;
//     TreeNode left;
//     TreeNode right;

//     TreeNode(int data) {
//         this.data = data;
//         this.left = null;
//         this.right = null;
//     }
// }

// public class q17_ZigZag_Traversal_Of_Binary_Tree {

//     public static List<List<Integer>> ZigZagLevelOrder(TreeNode root) {
//         List<List<Integer>> result = new ArrayList<>();

//         if (root == null) {
//             return result;
//         }

//         Queue<TreeNode> q = new LinkedList<>();

//         q.add(root);

//         boolean LeftToRight = true;

//         while (!q.isEmpty()) {

//             int size = q.size();
//             List<Integer> row = new ArrayList<>();

//             for (int i = 0; i < size; i++) {

//                 TreeNode node = q.poll();

//                 int index = LeftToRight ? i : (size - i - 1);
//                 row.add(index, node.data);

//                 if (node.left != null) {
//                     q.add(node.left);
//                 }

//                 if (node.right != null) {
//                     q.add(node.right);
//                 }
//             }
//             // switch the traversal direction for next level
//             LeftToRight = !LeftToRight;

//             // add the current level
//             result.add(row);
//         }

//         return result;

//     }

//     public static void printResult(List<List<Integer>> result) {

//         for (List<Integer> row : result) {
//             for (int val : row) {
//                 System.out.print(val + " ");
//             }
//             System.out.println();
//         }
//     }

//     public static void main(String[] args) {
//         // Creating a sample binary tree
//         TreeNode root = new TreeNode(1);
//         root.left = new TreeNode(2);
//         root.right = new TreeNode(3);
//         root.left.left = new TreeNode(4);
//         root.left.right = new TreeNode(5);
//         root.right.left = new TreeNode(6);
//         root.right.right = new TreeNode(7);

//         q17_ZigZag_Traversal_Of_Binary_Tree solution = new q17_ZigZag_Traversal_Of_Binary_Tree();

//         // Get the zigzag level order traversal
//         List<List<Integer>> result = solution.ZigZagLevelOrder(root);

//         // Print the result
//         printResult(result);
//     }

// }

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

    public static List<List<Integer>> ZigZagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        boolean leftToRight = true;

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> row = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                // Add node data based on the current traversal direction
                if (leftToRight) {
                    row.add(node.data);
                } else {
                    row.add(0, node.data); // Insert at the beginning for right-to-left order
                }

                if (node.left != null) {
                    q.add(node.left);
                }

                if (node.right != null) {
                    q.add(node.right);
                }
            }

            // Switch the traversal direction for the next level
            leftToRight = !leftToRight;

            // Add the current level to the result
            result.add(row);
        }

        return result;
    }

    public static void printResult(List<List<Integer>> result) {
        for (List<Integer> row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // Get the zigzag level order traversal
        List<List<Integer>> result = ZigZagLevelOrder(root);

        // Print the result
        printResult(result);
    }
}
