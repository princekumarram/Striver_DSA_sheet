
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

public class q5_Delete_Node_From_Head {

    public static Node deleteNode(Node head) {
        if (head == null)
            return null;
        return head.next;
    }

    // function to print the linked list
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

        head = deleteNode(head);
        printList(head);

    }
}
