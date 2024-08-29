package graphTopology;

import java.io.*;
import java.util.List;
import java.util.Scanner;
// This is the driver class with the main method
public class Main {
 public static void main(String[] args) {
 Scanner sc = new Scanner(System.in);
 File file = new File("C:\\Users\\Mitu Pradhan\\Desktop\\operating system\\graphTopology\\src\\graphTopology\\graph.txt");
 Graph graph = new Graph();
 // Reads the graph from the 'graph.txt' file
 graph.readFromFile(file);
 // Displays the input graph
 System.out.println("The input graph is:");
 graph.display();
 while (true) {
 System.out.println("\n----------------");
 System.out.println("1. Check initiator");
 System.out.println("2. Find all initiators");
 System.out.println("3. Exit");
 System.out.print("Enter your choice: ");
 int choice = sc.nextInt();
 switch (choice) {
 // checks if a specific node is an initiator or not
 case 1:
 System.out.print("\nEnter the initiator node (0-" +
(graph.getNumNode() - 1) + ") : ");
 int node = sc.nextInt();
 boolean isInitiator = GraphTraversal.checkInitiator(graph, node);
 if (isInitiator) {
 System.out.println("Node " + node + " can be an initiator");
 } else {
 System.out.println("Node " + node + " can not be an initiator");
 }
 break;
 // finds all the initiator nodes
 case 2:
 List<Integer> initiators = GraphTraversal.findAllInitiator(graph);
 System.out.print("Initiator nodes: ");
 if (!initiators.isEmpty()) {
 for (int i = 0; i < initiators.size(); i++) {
 System.out.print(initiators.get(i));
 if (i != initiators.size() - 1)
 System.out.print(", ");
 }
 } else {
 System.out.println("There are no initiator nodes.");
 }
 break;
 // Exit case
 case 3:
 System.out.println("\nExiting...");
 System.exit(1);
 default:
 System.out.println("\nWrong choice!");
 break;
 }
 }
 }
}