package graph;

import graph.adjTreeSet.Graph;
import java.util.ArrayList;


public class Solution {
    public void test() {
        String path = "/Users/dejunqi/Documents/work/data-structure-algorithm/java-version/src/graph/";
        String filename = "graph_edge_list_04.txt";
        Graph graph = new Graph(path + filename);
        System.out.println(graph.toString());
        System.out.println("\n");
        ArrayList<Integer> res = graph.orders();
        System.out.println(res);
        // System.out.println(graph.isConnected(0, 5));
        // System.out.println(graph.connectedComponents());
//        System.out.println(graph.isBipartite());
    }

}
