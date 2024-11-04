import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    // Default constructor for TreeNode
    TreeNode() {
        this.val = 0;
        this.left = null;
        this.right = null;
    }

    TreeNode(int x) {
        this.val = x;
        this.left = null;
        this.right = null;
    }

    TreeNode(int x, TreeNode left, TreeNode right) {
        this.val = x;
        this.left = left;
        this.right = right;
    }
}

public class q6_Level_Order_Traversal {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();

            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                TreeNode node = q.poll();

                level.add(node.val);

                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }

            ans.add(level);
        }
        return ans;
    }

    static void printList(List<Integer> list) {
        for (int num : list) {
            System.out.println(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        q6_Level_Order_Traversal solution = new q6_Level_Order_Traversal();

        List<List<Integer>> result = solution.levelOrder(root);

        System.out.println("Level Order Traversal of Tree: ");

        for (List<Integer> level : result) {
            printList(level);
        }
    }

}
