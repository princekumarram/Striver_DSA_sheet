
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

public class q7_FInd_all_pairs_with_given_sum_in_DLL {

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

    public static Node PiarOfSum(Node head, int sum) {

        Node temp1 = head;
        int ds[][] = new int[sum][sum];

        while (temp1 != null) {

            Node temp2 = temp1.next;

            while (temp2 != null) {
                if (temp1.data + temp2.data == sum) {
                    ds.add(temp1.data, temp2.data);
                }
                temp2 = temp2.next;
            }

        }

    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 9 };
        int n = 5;
        int sum = 5;

        Node head = convertIntoDLL(arr, n);
        Node Newhead = PiarOfSum(head, sum);
        printLL(head);

        System.out.println("all occurence is");
        printLL(Newhead);

    }

}
