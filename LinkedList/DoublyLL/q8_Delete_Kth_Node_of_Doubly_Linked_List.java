
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

public class q8_Delete_Kth_Node_of_Doubly_Linked_List {

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

    private static Node deleteTail(Node head) {
        if (head == null || head.next == null) {
            return null; // Return null if the list is empty or contains only one element
        }

        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        Node newtail = tail.back;

        newtail.next = null;
        tail.back = null;

        return head;
    }

    // Function to delete the head of the doubly linked list
    private static Node deleteHead(Node head) {
        if (head == null || head.next == null) {
            return null; // Return null if the list is empty or contains only one element
        }

        Node prev = head;
        head = head.next;

        head.back = null; // Set 'back' pointer of the new head to null
        prev.next = null; // Set 'next' pointer of 'prev' to null

        return head;
    }

    public static Node deleteKthNode(Node head, int k) {
        if (head == null) {
            return null;
        }

        int count = 0;
        Node kNode = head;

        while (kNode != null) {
            count++;
            if (count == k) {
                break;
            }
            kNode = kNode.next;
        }

        Node prev = kNode.back;
        Node front = kNode.next;

        if (prev == null && front == null) {
            return null;
        } else if (prev == null) {
            return deleteHead(head);
        } else if (front == null) {
            return deleteTail(head);
        }

        prev.next = front;
        front.back = prev;

        kNode.back = null;
        kNode.back = null;

        return head;
    }

    public static void main(String[] args) {

        int[] arr = { 12, 5, 6, 8, 4 };
        int k = 3;

        Node head = convertDLL(arr);
        print(head);

        Node newHead = deleteKthNode(head, k);
        System.out.println("After deleting the element");
        print(newHead);
    }

}
