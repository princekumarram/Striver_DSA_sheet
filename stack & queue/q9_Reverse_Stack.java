import java.util.Stack;

public class q9_Reverse_Stack {

    static void reverse(Stack<Integer> s) {

        while (s.isEmpty()) {
            return;
        }

        int temp = s.pop();

        reverse(s);

        insertToBottom(s, temp);

    }

    static void insertToBottom(Stack<Integer> s, int element) {
        if (s.isEmpty()) {
            s.push(element);
            return;
        }

        int temp = s.pop();

        insertToBottom(s, element);

        s.push(temp);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println("Original stack: " + stack);
        reverse(stack);
        System.out.println("Reversed stack: " + stack);
    }
}
