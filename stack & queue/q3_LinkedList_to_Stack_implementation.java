import java.util.Stack;
import java.util.*;

public class q3_LinkedList_to_Stack_implementation {

    // Node class to represent each element of the stack (Linked List Node)
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Stack class using LinkedList (with head node)
    class Stack {
        Node head = null;

        // Check if the stack is empty
        public boolean isEmpty() {
            return head == null;
        }

        // Push an element onto the stack
        public void push(int data) {
            Node newNode = new Node(data); // Create a new node with data
            if (isEmpty()) {
                head = newNode;
                return;
            }

            newNode.next = head; // Link the new node to the current head
            head = newNode; // Move the head to the new node
        }

        // Pop an element from the stack and return its value
        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1; // Return a sentinel value for an empty stack
            }
            int top = head.data; // Get the data from the top node
            head = head.next; // Move the head to the next node
            return top;
        }

        // Peek the top element without removing it
        public int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1; // Return a sentinel value for an empty stack
            }
            return head.data; // Return the data from the top node
        }
    }

    public static void main(String[] args) {
        // Create an instance of the outer class
        q3_LinkedList_to_Stack_implementation outer = new q3_LinkedList_to_Stack_implementation();
        // Create an instance of the Stack class
        Stack stack = outer.new Stack();

        // Stack<Integer> stack = new Stack<>();

        // Push elements onto the stack
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Pop and print elements from the stack
        while (!stack.isEmpty()) {
            System.out.println(stack.peek()); // Print the top element
            stack.pop(); // Remove the top element
        }
    }
}
