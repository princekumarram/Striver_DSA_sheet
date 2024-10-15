import java.util.ArrayList;
import java.util.List;

// Definition for a doubly linked list node
class Node {
    int data;
    Node next, prev;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class q7_FInd_all_pairs_with_given_sum_in_DLL {

    // Helper function to print the pairs
    public static void printPairs(List<int[]> pairs) {
        if (pairs.isEmpty()) {
            System.out.println("No pairs found.");
        } else {
            for (int[] pair : pairs) {
                System.out.println("(" + pair[0] + ", " + pair[1] + ")");
            }
        }
    }

    public static List<int[]> pairOfSum(Node head, int sum) {

        List<int[]> pairs = new ArrayList<>();

        Node temp1 = head;

        while (temp1 != null) {

            Node temp2 = temp1.next;

            while (temp2 != null) {
                if (temp1.data + temp2.data == sum) {
                    // Store the pair in the list
                    pairs.add(new int[] { temp1.data, temp2.data });
                }
                temp2 = temp2.next;
            }
            temp1 = temp1.next;

        }
        return pairs; // Return the list of pairs

    }

    public static void main(String[] args) {
        // Creating a doubly linked list: 1 <-> 2 <-> 3 <-> 4 <-> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(3);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(4);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.prev = head.next.next.next;

        int sum = 5;

        List<int[]> pairs = pairOfSum(head, sum);
        printPairs(pairs);

    }

}
