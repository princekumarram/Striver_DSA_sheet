import java.util.*;

public class q10_Deque_implementation {

    public static void main(String[] args) {
        Deque<Integer> dq = new LinkedList<>();
        dq.addFirst(1);// 1
        dq.addFirst(2);// 2 1
        dq.addLast(3);// 2 1 3
        System.out.println(dq);
        dq.removeLast();// 2 1
        System.out.println(dq);
        dq.removeFirst();// 1
        System.out.println(dq);

        System.out.println("get first ele " + dq.getFirst());
        System.out.println("get lasst ele " + dq.getLast());

    }

}
