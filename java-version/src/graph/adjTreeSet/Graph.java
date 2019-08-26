package graph.adjTreeSet;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

public class Graph {

    private int V;
    private int E;
    private  TreeSet<Integer>[] adj;

    public Graph(String filename) {

        File file = new File(filename);
        Scanner scanner;
        try {
            scanner = new Scanner(file);
            V = scanner.nextInt();
            if (V < 0) {
                throw new IllegalArgumentException("V has to be a positive number.");
            }
            adj = new TreeSet[V];
            for (int i = 0; i < V; i++) {
                adj[i] = new TreeSet<Integer>();
            }

            E = scanner.nextInt();
            if (E < 0) {
                throw new IllegalArgumentException("E has to be a positive number.");
            }

            for (int j = 0; j < E; j++) {
                int u = scanner.nextInt(), v = scanner.nextInt();
                validateVertex(u, v);
                adj[u].add(v);
                adj[v].add(u);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void validateVertex(int u, int v) {
        if (v < 0 || v >= V) {
            throw new IllegalArgumentException("vertex " + v  + " is invalid");
        }
        if (u < 0 || u >= V) {
            throw new IllegalArgumentException("vertex " + u  + " is invalid");
        }
        if (u == v) {
            throw new IllegalArgumentException("Self Loop is detected in the given graph edge list");
        }

        if (adj[u].contains(v)) {
            throw new IllegalArgumentException("Parallel edge is detected in the given graph edge list");
        }
    }

    private void validateVertex(int v) {
        if (v < 0 || v >= V) {
            throw new IllegalArgumentException("vertex " + v  + " is invalid");
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public boolean hasEdge(int u, int v) {
        return u >= 0 && u < V && v >= 0 && v < V && adj[u].contains(v);
    }

    // iterable object, whatever it is, it can be iterated
    public Iterable<Integer> getNeighbors(int u) {
        validateVertex(u);
        return adj[u];
    }

    public int degree(int u) {
        validateVertex(u);
        return adj[u].size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("V = %d, E = %d\n", V, E));
        for (int i = 0; i < V; i++) {
            TreeSet<Integer> set = adj[i];
            sb.append(i);
            sb.append(" : [ ");
            for (Integer u : set) {
                sb.append(String.format("%d ", u));
            }
            sb.append("]\n");
        }
        return sb.toString();
    }
}
