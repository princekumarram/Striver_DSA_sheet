
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

public class q9_Delete_Node_Value_of_Doubly_Linked_List {

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

    public static Node deleteKNodeValue(Node head, int k) {

        return head;
    }

    public static void main(String[] args) {

        int[] arr = { 12, 5, 6, 8, 4 };
        int val = 6;

        Node head = convertDLL(arr);
        print(head);

        Node newHead = deleteKNodeValue(head, val);
        System.out.println("After deleting the element");
        print(newHead);
    }

}
