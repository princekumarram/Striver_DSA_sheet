
import java.util.Stack;

class q12_Reverse_a_Stack {

    // Function to reverse the stack
    static void reverse(Stack<Integer> s) {
        // Base case: If stack is empty, return
        if (s.isEmpty()) {
            return;
        }

        // Pop the top element
        int temp = s.pop();

        // Recursively reverse the remaining stack
        reverse(s);

        // Insert the popped element at the bottom of the reversed stack
        insertAtBottom(s, temp);
    }

    // Helper function to insert an element at the bottom of the stack
    static void insertAtBottom(Stack<Integer> s, int element) {
        // Base case: If stack is empty, push the element
        if (s.isEmpty()) {
            s.push(element);
            return;
        }

        // Pop the top element
        int temp = s.pop();

        // Recursively insert element at the bottom
        insertAtBottom(s, element);

        // Push the popped element back
        s.push(temp);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println("Original Stack: " + stack);

        // Reverse the stack
        reverse(stack);

        System.out.println("Reversed Stack: " + stack);
    }
}
