package graphTopology;

import java.io.*;
//This class stores the graph in an adjacency matrix
public class Graph {
private int nNode;
private int nEdges;
private int[][] adjMat;
public int getNumNode() {
return nNode;
}
public int getNumEdges() {
return nEdges;
}
public int[][] getAdjMat() {
return adjMat;
}
// This method takes a graph as input from a file
public void readFromFile(File f) {
try (FileReader fr = new FileReader(f)) {
BufferedReader br = new BufferedReader(fr);
nNode = Integer.parseInt(br.readLine());
nEdges = Integer.parseInt(br.readLine());
adjMat = new int[nNode][nNode];
for (int i = 0; i < nEdges; i++) {
String pair = br.readLine();
String[] nodes = pair.split(" ");
int u = Integer.parseInt(nodes[0]);
int v = Integer.parseInt(nodes[1]);
adjMat[u][v] = 1;
}
} catch (IOException ignored) {
}
}
// This method displays the graph in adjacency matrix format
public void display() {
System.out.print(" ");
for (int i = 0; i < nNode; i++) {
System.out.printf("%3d", i);
}
System.out.println();
System.out.print(" ");
for (int i = 0; i < nNode * 3 ; i++) {
System.out.print("-");
}
System.out.println();
for (int i = 0; i < nNode; i++) {
System.out.printf("%2d | ", i);
for (int j = 0; j < nNode; j++) {
System.out.printf("%3d",adjMat[i][j]);
}
System.out.println();
}
}
}