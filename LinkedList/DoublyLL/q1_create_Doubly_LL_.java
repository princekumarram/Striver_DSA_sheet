
class Node {
    public int data;
    public Node next;
    public Node back;

    // Constructor for a Node with both data, a reference to the next node, and a
    // reference to the previous node
    public Node(int data, Node next, Node back) {
        this.data = data;
        this.next = next;
        this.back = back;
    }

    // Constructor for a Node with data, and no references to the next and previous
    // nodes (end of the list)
    public Node(int data) {
        this.data = data;
        this.next = null;
        this.back = null;
    }

}

public class q1_create_Doubly_LL_ {

    public static void main(String[] args) {
    }

}