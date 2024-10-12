
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

public class q8_Remove_duplicates_from_sorted_DLL {

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

    public static Node RemoveDuplicates(Node head) {
        Node temp=head;
        while(temp!=null && temp.next!=null){
            Node nextNode=temp.next;
            while(nextNode!=null && nextNode.data==temp.data){
                nextNode=nextNode.next;
            }
            temp.next=nextNode;
        }
        temp.next=nextNode;
        if(nextNode!=null){
            nextNode.prev=temp;
        }
        else{
            temp=temp.next;
        }

    }

    public static void main(String[] args) {
        int arr[] = { 1, 1, 1, 2, 3, 3, 4 };
        int n = 7;

        Node head = convertIntoDLL(arr, n);
        Node Newhead = RemoveDuplicates(head);
        printLL(head);

        System.out.println("After Removing duplicates");
        printLL(Newhead);

    }

}
