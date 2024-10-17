
import java.util.*;

// Node class represents a
// node in a linked list
class Node {
    // Data stored in the node
    int data;

    // Pointer to the next node in the list
    Node next;

    // Constructor with both data and
    // next node as parameters
    Node(int data1, Node next1) {
        data = data1;
        next = next1;
    }

    // Constructor with only data as a
    // parameter, sets next to null
    Node(int data1) {
        data = data1;
        next = null;
    }
}

public class q15_Merge_Two_Sorted_Lists {
    // Function to convert an array to a linked list
    static Node convertArrToLinkedList(ArrayList<Integer> arr) {
        // Create a dummy node to serve
        // as the head of the linked list
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;

        // Iterate through the array and
        // create nodes with array elements
        for (int i = 0; i < arr.size(); i++) {
            // Create a new node with the array element
            temp.next = new Node(arr.get(i));
            // Move the temporary pointer to the newly created node
            temp = temp.next;
        }
        // Return the linked list starting
        // from the next of the dummy node
        return dummyNode.next;
    }

    // METHOD-1
    // Function to merge two sorted linked lists
    static Node sortTwoLinkedLists1(Node list1, Node list2) {
        ArrayList<Integer> arr = new ArrayList<>();
        Node temp1 = list1;
        Node temp2 = list2;

        // Storing elements of both lists into an array

        // Add elements from list1 to the array
        while (temp1 != null) {
            arr.add(temp1.data);
            // Move to the next node in list1
            temp1 = temp1.next;
        }

        // Add elements from list2 to the array
        while (temp2 != null) {
            arr.add(temp2.data);
            // Move to the next node in list2
            temp2 = temp2.next;
        }

        // Sorting the array in ascending order
        Collections.sort(arr);

        // Converting the sorted array
        // back to a linked list
        Node head = convertArrToLinkedList(arr);

        // Return the head of the
        // merged sorted linked list
        return head;
    }

    // METHOD-2

    public static Node sortTwoLinkedLists2(Node list1, Node list2) {

        Node dummyNode = new Node(-1);
        Node temp = dummyNode;

        while (list1 != null && list2 != null) {

            if (list1.data <= list2.data) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
    }

    // Function to print the linked list
    static void printLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            // Print the data of the current node
            System.out.print(temp.data + " ");
            // Move to the next node
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example Linked Lists
        Node list1 = new Node(1);
        list1.next = new Node(3);
        list1.next.next = new Node(5);

        Node list2 = new Node(2);
        list2.next = new Node(4);
        list2.next.next = new Node(6);

        System.out.print("First sorted linked list: ");
        printLinkedList(list1);

        System.out.print("Second sorted linked list: ");
        printLinkedList(list2);

        Node mergedList = sortTwoLinkedLists2(list1, list2);

        System.out.print("Merged sorted linked list: ");
        printLinkedList(mergedList);
    }
}
