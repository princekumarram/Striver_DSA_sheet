
import java.util.Arrays;
import java.util.List;

class Node {
    public int data;
    public Node next;

    // constructor
    Node(int data1, Node next1) {
        this.data = data1;
        this.next = next1;
    }

    public Node(int data1) {
        data = data1;
        next = null;
    }
}

public class q4_insert_at_position {

    // function to print the linked list
    public static void printLL(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    // inserting the element
    public static Node insertAtPosition(Node head, int val, int pos) {
        if (pos < 1) {
            System.out.println("Invalid position");
            return head;
        }

        if (pos == 1) {
            Node temp = new Node(val);
            temp.next = head;
            return temp;
        }

        Node curr = head;

        for (int i = 1; i < pos - 1 && curr != null && curr.next != null; i++) {
            curr = curr.next;
        }

        if (curr == null || curr.next == null) {
            System.out.println("Position exceeds the length of the linked list");
            return head;
        }

        Node temp = new Node(val);
        temp.next = curr.next;
        curr.next = temp;

        return head;
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(12, 8, 5, 7);
        int val = 100;
        int pos = 2;

        Node head = new Node(arr.get(0));
        head.next = new Node(arr.get(1));
        head.next.next = new Node(arr.get(2));
        head.next.next.next = new Node(arr.get(3));

        head = insertAtPosition(head, val, pos);

        printLL(head);
    }
}