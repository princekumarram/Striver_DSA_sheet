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

public class q3_insert_ele_at_last {

    public static void PrintLL(Node head) {

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }

    }

    // inserting new element

    public static Node insertAtLast(Node head, int val) {
        if (head == null) {
            return new Node(val);
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        Node newNode = new Node(val);
        temp.next = newNode;
        return head;
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(12, 8, 5, 7);
        int val = 100;

        Node head = new Node(arr.get(0));
        head.next = new Node(arr.get(1));
        head.next.next = new Node(arr.get(2));
        head.next.next.next = new Node(arr.get(3));

        head = insertAtLast(head, val);

        PrintLL(head);
    }

}