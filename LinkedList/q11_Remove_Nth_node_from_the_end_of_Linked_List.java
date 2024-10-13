
class Node {
    public int data;
    public Node next;

    // Constructor for Node with data and next node
    public Node(int data1, Node next1) {
        data = data1;
        next = next1;
    }

    // Constructor for Node with only data (next set to null)
    public Node(int data1) {
        data = data1;
        next = null;
    }
}

public class q11_Remove_Nth_node_from_the_end_of_Linked_List {
    // Function to print the linked list
    public static void printLL(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    // method 1
    public static Node DeleteNthNodefromEnd1(Node head, int N) {

        if (head == null)
            return null;

        int cnt = 0;
        Node temp = head;

        while (temp != null) {
            cnt++;
            temp = temp.next;

        }

        if (cnt == N) {
            Node newHead = head.next;
            head = null;
            return newHead;

        }

        int res = cnt - N;
        temp = head;

        while (temp != null) {
            res--;

            if (res == 0) {
                break;
            }
            temp = temp.next;
        }

        Node newNode = temp.next;
        temp.next = newNode.next;

        return head;
    }

    // method-2

    public static Node DeleteNthNodefromEnd2(Node head, int N) {

        while (head == null)
            return null;

        Node fast = head;
        Node slow = head;

        for (int i = 0; i < N; i++)
            fast = fast.next;

        while (fast == null)
            return head.next;

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;

        }

        Node delNode = slow.next;
        slow.next = slow.next.next;
        delNode = null;

        return head;

    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int N = 3;
        Node head = new Node(arr[0]);
        head.next = new Node(arr[1]);
        head.next.next = new Node(arr[2]);
        head.next.next.next = new Node(arr[3]);
        head.next.next.next.next = new Node(arr[4]);

        // Delete the Nth node from
        // the end and print the modified linked list
        // head = DeleteNthNodefromEnd1(head, N);
        head = DeleteNthNodefromEnd2(head, N);
        printLL(head);
    }
}
