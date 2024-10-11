import java.util.List;
import java.util.Arrays;

class Node {
    int data;
    Node next;

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

public class q7_Delete_Node_At_Position {

    public static Node deleteNodeAtPosition(Node head, int pos) {
        if (head == null)
            return head;

        Node temp = head;

        if (pos == 0) {
            head = head.next;
            return head;
        }

        for (int i = 0; temp != null && i < pos - 1; i++) {
            temp = temp.next;
        }
        if (temp == null || temp.next == null)
            return head;

        temp.next = temp.next.next;
        return head;

    }

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String args[]) {
        List<Integer> arr = Arrays.asList(12, 8, 5, 7);
        int pos = 2;

        Node head = new Node(arr.get(0));
        head.next = new Node(arr.get(1));
        head.next.next = new Node(arr.get(2));
        head.next.next.next = new Node(arr.get(3));

        head = deleteNodeAtPosition(head, pos);
        printList(head);
    }
}
