package graph.graphHelperMthods;

import graph.adjTreeSet.Graph;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class GraphUtilsPartTwo {

    public ArrayList<Integer> traverseBFS(Graph graph) {
        int V = graph.V();
        boolean[] visited = new boolean[V];
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                traverseHelper(graph, visited, res, i);
            }
        }
        return res;
    }

    private void traverseHelper(Graph graph, boolean[] visited, ArrayList<Integer> list, int u) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(u);
        visited[u] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            list.add(cur);
            Iterable<Integer> neighbors = graph.getNeighbors(cur);
            for (Integer v : neighbors) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }
    }
}
