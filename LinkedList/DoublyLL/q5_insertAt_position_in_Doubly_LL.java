class Node {
    int data;
    Node next;
    Node back;

    public Node(int data, Node next, Node back) {
        this.data = data;
        this.next = next;
        this.back = back;

    }

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.back = null;
    }
}

public class q5_insertAt_position_in_Doubly_LL {

    public static Node convertDLL(int arr[]) {
        Node head = new Node(arr[0]);
        Node prev = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i], null, prev);
            prev.next = temp;
            prev = temp;
        }
        return head;

    }

    public static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;

        }
        System.err.println();
    }

    public static Node insertAtPosition(Node head, int k, int val) {
        if (k == 1) {
            return head;
        }
        Node temp = head;

        int count = 0;
        while (temp != null) {
            count++;

            if (count == k)
                break;
            temp = temp.next;
        }

        Node prev = temp.back;

        Node newNode = new Node(val, temp, prev);

        prev.next = newNode;
        temp.back = newNode;

        newNode.next = temp;
        newNode.back = prev;

        return head;

    }

    public static void main(String args[]) {
        int[] arr = { 12, 5, 6, 8, 4 };
        int val = 10;
        int k = 3;

        Node head = convertDLL(arr);
        print(head);

        Node newHead = insertAtPosition(head, k, val);
        System.out.println("After inserting the element");
        print(newHead);
    }
}
