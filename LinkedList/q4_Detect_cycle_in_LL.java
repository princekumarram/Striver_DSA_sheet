import java.util.HashMap;
import java.util.Map;

class Node {
    int data;
    Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class q4_Detect_cycle_in_LL {

    // function to detect a loop in a linked list
    public static boolean detectLoop1(Node head) {
        // initialize a pointer 'temp' at the head of linked list

        Node temp = head;

        // create a map to keep track of encountered nodes

        Map<Node, Integer> nodeMap = new HashMap<>();

        // step2: Traverse the linked list
        while (temp != null) {
            // if the node is already in the map ,there is no looop

            if (nodeMap.containsKey(temp)) {
                return true;
            }

            // store the current node int the map
            nodeMap.put(temp, 1);
            temp = temp.next;
        }

        // step3: if the linked list is successfully traversed without a loop , return
        // false
        return false;

    }

    // Function to detect a loop in a linked list
    // using the Tortoise and Hare Algorithm

    public static boolean detectLoop2(Node head) {

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }

        }
        return false;

    }

    public static void main(String args[]) {

        // create a sample linked list
        // with a loop for testing

        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        // create a loop

        fifth.next = third;

        // check if there is a loop
        // in the linked list
        if (detectLoop2(head)) {
            System.out.println("Loop detected in the Linked list.");

        } else {
            System.out.println("No loop detected in the linked list.");
        }

        // No need to explicitly free memory
        // in java; the garbage collector handles it

    }

}
