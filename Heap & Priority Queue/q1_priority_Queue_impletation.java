import java.util.Comparator;
import java.util.PriorityQueue;

public class q1_priority_Queue_impletation {

    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        pq.add(2);
        pq.add(3);
        pq.add(1);
        pq.add(4);
        pq.add(5);

        while (!pq.isEmpty()) {
            System.out.println("2nd method" + pq.peek());
            pq.remove();
        }

        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Comparator.reverseOrder());

        pq2.add(2);
        pq2.add(3);
        pq2.add(1);
        pq2.add(4);
        pq2.add(5);

        while (!pq2.isEmpty()) {
            System.out.println(pq2.peek());
            pq2.remove();
        }

    }
}