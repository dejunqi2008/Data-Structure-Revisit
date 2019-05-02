package graph;

import java.util.*;

public class Dijkstra {

    private class Pair {
        int key;
        int value;
        Pair(int k, int v) {
            key = k;
            value = v;
        }
    }

    private Map<Integer, Map<Integer, Integer>> graph;
    private Map<Integer, Integer> dist;

    public Dijkstra(int[][] edges) {
        graph = new HashMap<>();
        dist = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1], w = edge[2];
            if (!graph.containsKey(a)) {
                graph.put(a, new HashMap<>());
            }
            graph.get(a).put(b, w);

            if (!dist.containsKey(a)) {
                dist.put(a, Integer.MAX_VALUE);
            }
            if (!dist.containsKey(b)) {
                dist.put(b, Integer.MAX_VALUE);
            }
        }
    }


    public Map<Integer, Integer> shortestPath(int start) {

        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
                public int compare(Pair o1, Pair o2) {
                return o1.value - o2.value;
            }
        });



        dist.put(start, 0);

        pq.offer(new Pair(start, 0));
        Set<Integer> visited = new HashSet<>();

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int key = cur.key;
            int val = cur.value;

            if (visited.contains(key)) {
                continue;
            }
            visited.add(key);

            Map<Integer, Integer> neighbors = graph.get(key);
            if (neighbors != null) {
                for (Integer n : neighbors.keySet()) {
                    int value = neighbors.get(n);
                    int newdist = value + val;
                    if (newdist < dist.get(n)) {
                        dist.put(n, newdist);
                    }

                    pq.offer(new Pair(n, newdist));
                }
            }
        }

        return dist;
    }


}
