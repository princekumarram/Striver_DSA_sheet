import java.util.Stack;

class Node {
    int data;
    Node next;
    // Node back;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
        // this.back = back;

    }

    public Node(int data) {
        this.data = data;
        this.next = null;
        // this.back = null;
    }
}

public class q1_Find_middle_of_array {

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
        System.err.println();
    }

    public static Node FindMiddle1(Node head) {

        if (head == null || head.next == null) {
            return head;
        }

        Node temp = head;
        int count = 0;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        int mid = count / 2 + 1;
        temp = head;

        while (temp != null) {
            mid = mid - 1;

            if (mid == 0)
                break;

            temp = temp.next;

        }
        return temp;

    }

    // APPROACH-2 TORTOISE METHOD

    public static Node FindMiddle2(Node head) {

        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null && slow != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;

    }

    public static void main(String[] args) {

        int[] arr = { 12, 5, 6, 8, 4, 5, 8, 9 };

        Node head = convertDLL(arr);
        print(head);

        Node newHead = FindMiddle2(head);
        System.out.println("After find middle of  the LinkedList: ");
        print(newHead);
    }

}
