import java.util.*;
import java.util.Queue;

public class q4_queue_using_collection {

    public static void main(String[] args) {
        // Queue<Integer> q = new LinkedList<>(); // ArrayDequeue
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        q.add(2);
        q.add(3);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }

    }
}
