import java.util.*;
import java.util.Queue;

class stack {
    Queue<Integer> q = new LinkedList<>();

    void push(int x) {
        q.add(x);

        // Rotate the queue to bring the new element to the front
        for (int i = 0; i < q.size() - 1; i++) {
            q.add(q.remove());//
        }
    }

    int pop() {
        return q.remove();
    }

    int top() {
        return q.peek();
    }

    int size() {
        return q.size();
    }
}

public class q5_implement_queue_using_stack {

    public static void main(String[] args) {

        stack s = new stack();
        s.push(3);
        s.push(2);
        s.push(4);
        s.push(1);
        System.out.println("Top of the stack: " + s.top());
        System.out.println("Size of the stack before removing element: " + s.size());
        System.out.println("The deleted element is: " + s.pop());
        System.out.println("Top of the stack after removing element: " + s.top());
        System.out.println("Size of the stack after removing element: " + s.size());
    }
}