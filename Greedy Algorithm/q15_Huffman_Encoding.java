import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

class q15_Huffman_Encoding {
    class Node implements Comparable<Node> {
        int data;
        char character; // To store the character
        Node left;
        Node right;

        Node(int data, char character) {
            this.data = data;
            this.character = character;
            this.left = null;
            this.right = null;
        }

        public int compareTo(Node temp) {
            return this.data - temp.data; // Simplified comparison
        }
    }

    public void preorder(Node root, String str, HashMap<Character, String> huffmanCode) {
        if (root.left == null && root.right == null) {
            huffmanCode.put(root.character, str);
            return;
        }
        preorder(root.left, str + "0", huffmanCode);
        preorder(root.right, str + "1", huffmanCode);
    }

    public HashMap<Character, String> huffmanCodes(String S, int f[], int N) {
        HashMap<Character, String> huffmanCode = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>();

        // Create Nodes for each character and frequency
        for (int i = 0; i < N; i++) {
            Node temp = new Node(f[i], S.charAt(i));
            pq.add(temp);
        }

        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            Node parent = new Node(left.data + right.data, '\0'); // Parent node doesn't hold a character
            parent.left = left;
            parent.right = right;
            pq.add(parent);
        }

        Node root = pq.poll();
        preorder(root, "", huffmanCode);
        return huffmanCode;
    }

    public static void main(String[] args) {
        q15_Huffman_Encoding sol = new q15_Huffman_Encoding();
        String S = "abcdef";
        int[] f = { 5, 9, 12, 13, 16, 45 };
        int N = f.length;

        HashMap<Character, String> result = sol.huffmanCodes(S, f, N);
        for (char ch : result.keySet()) {
            System.out.println(ch + ": " + result.get(ch)); // Print character and its corresponding Huffman code
        }
    }
}