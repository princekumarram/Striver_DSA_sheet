
import java.util.ArrayList;

/*
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

 */

import java.util.*;

class Node {

    int data;

    Node next;

    // Constructor with both data and
    // next node as parameters
    Node(int data1, Node next1) {
        data = data1;
        next = next1;
    }

    // Constructor with only data as a
    // parameter, sets next to null
    Node(int data1) {
        data = data1;
        next = null;
    }
}

public class q8_Segregate_even_and_odd_nodes_in_LinkedList {

    public static Node Segregation1(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node odd = head;
        Node even = head.next;
        Node evenHead = head.next;

        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;

        }

        odd.next = evenHead;
        return head;

    }

    // Function to print the linked list
    public static void printLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            // Print the data of the current node
            System.out.print(temp.data + " ");
            // Move to the next node
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Linked List: 3 2 5 4 1
        Node head = new Node(3);
        head.next = new Node(2);
        head.next.next = new Node(5);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(1);

        System.out.print("Original Linked List: ");
        printLinkedList(head);

        // methode-2
        head = Segregation1(head);

        System.out.print("After the segregation: ");
        printLinkedList(head);
    }
}
