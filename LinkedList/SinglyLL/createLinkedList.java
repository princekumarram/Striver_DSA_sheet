
class Node {
    int data;
    Node next;

    // Constructors

    Node(int data1, Node next1) {
        this.data = data1;
        this.next = next1;
    }

    Node(int data1) {
        this.data = data1;
        this.next = null;
    }
}

public class createLinkedList {
    public static void main(String[] args) {
        int arr[] = { 2, 5, 8, 7 };

        // creating a new Node with the value from array
        Node head = new Node(arr[0]);

        System.out.println(head.data);
        // Node y = head;
        // System.out.println(y);//Adress of The Node
    }

}