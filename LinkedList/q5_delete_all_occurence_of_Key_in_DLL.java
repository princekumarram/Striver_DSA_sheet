class Node {
    int data;
    Node next;
    Node prev;

    public Node(int data, Node next, Node prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class q5_delete_all_occurence_of_Key_in_DLL {

    public static Node convertIntoDLL(int arr[], int n) {

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
        System.out.print("null <- ");
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public static Node deleteOccurence(Node head, int key) {

        if (head == null) {
            return head;
        }

        Node temp = head;

        while (temp != null) {
            if (temp.data == key) {

                if (temp == head) {
                    head = head.next;
                }

                Node nextNode = temp.next;
                Node prevNode = temp.prev;

                if (nextNode != null)
                    nextNode.prev = prevNode;
                if (prevNode != null)
                    prevNode.next = nextNode;

                temp = nextNode;
            } else {
                temp = temp.next;
            }

        }
        return head;

    }

    public static void main(String[] args) {
        int arr[] = { 10, 4, 10, 10, 6, 10 };
        int n = 6;
        int key = 10;

        Node head = convertIntoDLL(arr, n);
        Node Newhead = deleteOccurence(head, key);
        printLL(head);

        System.out.println("After deleting all key occurence");
        printLL(Newhead);

    }

}
