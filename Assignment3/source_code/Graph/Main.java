import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Scanner to take in inputs
        Scanner scanner = new Scanner(System.in);
        int numberOfWarehouses = validatePositiveIntegerInput(scanner);
        int numberOfDeliveryLocations = validatePositiveIntegerInput(scanner);
        int numberOfRoads = validatePositiveIntegerInput(scanner);

        // Create list of edges
        List<WeightedGraph.Edge> edges = new ArrayList<>();
        for (int i = 0; i < numberOfRoads; i++) {

            int start = validatePositiveIntegerInput(scanner);
            int destination = validatePositiveIntegerInput(scanner);
            int distance = validatePositiveIntegerInput(scanner);

            // Add the start destination and weight to the edges
            edges.add(new WeightedGraph.Edge(start, destination, distance));
        }

        // Create the graph
        WeightedGraph graph = new WeightedGraph(edges);

        // Print the shortest paths
        List<String> shortestPaths = graph.dijkstra(0, numberOfDeliveryLocations);
        for (String path : shortestPaths) {
            System.out.println(path);
        }

    }

        // Function to check if a positive integer is inputted
        private static int validatePositiveIntegerInput(Scanner scanner) {
        int input;
        while (true) {
            try {
                input = scanner.nextInt();
                if (input < 0) {
                    System.out.println("Error: Input must be a positive integer.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input format. Please enter a positive integer.");
                scanner.next(); // Consume the invalid input
            }
        }
        return input;
    }



}
