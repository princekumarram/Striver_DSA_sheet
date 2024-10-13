import java.util.HashMap;
import java.util.Map;

class Node {
    int data;
    Node next;

    public Node(int data1, Node next1) {
        data = data1;
        next = next1;
    }

    public Node(int data1) {
        data = data1;
        next = null;
    }

}

public class q7_Starting_point_of_loop_in_Linked_List {

    // MEHTOD-1

    public static Node detectLoop1(Node head) {

        Node temp = head;

        Map<Node, Integer> nodeMap = new HashMap<>();

        while (temp != null) {

            if (nodeMap.containsKey(temp)) {
                return temp;
            }
            nodeMap.put(temp, 1);

            temp = temp.next;
        }
        return null;
    }

    // METHOD-2
    public static Node detectLoop2(Node head) {

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                slow = head;

                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }

        }
        return null;
    }

    public static void main(String args[]) {

        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        fifth.next = third;

        Node head = first;

        // Detect the loop in the linked list
        // Node loopStartNode = detectLoop1(head);

        // method-2
        Node loopStartNode = detectLoop2(head);

        if (loopStartNode != null) {
            System.out.println("Loop detected. Starting node of the loop is: " + loopStartNode.data);
        } else {
            System.out.println("No loop detected in the linked list.");
        }

    }

}
