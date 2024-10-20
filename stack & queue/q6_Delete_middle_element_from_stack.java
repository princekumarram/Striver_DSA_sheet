import java.util.Stack;

public class q6_Delete_middle_element_from_stack {

    public static void deleteMiddle(Stack<Integer> st) {

        if (st.isEmpty()) {
            return;
        }
        int size = st.size();
        deleteMiddle(st, 0, size);

    }

    public static void deleteMiddle(Stack<Integer> st, int currentIndex, int size) {

        if (currentIndex == size / 2) {
            st.pop();
            return;
        }

        int top = st.pop();

        deleteMiddle(st, currentIndex + 1, size);

        st.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<Integer>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        st.push(6);
        st.push(7);

        deleteMiddle(st);

        while (!st.isEmpty()) {
            System.out.println(st.peek());
            st.pop();
        }

    }
}
