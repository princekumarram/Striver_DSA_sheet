import java.util.*;

// Node class represents a
// node in a linked list
class Node {
    // Data stored in the node
    int data;
    // Pointer to the next
    // node in the list
    Node next;

    // Constructor with both data
    // and next node as parameters
    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    // Constructor with only data as
    // a parameter, sets next to null
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class q13_Reverse_Linked_List_in_groups_of_Size_K {

    public static Node kReverse(Node head, int k) {

        Node temp = head;
        Node prevLast = null;

        while (temp != null) {
            Node kThNode = getKthNode(temp, k);

            if (kThNode == null) {

                if (prevLast != null) {
                    prevLast.next = temp;
                }
                // Exit the loop
                break;
            }

            Node nextNode = kThNode.next;
            kThNode.next = null;

            reverseLinkedList(temp);

            if (temp == head) {
                head = kThNode;
            } else {
                prevLast.next = kThNode;
            }
            prevLast = temp;

            temp = nextNode;

        }
        return head;

    }

    // getting the kthNode
    public static Node getKthNode(Node temp, int k) {
        k -= 1;

        while (temp != null && k > 0) {
            k--;
            temp = temp.next;
        }
        return temp;
    }

    // reversing the LinkedList
    public static Node reverseLinkedList(Node temp) {

        if (temp == null || temp.next == null) {
            return temp;
        }
        Node newHead = reverseLinkedList(temp.next);

        Node back = temp.next;
        back.next = temp;
        temp.next = null;

        return newHead;

    }

    // Function to print the linked list
    static void printLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create a linked list with
        // values 5, 4, 3, 7, 9 and 2
        Node head = new Node(5);
        head.next = new Node(4);
        head.next.next = new Node(3);
        head.next.next.next = new Node(7);
        head.next.next.next.next = new Node(9);
        head.next.next.next.next.next = new Node(2);

        // Print the original linked list
        System.out.print("Original Linked List: ");
        printLinkedList(head);

        // Reverse the linked list
        head = kReverse(head, 4);

        // Print the reversed linked list
        System.out.print("Reversed Linked List: ");
        printLinkedList(head);
    }
}