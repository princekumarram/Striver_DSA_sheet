import java.util.List;

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
}

public class q12_Add_two_numbers_represented_as_Linked_Lists {

    public static Node addTwoNumbers(Node l1, Node l2) {
        Node dummy = new Node(0); // Dummy node to simplify edge cases
        Node current = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry == 1) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            sum += carry;
            carry = sum / 10;

            Node node = new Node(sum % 10);
            current.next = node;
            current = current.next;

        }
        return dummy.next;

    }

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) {
                System.out.print(" -> ");
            }
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node l1 = new Node(2);
        l1.next = new Node(4);
        l1.next.next = new Node(3);

        Node l2 = new Node(5);
        l2.next = new Node(6);
        l2.next.next = new Node(4);

        Node result = addTwoNumbers(l1, l2);
        printList(result); // Output should be 7 -> 0 -> 8
    }

}
