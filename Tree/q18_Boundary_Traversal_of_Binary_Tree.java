import java.util.List;
import java.util.*;

public class q18_Boundary_Traversal_of_Binary_Tree {

    public static List<List<Integer>>printBoundary(TreeNode root){
        List<List<Integer>>res=new ArrayList<>();

        if(root==null){
            return res;
        }

        Queue<TreeNode>nodesQueue;
        nodesQueue.push(root);
        boolean leftToRight=true;

        while(!nodesQueue.isEmpty()){
            int size=nodesQueue.size();

            List<Integer>row(size);
            
        }

    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        q18_Boundary_Traversal_of_Binary_Tree solution = new q18_Boundary_Traversal_of_Binary_Tree();

        // Get the boundary traversal
        List<Integer> result = solution.printBoundary(root);

        // Print the result
        System.out.print("Boundary Traversal: ");
        solution.printResult(result);
    }
}
