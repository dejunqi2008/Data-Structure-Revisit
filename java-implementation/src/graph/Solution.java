package graph;

import java.util.Map;

public class Solution {

    public void test() {
        int[][] edges = {{0, 1, 5}, {0, 2, 2}, {0, 3, 6},
                {2, 1, 1}, {2, 3, 3}, {2, 4, 5}, {3, 4, 2},
                {1, 4, 1}};
        Dijkstra solution = new Dijkstra(edges);
        Map<Integer, Integer> dist = solution.shortestPath(0);
        for (Integer n : dist.keySet()) {
            System.out.println(n + ": " + dist.get(n));
        }
    }

}
