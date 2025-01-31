import java.util.*;

public class q1_Print_adjacency_List {

    public List<List<Integer>> printGraph(int V, int edges[][]) {
        List<List<Integer>> adjList = new ArrayList<>();

        // Initialize the adjacency list
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        // Fill the adjacency list
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adjList.get(u).add(v);
            adjList.get(v).add(u); // Since it's an undirected graph
        }
        return adjList;
    }

    // Helper function to print adjacency list (for testing)
    public static void printAdjacencyList(List<List<Integer>> adjList) {

        for (int i = 0; i < adjList.size(); i++) {
            System.out.print(i + ": ");
            for (int neighbor : adjList.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int V = 5, E = 7;
        int edges[][] = { { 0, 1 }, { 0, 4 }, { 4, 1 }, { 4, 3 }, { 1, 3 }, { 1, 2, }, { 3, 2 } };

        q1_Print_adjacency_List sol = new q1_Print_adjacency_List();

        List<List<Integer>> adjList = sol.printGraph(V, edges);

        // print the adjacency list
        printAdjacencyList(adjList);
    }
}