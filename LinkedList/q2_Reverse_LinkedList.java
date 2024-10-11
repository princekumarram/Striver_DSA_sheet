
import java.util.Stack;

class Node {
    int data;
    Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;

    }

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class q2_Reverse_LinkedList {

    public static Node convertDLL(int arr[]) {
        Node head = new Node(arr[0]);
        Node prev = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i], null);
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
    }

    // approch-1 by swaping method
    public static Node ReverseLL1(Node head) {

        Node temp = head;
        Node prev = null;

        while (temp != null) {
            Node back = temp.next;
            temp.next = prev;
            prev = temp;
            temp = back;
        }
        return prev;

    }

    // approach-2 by Stack Method

    public static Node ReverseLL2(Node head) {
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

    // approach-3 by recursion
    public static Node ReverseLL3(Node head) {

        if (head == null || head.next == null) {
            return head;
        }

        Node newHead = ReverseLL3(head.next);

        Node back = head.next;

        back.next = head;

        head.next = null;

        return newHead;

    }

    public static void main(String[] args) {

        int[] arr = { 12, 5, 6, 8, 4 };

        Node head = convertDLL(arr);
        print(head);

        Node newHead = ReverseLL3(head);
        System.out.println("After reversing  the LinkedList: ");
        print(newHead);
    }

}
