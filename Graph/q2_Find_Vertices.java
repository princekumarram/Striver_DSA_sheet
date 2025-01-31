public class q2_Find_Vertices {
    // Graph and Vertices

    static long count(int n) {
        // Total possible edges in an undirected graph
        int totalEdges = (n * (n - 1)) / 2;

        // Total number of graphs = 2^totalEdges
        return (long) Math.pow(2, totalEdges);
    }

    public static void main(String[] args) {
        System.out.println(count(2)); // Output: 2
        System.out.println(count(5)); // Output: 1024
    }

}
