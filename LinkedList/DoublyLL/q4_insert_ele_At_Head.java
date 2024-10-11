
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

public class q4_insert_ele_At_Head {

    public static Node convertArr2DLL(int arr[], int n) {

        Node head = new Node(arr[0]);
        Node prev = head;

        for (int i = 1; i < n; i++) {
            Node temp = new Node(arr[i], null, prev);

            prev.next = temp;
            prev = temp;
        }
        return head;

    }

    public static void printLL(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static Node insertBeforeHead(Node head, int val) {
        Node newHead = new Node(val, head, null);
        head.back = newHead;
        return newHead;
    }

    public static void main(String[] args) {
        int[] arr = { 12, 5, 6, 8, 4 };
        int n = 5;
        int val = 100;

        Node head = convertArr2DLL(arr, n);

        printLL(head);

        System.out.println("Doubly Linked List After Inserting 6 before head: ");

        Node newHead = insertBeforeHead(head, val);
        printLL(newHead);

    }

}
