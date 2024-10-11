
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class q3_Add_1_to_number_represented_byLL {

    public Node addOne(Node head) {

        if (head == null)
            return null;

        Node prev = null;
        Node cur = head;

        while (cur != null) {
            if (cur.data < 9) {
                prev = cur;
            }
            cur = cur.next;
        }

        if (prev == null) {
            Node newNode = new Node(1);
            newNode.next = head;
            head = newNode;
            cur = head.next;

            while (cur != null) {
                cur.data = 0;
                cur = cur.next;
            }
            return head;
        }
        prev.data = prev.data + 1;
        cur = prev.next;
        while (cur != null) {
            cur.data = 0;
            cur = cur.next;
        }

        return head;
    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(9);
        head.next = new Node(9);
        head.next.next = new Node(9);

        q3_Add_1_to_number_represented_byLL solution = new q3_Add_1_to_number_represented_byLL();

        System.out.println("Original list:");
        printList(head);

        head = solution.addOne(head);

        System.out.println("List after adding one:");
        printList(head);
    }
}
