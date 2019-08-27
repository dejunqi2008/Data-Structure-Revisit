package graph.graphHelperMthods;

import graph.adjTreeSet.Graph;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class GraphUtilsPartOne {

    public ArrayList<Integer> traverseDFS(Graph graph, boolean reverse) {
        int V = graph.V();
        boolean[] visited = new boolean[V];
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            traverseHelper(graph, visited, res, i, reverse);
        }
        return res;
    }

    public int connectedComponents(Graph graph) {
        int cnt = 0;
        int V = graph.V();
        boolean[] visited = new boolean[V];
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                cnt += 1;
            }
            traverseHelper(graph, visited, res, i, false);
        }
        return cnt;
    }

    public boolean isConnected(Graph graph, int u, int v) {
        int V = graph.V();
        int[] visited = new int[V];
        for (int i = 0; i < V; i++) {
            visited[i] = -1;
        }
        int cnt = 0;
        for (int i = 0; i < V; i++) {
            if (visited[i] == -1) {
                cnt += 1;
            }
            isConnectedHelper(graph, visited, i, cnt);
        }
        return visited[u] == visited[v];
    }

    public boolean isBipartite(Graph graph) {
        int V = graph.V();
        int[] colors = new int[V];
        for (int i = 0; i < V; i++) {
            colors[i] = -1;
        }
        for (int i = 0; i < V; i++) {
            if (colors[i] != -1) {
                if (!isBipartiteHelper(graph, colors, i, 0)) {
                    return false;
                }
            }
        }
        return true;
    }



    private void traverseHelper(Graph graph, boolean[] visited, ArrayList<Integer> list, int u, boolean reverse) {
        if (!visited[u]) {
            visited[u] = true;
            if (!reverse) { // pre order traverse
                list.add(u);
            }
            Iterable<Integer> neighbors = graph.getNeighbors(u);
            for (Integer v : neighbors) {
                traverseHelper(graph, visited, list, v, reverse);
            }
            if (reverse) {
                list.add(u); // post order
            }
        }
    }

    private void isConnectedHelper(Graph graph, int[] visited, int u, int cnt) {
        if (visited[u] == -1) {
            visited[u] = cnt;
            Iterable<Integer> neighbors = graph.getNeighbors(u);
            for (Integer v : neighbors) {
                isConnectedHelper(graph, visited, v, cnt);
            }
        }
    }

    private boolean isBipartiteHelper(Graph graph, int[] colors, int u, int color) {
        colors[u] = color;
        Iterable<Integer> neighbors = graph.getNeighbors(u);
        for (Integer v : neighbors) {
            if (colors[v] != -1) {
                if (!isBipartiteHelper(graph, colors, v, 1 - color)) {
                    return false;
                }
            } else if (colors[v] == colors[u]) {
               return false;
            }
        }
        return true;
    }
}
