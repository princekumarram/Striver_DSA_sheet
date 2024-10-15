
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

    // METHOD-1 BY USING ITERATION METHOD
    public static Node intersectionPresent1(Node head1, Node head2) {
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

    // METHOD-2 BY USIGN HASHING

    public static Node intersectionPresent2(Node head1, Node head2) {

        Stack<Node> st = new Stack<>();

        while (head1 != null) {
            st.add(head1);
            head1 = head1.next;
        }

        while (head2 != null) {
            if (st.contains(head2))
                return head2;
            head2 = head2.next;
        }
        return null;
    }

    // METHOD-3 BY USIGNG Difference in length

    /*
     * public static Node intersectionPresent3(Node head1, Node head2) {
     * int len1 = 0, len2 = 0;
     * Node temp1 = head1;
     * Node temp2 = head2;
     * 
     * while (temp1 != null) {
     * len1++;
     * temp1 = temp1.next;
     * }
     * 
     * while (temp2 != null) {
     * len2++;
     * temp2 = temp2.next;
     * }
     * 
     * if (len1 < len2) {
     * return CollisionPointIs(head1, head2, len2 - len1);
     * } else {
     * return CollisionPointIs(head1, head2, len1 - len2);
     * }
     * 
     * }
     * 
     * public static Node CollisionPointIs(Node head1, Node head2, int d) {
     * Node temp1 = head1;
     * Node temp2 = head2;
     * while (d > 0) {
     * temp2 = temp2.next;
     * d--;
     * }
     * 
     * while (temp1 != temp2) {
     * temp1 = temp1.next;
     * temp2 = temp2.next;
     * }
     * return temp1;
     * }
     */
    public static Node intersectionPresent3(Node head1, Node head2) {
        int len1 = 0, len2 = 0;
        Node temp1 = head1;
        Node temp2 = head2;

        // Calculate lengths of both linked lists
        while (temp1 != null) {
            len1++;
            temp1 = temp1.next;
        }

        while (temp2 != null) {
            len2++;
            temp2 = temp2.next;
        }

        // Adjust based on which list is longer
        if (len1 < len2) {
            return findCollisionPoint(head1, head2, len2 - len1);
        } else {
            return findCollisionPoint(head2, head1, len1 - len2);
        }
    }

    /*
     * public static Node CollisionPointIs(Node head1, Node head2, int d) {
     * Node temp1 = head1;
     * Node temp2 = head2;
     * 
     * // Move the pointer of the longer list by 'd' nodes
     * while (d > 0) {
     * temp2 = temp2.next;
     * d--;
     * }
     * 
     * // Traverse both lists simultaneously to find the intersection point
     * while (temp1 != temp2) {
     * temp1 = temp1.next;
     * temp2 = temp2.next;
     * }
     * 
     * return temp1; // This is the intersection point
     * }
     */
    private static Node findCollisionPoint(Node shorter, Node longer, int diff) {
        Node temp1 = shorter;
        Node temp2 = longer;

        // Advance the pointer of the longer list by 'diff' nodes
        for (int i = 0; i < diff; i++) {
            temp2 = temp2.next;
        }

        // Traverse both lists simultaneously to find the intersection point
        while (temp1 != null && temp2 != null) {
            if (temp1 == temp2) {
                return temp1; // Intersection point found
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return null; // No intersection point found
    }

    // METHOD 4 BY CROSSING THE HEADS

    public static Node intersectionPresent4(Node head1, Node head2) {

        while (head1 == null || head2 == null)
            return null;

        Node temp1 = head1;
        Node temp2 = head2;

        while (temp1 != temp2) {
            temp1 = temp1.next;
            temp2 = temp2.next;

            if (temp1 == temp2)
                return temp1;
            if (temp1 == null)
                temp1 = head2;
            if (temp2 == null)
                temp2 = head2;

        }
        return temp1;
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
        Node answerNode = intersectionPresent4(head1, head2);
        if (answerNode == null)
            System.out.println("No intersection\n");
        else
            System.out.println("The intersection point is " + answerNode.num);

    }
}
