package graphTopology;


import java.util.ArrayList;
import java.util.List;
public class GraphTraversal {
 // This method checks if a given node can be an initiator
 public static boolean checkInitiator(Graph graph, int start) {
 // Initialization
 List<Integer> nodeCovered = new ArrayList<>();
 int n = graph.getNumNode();
 int[][] adjMat = graph.getAdjMat();
 // Add start node to nodeCovered list
 nodeCovered.add(start);
 // Find all the nodes that can be visited from the start node
 for (int i = 0; i < nodeCovered.size(); i++) {
 Integer u = nodeCovered.get(i);
 for (int j = 0; j < n; j++) {
 if (adjMat[u][j] != 0 && !nodeCovered.contains(j))
 nodeCovered.add(j);
 }
 // check if all nodes are covered
 int count = nodeCovered.size();
 if (count == n) {
 return true;
 }
 }
 return false;
 }
 // This method finds all the nodes that can be an initiator, if any
 // and returns them as a List
 public static List<Integer> findAllInitiator(Graph graph) {
 // Initialization
 int n = graph.getNumNode();
 int[][] adjMat = graph.getAdjMat();
 List<Integer> initiators = new ArrayList<>(); // stores all the initiator nodes
 List<Integer> source = new ArrayList<>(); // stores all the source nodes
 List<Integer> sink = new ArrayList<>(); // stores all the sink nodes
 // Check for source vertices
 for (int i = 0; i < n; i++) {
 boolean flag = true;
 for (int j = 0; j < n; j++) {
 if (adjMat[j][i] == 1) {
 flag = false;
 break;
 }
 }
 if (flag)
 source.add(i);
 }
 // If there are multiple source vertices, no vertex can be an initiator
 if (source.size() > 1) {
 System.out.println("There are multiple source vertices.");
 return initiators;
 }
 // Check if there are any source vertices. If any no other vertex can be an initiator
 if (source.size() == 1) {
 boolean isInitiator = checkInitiator(graph, source.get(0));
 if (isInitiator) {
 initiators.add(source.get(0));
 }
 return initiators;
 }
 // Find all sink vertices
 for (int i = 0; i < n; i++) {
 boolean flag = true;
 for (int j = 0; j < n; j++) {
 if (adjMat[i][j] == 1) {
 flag = false;
 break;
 }
 }
 if (flag) {
 sink.add(i);
 }
 }
 // Find initiator nodes if any
 for (int i = 0; i < n; i++) {
 if (!sink.contains(i)) {
 boolean isInitiator = checkInitiator(graph, i);
 if(isInitiator)
 initiators.add(i);
 }
 }
 return initiators;
 }
}