import java.util.*;

public class q12_Queue_using_Deque {

    public static class Queue { // Make Queue static
        Deque<Integer> dq = new LinkedList<>();

        public void add(int data) {
            dq.addLast(data);
        }

        public int remove() {
            return dq.removeFirst();
        }

        public int peek() {
            return dq.peekFirst();
        }
    }

    public static void main(String[] args) {

        Queue q = new Queue(); // Now this works
        q.add(1);
        q.add(2);
        q.add(3);

        System.out.println("peek " + q.peek());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
    }
}