import java.util.PriorityQueue;

class q14_Minimum_Cost_of_ropes {
    // Function to return the minimum cost of connecting the ropes.
    public int minCost(int[] arr) {
        // Use PriorityQueue to manage the ropes efficiently
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Add all elements of the array to the PriorityQueue
        for (int value : arr) {
            pq.add(value);
        }

        int miniCost = 0;

        // Continue until we are left with one rope
        while (pq.size() > 1) {
            int v1 = pq.poll(); // Take the smallest rope
            int v2 = pq.poll(); // Take the second smallest rope

            int newRope = v1 + v2;
            pq.add(newRope); // Add the combined rope back to the queue

            miniCost += newRope; // Add the cost
        }

        return miniCost;
    }

    public static void main(String args[]) {
        int arr[] = { 4, 3, 2, 6 };
        int n = 4;

        // Create an instance of the class
        q14_Minimum_Cost_of_ropes obj = new q14_Minimum_Cost_of_ropes();
        
        // Call the minCost method using the instance
        System.out.println(obj.minCost(arr));
    }
}