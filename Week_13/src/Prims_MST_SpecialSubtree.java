import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Cost implements Comparable<Cost> {
    public int r, v;

    public Cost(int cost, int vertex) {
        r = cost;
        v = vertex;
    }

    @Override
    public int compareTo(Cost c) {
        if (r < c.r) return -1;
        if (r > c.r) return 1;
        if (v < c.v) return -1;
        if (v > c.v) return 1;
        return 0;
    }
}

public class Prims_MST_SpecialSubtree {
    public static int prims(int n, List<List<Cost>> graph, int start) {
        boolean[] visited = new boolean[n + 1];
        int totalWeight = 0;
        PriorityQueue<Cost> pq = new PriorityQueue<>();

        visited[start] = true;
        for (Cost neighbor : graph.get(start)) {
            pq.offer(neighbor);
        }

        while (!pq.isEmpty()) {
            Cost cost = pq.poll();
            int node = cost.v;
            int weight = cost.r;

            if (!visited[node]) {
                visited[node] = true;
                totalWeight += weight;

                for (Cost neighbor : graph.get(node)) {
                    if (!visited[neighbor.v]) {
                        pq.offer(neighbor);
                    }
                }
            }
        }

        return totalWeight;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<List<Cost>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            graph.get(u).add(new Cost(w, v));
            graph.get(v).add(new Cost(w, u));
        }

        int start = scanner.nextInt();

        int result = prims(n, graph, start);
        System.out.println(result);
    }
}