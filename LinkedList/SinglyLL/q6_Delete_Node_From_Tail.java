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

public class q6_Delete_Node_From_Tail {

    public static Node deleteLastNode(Node head) {
        if (head == null || head.next == null) {
            return null;
        }

        Node temp = head;

        while (temp.next.next != null) {
            temp = temp.next;

        }
        temp.next = null;

        return head;
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void main(String args[]) {
        List<Integer> arr = Arrays.asList(12, 8, 5, 7);

        Node head = new Node(arr.get(0));
        head.next = new Node(arr.get(1));
        head.next.next = new Node(arr.get(2));
        head.next.next.next = new Node(arr.get(3));

        head = deleteLastNode(head);
        printList(head);
    }

}