import java.util.Stack;

public class q1_Implement_Stack_using_Array {

    public static void main(String[] args) {

        Stack<Integer> s = new Stack<>();

        s.push(6);
        s.push(3);
        s.push(7);
        System.out.println("Top of the stack before deleting any element " + s.peek());
        System.out.println("Size of the stack before deleting any element " + s.size());
        System.out.println("The element deleted is " + s.pop());
        System.out.println("Size of the stack after deleting an element " + s.size());
        System.out.println("Top of the stack after deleting an element " + s.peek());
    }
}

class stack {
    int size = 10000;
    int arr[] = new int[size];
    int top = -1;

    void push(int x) {
        top++;
        arr[top] = x;
    }

    int pop() {
        int x = arr[top];
        top--;
        return x;
    }

    int peek() {

        return arr[top];
    }

    int size() {
        return top + 1;
    }
}