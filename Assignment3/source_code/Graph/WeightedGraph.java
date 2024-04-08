
import java.util.*;
import java.util.stream.Collectors;

public class WeightedGraph{

    List<List<Graph.Node>> adjList = new ArrayList<>();
    static class Graph {
        public static class Node{
            int value, weight;

            Node(int value, int weight){
                this.value = value; 
                this.weight = weight;
            }
        }
    }
        

    public static class Edge{
        int source, destination, weight;
        public Edge(int source, int destination, int weight){
            this.source = source; 
            this.destination = destination; 
            this.weight = weight; 
        }

    }

    // Constructor Function
    public WeightedGraph(List<Edge> edges){


        for (int i = 0; i < edges.size(); i++)
        adjList.add(i, new ArrayList<>());
    
        // add edges to the graph
        for (Edge e : edges)
        {
        // allocate new node in adjacency List from src to dest
        adjList.get(e.source).add(new Graph.Node(e.destination, e.weight));
        }
    }

    // Function to print the graph
    public void printGraph(){

        int source_vertex = 0; 
        int list_size = adjList.size();

        System.out.println("The contents of the graph: ");

        while(source_vertex < list_size){
            for (Graph.Node edge: adjList.get(source_vertex)){
                System.out.println("Vertex: " + source_vertex + " ==>" + edge.value + 
                " (" + edge.weight + ")"); 
            }
            System.out.println();
            source_vertex++;
        }




    }

    // dijkstra algorithm
    public List<String> dijkstra(int source, int numberOfDeliveryLocations) {
        int n = adjList.size(); 
        int[] D = new int[n];   // Array to store the distances
        List<List<Integer>> P = new ArrayList<>(n); // Array to store the parents for each vertex
        Set<Integer> S = new HashSet<>(); // Set to keep track of visited vertices

        // Initialize distances and parents
        for (int v = 0; v < n; v++) {
            D[v] = Integer.MAX_VALUE;
            P.add(new ArrayList<>());
        }
        D[source] = 0; // Distance from source to itself is 0
    
        // Repeat n-1 times
        for (int i = 0; i < n - 1; i++) {
            // Choose vertex w from (V - S) where D[w] is min
            int w = -1;
            int minDistance = Integer.MAX_VALUE;
            for (int v = 0; v < n; v++) {
                if (!S.contains(v) && D[v] < minDistance) {
                    minDistance = D[v];
                    w = v;
                }
            }
            if (w == -1) // If no such vertex found, break
                break;
            S.add(w); 
    
            
            for (Graph.Node node : adjList.get(w)) {
                int v = node.value;
                int weight = node.weight;
                if (!S.contains(v) && D[w] != Integer.MAX_VALUE && D[w] + weight < D[v]) {
                    D[v] = D[w] + weight;
                    P.get(v).clear(); 
                    P.get(v).add(w); 
                } else if (!S.contains(v) && D[w] != Integer.MAX_VALUE && D[w] + weight == D[v]) {
                    P.get(v).add(w); 
                }
            }
        }
    
        // Construct and return the shortest paths
        List<String> shortestPaths = new ArrayList<>();
        for (int i = 1; i <= numberOfDeliveryLocations; i++) {
                if (((i >= numberOfDeliveryLocations) && i >= adjList.size())|| D[i] == Integer.MAX_VALUE ) {
                shortestPaths.add("Delivery Location " + (i) + " - Shortest Route: No route exists, Distance: Infinity");
                shortestPaths.add("(Location " + (i) + " is unreachable from the central warehouse)");
            } else {
                List<List<Integer>> allPaths = new ArrayList<>();
                findPaths(P, i, source, new ArrayList<>(), allPaths);
                StringBuilder pathString = new StringBuilder();
                for (List<Integer> path : allPaths) {
                    pathString.append(path.stream().map(Object::toString).collect(Collectors.joining(" -> ")));
                    pathString.append(" or ");
                }
                int lastIndex = pathString.lastIndexOf(" or ");
                if (lastIndex != -1) {
                    pathString.setLength(lastIndex);
                }
                shortestPaths.add("Delivery Location " + (i) + " - Shortest Route: " +
                           pathString.toString()  + ", Distance: " + D[i]);

        }          
    }
    return shortestPaths;
}

    // Find paths function
    private void findPaths(List<List<Integer>> P, int current, int source, List<Integer> path, List<List<Integer>> allPaths) {
        path.add(current);
        if (current == source) {
            Collections.reverse(path);
            allPaths.add(new ArrayList<>(path));
            Collections.reverse(path);
        } else {
            for (int parent : P.get(current)) {
                findPaths(P, parent, source, path, allPaths);
            }
        }
        path.remove(path.size() - 1);
    }

}

