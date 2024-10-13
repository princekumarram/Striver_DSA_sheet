
import java.util.*;

class Node {
    int num;
    Node next;

    Node(int val) {
        num = val;
        next = null;
    }
}

class q10_Find_intersection_of_Two_Linked_Lists {
    // utility function to insert node at the end of the linked list
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

    // utility function to print linked list created
    static void printList(Node head) {
        while (head.next != null) {
            System.out.print(head.num + "->");
            head = head.next;
        }
        System.out.println(head.num);
    }

    public static Node intersectionPresent(Node head1, Node head2) {
        while (head2 != null) {
            Node temp = head1;
            while (temp != null) {
                // if both nodes are same
                if (temp == head2)
                    return head2;
                temp = temp.next;
            }
            head2 = head2.next;
        }
        // intersection is not present between the lists return null
        return null;
    }

    public static void main(String args[]) {
        // creation of both lists
        Node head = null;
        head = insertNode(head, 1);
        head = insertNode(head, 3);
        head = insertNode(head, 1);
        head = insertNode(head, 2);
        head = insertNode(head, 4);

        Node head1 = head;
        head = head.next.next.next;
        Node headSec = null;
        headSec = insertNode(headSec, 3);
        Node head2 = headSec;
        headSec.next = head;
        // printing of the lists
        System.out.print("List1: ");
        printList(head1);
        System.out.print("List2: ");
        printList(head2);
        // checking if intersection is present
        Node answerNode = intersectionPresent(head1, head2);
        if (answerNode == null)
            System.out.println("No intersection\n");
        else
            System.out.println("The intersection point is " + answerNode.num);

    }
}
