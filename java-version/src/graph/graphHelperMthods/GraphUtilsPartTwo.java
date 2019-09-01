package graph.graphHelperMthods;

import graph.adjTreeSet.Graph;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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


     public List<Integer> hasHamiltonLoop(Graph graph) {
        int V = graph.V();
        boolean[] visited = new boolean[V];
        int[] allvisited = {0};
        List<Integer> hamiltonLoop = new ArrayList<>();
        boolean hasLoop =  hasHamiltonLoopHelper(graph, visited, allvisited, 0, hamiltonLoop);
        return hasLoop ? hamiltonLoop : null;
     }


     private boolean hasHamiltonLoopHelper(Graph graph, boolean[] visited, int[] allvisited, int u, List<Integer> list) {
        visited[u] = true;
        allvisited[0] += 1;
        list.add(u);
        Iterable<Integer> neighbors = graph.getNeighbors(u);
        for (Integer v : neighbors) {
            if (!visited[v]) {
                if (hasHamiltonLoopHelper(graph, visited, allvisited, v, list)) {
                    return true;
                }
            } else if (v == 0 && allvisited[0] == visited.length) {
                return true;
            }
        }
        visited[u] = false;
        allvisited[0] -= 1;
        list.remove(list.size() - 1);
        return false;
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
