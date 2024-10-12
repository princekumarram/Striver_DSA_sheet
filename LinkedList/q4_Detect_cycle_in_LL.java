class Node {
    int data;
    Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class q4_Detect_cycle_in_LL {

    public static Node CovertInLL(int arr[]) {

        Node head = new Node(arr[0]);
        Node prev = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i], null);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }

    public static void printLL(Node head) {

        while (head != null) {
            System.out.print(head.data + "->");
            head = head.next;
        }
        System.out.print("null");
    }

    // by using the Map method
    public static Node DetectCycle(Node head) {

        Node temp = head;

        return head;

    }

    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 4, 4 };

        Node head = CovertInLL(arr);

        System.out.println("After inserting element in the Linked List");
        printLL(head);

        DetectCycle(head);

    }

}
