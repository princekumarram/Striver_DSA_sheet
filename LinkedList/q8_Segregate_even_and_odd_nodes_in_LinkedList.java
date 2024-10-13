import java.util.ArrayList;

class Node {
    int val;
    Node next;

    Node(int x) {
        val = x;
        next = null;
    }
}

public class q8_Segregate_even_and_odd_nodes_in_LinkedList {

    static Node head, tail;

    public static void PrintList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.val + "-->");
            curr = curr.next;
        }
        System.out.print("null");
    }

    static void InsertatLast(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public static Node SegregatedToOddEven() {
        if (head == null) {
            return head;
        }

        Node evenHead = new Node(0);
        Node evenTail = evenHead;
        Node oddHead = new Node(0);
        Node oddTail = oddHead;

        Node curr = head;
        while (curr != null) {
            if (curr.val % 2 == 0) {
                evenTail.next = curr;
                evenTail = evenTail.next;
            } else {
                oddTail.next = curr;
                oddTail = oddTail.next;
            }
            curr = curr.next;
        }

        evenTail.next = null;
        oddTail.next = null;

        evenTail.next = oddHead.next;
        head = evenHead.next;

        return head;
    }

    public static void main(String args[]) {
        InsertatLast(1);
        InsertatLast(2);
        InsertatLast(3);
        InsertatLast(4);

        System.out.println("Initial LinkedList : ");
        PrintList(head);

        Node newHead = SegregatedToOddEven();

        System.out.println("LinkedList After Segregation ");
        PrintList(newHead);
    }
}