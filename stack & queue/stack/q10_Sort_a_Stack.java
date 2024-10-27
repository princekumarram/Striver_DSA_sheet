import java.util.Stack;

public class q10_Sort_a_Stack {

    static void sortStack(Stack<Integer> stack) {

        while (stack.isEmpty()) {
            return;
        }

        int temp = stack.pop();

        sortStack(stack);

        // Insert the popped element back in sorted order
        insertInSortedOrder(stack, temp);

    }

    static void insertInSortedOrder(Stack<Integer> stack, int element) {

        while (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
            return;
        }

        int temp = stack.pop();

        insertInSortedOrder(stack, element);

        stack.push(temp);

    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(2);
        stack.push(8);
        stack.push(1);
        stack.push(3);

        System.out.println("Original stack: " + stack);
        sortStack(stack);
        System.out.println("Sorted stack: " + stack);
    }

}
