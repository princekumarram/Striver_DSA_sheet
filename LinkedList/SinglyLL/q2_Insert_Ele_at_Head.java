import java.util.Arrays;
import java.util.List;

class Node {
    public int data;
    public Node next;

    // /Constructors

    Node(int data1, Node next1) {
        this.data = data1;
        this.next = next1;
    }

    public Node(int data1) {
        data = data1;
        next = null;
    }

}

public class q2_Insert_Ele_at_Head {

    // function to print the linked list

    public static void printLL(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    // inserting new element

    public static Node insertHead(Node head, int val) {
        Node temp = new Node(val, head);
        return temp;
    }

    public static void main(String[] ags) {

        // List<Integer> arr = Arrays.asList(12, 8, 5, 7);
        // int val = 100;

        List<Integer> arr = Arrays.asList(12, 8, 5, 7);
        int val = 100;

        Node head = new Node(arr.get(0));
        head.next = new Node(arr.get(1));
        head.next.next = new Node(arr.get(2));
        head.next.next.next = new Node(arr.get(3));

        head = insertHead(head, val);

        printLL(head);
    }

}
