
import java.util.HashMap;
import java.util.Map;

//Node class represent a node in a linked list

class Node {
    // Data stored in the node
    int data;
    Node next;

    // constructor with both data and next node as parameters
    Node(int data1, Node next1) {
        data = data1;
        next = next1;
    }

    // constructor with only data as a parameter , sets next to null
    Node(int data1) {
        data = data1;
        next = null;
    }
}

public class q6_find_length_of_Cycle {

    public static int lengthOfLoop1(Node head) {
        // HashMap to store visited nodes and their timer values

        Map<Node, Integer> visitedNodes = new HashMap<>();

        // Initalize pointer to traverse the linked list
        Node temp = head;
        // initalize timer to track visited node
        int timer = 0;

        while (temp != null) {
            // If revisiting a node , return the difference of timer a values
            if (visitedNodes.containsKey(temp)) {
                // calculate the lenght of the loop

                int loopLength = timer - visitedNodes.get(temp);

                return loopLength;
            }

            // stores the current node and its timer value in the hashmap
            visitedNodes.put(temp, timer);

            // moves to the next node

            temp = temp.next;

            // increament the timer
            timer++;
        }
        // if teversal is completed and we reach the end of list(null), means there is
        // no loop

        return 0;

    }

    // Function find length of a linked list
    // using the Tortoise and Hare Algorithm

    public static int lengthOfLoop2(Node head) {

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return findLenght(slow, fast);
            }
        }
        // Step 3: If the fast pointer reaches the end
        // there is no loop
        return 0;
    }

    public static int findLenght(Node slow, Node fast) {

        // count to keep track of
        // nodes encountered in loop
        int cnt = 1;

        // move fast by one step
        fast = fast.next;

        // traverse fast till it
        // reaches back to slow

        while (slow != fast) {
            // at each node increase
            // count by 1 and move fast
            // forward by one step
            cnt++;
            fast = fast.next;
        }
        // loop terminates when fast reaches
        // slow again and the count is returned
        return cnt;
    }

    public static void main(String[] args) {

        // Create a linked list with a loop
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);

        // Create a loop from fifth to second
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        // this creates a loop

        fifth.next = second;

        // int looplength = lengthOfLoop1(head);
        int looplength = lengthOfLoop2(head);

        if (looplength > 0) {
            System.out.println("Length of the loop : " + looplength);
        }

    }

}
