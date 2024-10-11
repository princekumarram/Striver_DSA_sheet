import java.util.Stack;

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

public class q10_reverse_DLL {

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

    public static Node ReverseDLL1(Node head) {

        Stack<Integer> st = new Stack<>();

        Node temp = head;
        while (temp != null) {
            st.push(temp.data);
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            temp.data = st.pop();
            temp = temp.next;
        }
        return head;
    }

    public static Node ReverseDLL2(Node head) {

        if (head == null || head.next == null) {
            return head;
        }

        Node prev = null;

        Node current = head;

        while (current != null) {

            prev = current.back;

            current.back = current.next;

            current.next = prev;

            current = current.back;
        }

        return prev.back;
    }

    public static void main(String[] args) {

        int[] arr = { 12, 5, 6, 8, 4 };

        Node head = convertDLL(arr);
        print(head);

        Node newHead = ReverseDLL2(head);
        System.out.println("After After reversing  the LinkedList: ");
        print(newHead);
    }

}
