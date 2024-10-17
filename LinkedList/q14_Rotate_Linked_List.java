
import java.util.*;

class Node {
    int num;
    Node next;

    Node(int a) {
        num = a;
        next = null;
    }
}

class q14_Rotate_Linked_List {
    // utility function to insert node at the end of the list
    static Node insertNode(Node head, int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            return head;
        }
        Node temp = head;
        while (temp.next != null)
            temp = temp.next;

        temp.next = newNode;
        return head;
    }

    // METHOD-1

    public static Node rotateRight1(Node head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;

        for (int i = 0; i < k; i++) {
            Node temp = head;

            while (temp.next.next != null)
                temp = temp.next;

            Node end = temp.next;
            temp.next = null;
            end.next = head;
            head = end;
        }

        return head;
    }

    // METHOD -2
    public static Node rotateRight2(Node head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;

        // Step 1: Calculate the length of the list
        int len = 1; // Start at 1 to include the head node
        Node temp = head;

        while (temp.next != null) {
            len++;
            temp = temp.next;
        }

        // Step 2: Handle cases where k is a multiple of len
        k = k % len;
        if (k == 0)
            return head;

        // Step 3: Make the list circular
        temp.next = head; // Connect the last node to the head to make it circular

        // Step 4: Find the new last node after rotation
        Node newLastNode = findNthNode(head, len - k - 1); // Find the (len-k-1)th node

        // Step 5: Update the head and break the circular connection
        head = newLastNode.next;
        newLastNode.next = null; // Break the circle

        return head;
    }

    public static Node findNthNode(Node head, int d) {
        Node temp = head;

        while (d > 0 && temp != null) { // Traverse the list until the dth node is found
            d--;
            temp = temp.next;
        }

        return temp;
    }

    // utility function to print list
    static void printList(Node head) {
        while (head.next != null) {
            System.out.print(head.num + "->");
            head = head.next;
        }
        System.out.println(head.num);

    }

    public static void main(String args[]) {
        Node head = null;
        // inserting Node
        head = insertNode(head, 1);
        head = insertNode(head, 2);
        head = insertNode(head, 3);
        head = insertNode(head, 4);
        head = insertNode(head, 5);

        System.out.println("Original list: ");
        printList(head);

        int k = 2;
        Node newHead = rotateRight1(head, k);
        // calling function for rotating right of the nodes by k times

        System.out.println("After " + k + " iterations: ");
        printList(newHead);// list after rotating nodes

    }
}