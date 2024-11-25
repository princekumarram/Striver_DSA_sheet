import java.util.*;

public class q6_Delete_ELe_In_Heap {

    class Heap {

    }

    public static void main(String[] args) {

        q6_Delete_ELe_In_Heap instace = new q6_Delete_ELe_In_Heap();
        Heap h = instace.new Heap();

        h.add(2);
        h.add(3);
        h.add(4);
        h.add(5);
        h.add(10);
        h.add(6);

        while (!h.isEmpty()) {
            System.out.println(h.peek());
            h.remove();
        }

    }
}
