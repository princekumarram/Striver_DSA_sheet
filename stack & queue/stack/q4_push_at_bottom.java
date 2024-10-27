import java.util.*;

public class q4_push_at_bottom {

    public static void PushAtBottom(Stack<Integer> s, int data) {

        while (s.isEmpty()) {
            s.push(data);
            return;
        }

        int temp = s.pop();

        PushAtBottom(s, data);
        s.push(temp);

    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();

        s.push(1);
        s.push(2);
        s.push(3);

        PushAtBottom(s, 4);

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }

}
