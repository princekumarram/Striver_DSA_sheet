import java.util.*;
import java.util.Queue;

public class q9_Queue_Reversal {

    public static void getReverseQueue1(Queue<Integer> q) {
        Stack<Integer> s = new Stack<Integer>();

        while (!q.isEmpty()) {
            s.add(q.peek());
            q.remove();
        }

        while (!s.isEmpty()) {
            q.add(s.peek());
            s.pop();
        }
    }

    public static void getReverseQueue2(Queue<Integer> q) {
        // base case
        if (q.size() == 0)
            return;
        // storing front(first element) of queue
        int fr = q.peek();

        // removing front
        q.remove();

        // asking recursion to reverse the
        // leftover queue
        getReverseQueue2(q);

        // placing first element
        // at its correct position
        q.add(fr);
    }

    public static void main(String[] args) {

        Queue<Integer> q = new LinkedList<>();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        // getReverseQueue1(q);
        getReverseQueue2(q);

        while (!q.isEmpty()) {
            System.out.print(q.peek() + " ");
            q.remove();
        }
    }

}
