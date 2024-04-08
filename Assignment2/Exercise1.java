import java.util.*;

public class Exercise1 {


    // Graph class
    static class Graph {
        int n;
        Map<Integer, List<Integer>> adjList;

        // Constructor to initialize the graph
        public Graph(int n) {
            this.n = n;
            adjList = new HashMap<>();
            for (int i = 0; i < n; i++) {
                adjList.put(i, new ArrayList<>());
            }
        }

         // Method to add an edge between two vertices
        public void addEdge(int u, int v) {
            adjList.putIfAbsent(u, new ArrayList<>());
            adjList.get(u).add(v);
        }
    }

     // Problem 1: Determine if there is a path from src to dest in the graph
    public static boolean Part1(Graph graph, int src, int dest) {
        java.util.Queue<Integer> queue = new java.util.LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(src);
        visited.add(src);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == dest) {
                return true;
            }
            for (int neighbor : graph.adjList.get(current)) {
                if (!visited.contains(neighbor)) {
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        return false;
    }

    // Problem 2: Find total number of routes with exactly m edges from src to dest
    public static int Part2(Graph graph, int src, int dest, int m) {
        java.util.Queue<Integer> queue = new java.util.LinkedList<>();
        queue.offer(src);
        int count = 0;
        while (m >= 0 && !queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                if (current == dest && m == 0) {
                    count++;
                }
                for (int neighbor : graph.adjList.getOrDefault(current, Collections.emptyList())) {
                    queue.offer(neighbor);
                }
            }
            m--;
        }
        return count;
    }


    public static void main(String[] args) {

        // Graph 1
        Graph graph1 = new Graph(8);

        graph1.addEdge(0, 6);
        graph1.addEdge(6, 7);
        graph1.addEdge(7, 3);
        graph1.addEdge(3, 5);
        graph1.addEdge(4, 6);

        int src1 = 4;
        int dest1 = 5;

        System.out.println("Problem 1: " + Part1(graph1, src1, dest1)); // Output: true

        // Graph 2
        Graph graph2 = new Graph(8);

        graph2.addEdge(0, 6);
        graph2.addEdge(6, 7);
        graph2.addEdge(7, 3);
        graph2.addEdge(3, 5);
        graph2.addEdge(4, 6);

        int src2 = 5;
        int dest2 = 0;

        System.out.println("Problem 2: " + Part1(graph2, src2, dest2)); // Output: true

        // Graph 3
        Graph graph3 = new Graph(8);

        graph3.addEdge(0, 6);
        graph3.addEdge(0, 1);
        graph3.addEdge(1, 6);
        graph3.addEdge(1, 9);
        graph3.addEdge(1, 5);
        graph3.addEdge(5, 3);
        graph3.addEdge(3, 4);
        graph3.addEdge(9, 5);
        graph3.addEdge(9, 3);
        graph3.addEdge(9, 4);
        graph3.addEdge(6, 9);
        graph3.addEdge(7, 6);
        graph3.addEdge(7, 1);


        int src3 = 0;
        int dest3 = 3;
        int m = 4;

        System.out.println("Problem 2: " + Part2(graph3, src3, dest3, m)); // Output: true


    }


}
