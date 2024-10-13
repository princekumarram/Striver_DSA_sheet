
import java.util.*;

// Node class represents a
// node in a linked list
class Node {
    // Data stored in the node
    int data;

    // Pointer to the next node in the list
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

// Class to perform operations on Linked List
public class q9_sortLL {

    // Function to sort a linked list
    // using Brute Force approach
    public static Node sortLL1(Node head) {
        // Create a list to
        // store node values
        List<Integer> arr = new ArrayList<>();

        // Temporary pointer to
        // traverse the linked list
        Node temp = head;

        // Traverse the linked list and
        // store node values in the list
        while (temp != null) {
            arr.add(temp.data);
            temp = temp.next;
        }

        // Sort the list
        // containing node values
        Collections.sort(arr);

        // Reassign sorted values to
        // the linked list nodes
        temp = head;
        for (int i = 0; i < arr.size(); i++) {
            // Update the node's data
            // with the sorted values
            temp.data = arr.get(i);
            // Move to the next node
            temp = temp.next;
        }

        // Return the head of the
        // sorted linked list
        return head;
    }

    // By Using Merge Sort
    public static Node sortLL2(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

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

        // Sort the linked list
        // head = sortLL1(head);

        // methode-2
        head = sortLL2(head);

        System.out.print("Sorted Linked List: ");
        printLinkedList(head);
    }
}
