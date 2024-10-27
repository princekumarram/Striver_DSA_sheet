import java.util.ArrayList;

public class q2_ArrayList_to_Stack_implementation {

    static class Stack {

        // The list that will act as the stack
        ArrayList<Integer> list = new ArrayList<>();

        // Check if the stack is empty
        public boolean isEmpty() {
            return list.size() == 0;
        }

        // Push method to add an element to the stack
        public void push(int data) {
            list.add(data);
        }

        // Pop method to remove and return the top element
        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1; // Return sentinel value when stack is empty
            }
            int top = list.get(list.size() - 1); // Get top element
            list.remove(list.size() - 1); // Remove top element
            return top; // Return the popped element
        }

        // Peek method to get the top element without removing it
        public int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1; // Return sentinel value when stack is empty
            }
            return list.get(list.size() - 1); // Return the top element
        }
    }

    public static void main(String[] args) {

        Stack s = new Stack();

        s.push(1);
        s.push(2);
        s.push(3);

        // Print elements in the stack until it's empty
        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
