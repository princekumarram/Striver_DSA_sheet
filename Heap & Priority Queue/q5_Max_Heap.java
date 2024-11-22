
import java.util.ArrayList;

public class q5_Max_Heap {

    public class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) { // O(logn)
            // add at last idx
            arr.add(data);
            int x = arr.size() - 1; // x is child index
            int par = (x - 1) / 2;

            while (x > 0 && arr.get(x) > arr.get(par)) { // O(logn)
                // swap
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);

                x = par;
                par = (x - 1) / 2;
            }
        }

        public int peek() {
            return arr.get(0);
        }

        private void heapify(int i) {
            int left = 2 * i + 1;
            int right = 2 * i + 2; // Corrected index for right child
            int maxIndex = i;

            if (left < arr.size() && arr.get(maxIndex) < arr.get(left)) {
                maxIndex = left;
            }

            if (right < arr.size() && arr.get(maxIndex) < arr.get(right)) {
                maxIndex = right;
            }

            if (maxIndex != i) {
                // swap
                int temp = arr.get(i);
                arr.set(i, arr.get(maxIndex));
                arr.set(maxIndex, temp);
                heapify(maxIndex); // Recursive call to heapify
            }
        }

        public int remove() {

            int data = arr.get(0);

            // step 1 - swap first & last
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);

            // step 2 -- delete the last
            arr.remove(arr.size() - 1);

            // step 3 -- heapify
            if (!isEmpty()) { // Check if heap is not empty before heapifying
                heapify(0);
            }
            return data;
        }

        public boolean isEmpty() {
            return arr.size() == 0;
        }
    }

    public static void main(String[] args) {
        q5_Max_Heap instance = new q5_Max_Heap();
        Heap h = instance.new Heap();
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);

        while (!h.isEmpty()) {
            System.out.println(h.peek());
            h.remove();
        }
    }
}