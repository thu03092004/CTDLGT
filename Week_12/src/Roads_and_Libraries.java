import java.util.*;

public class Roads_and_Libraries{

    static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
        if (c_lib <= c_road) {
            return (long) n * c_lib; // If the cost of building a library is less than or equal to the cost of building a road, build a library in each city.
        }

        // Build the graph using an adjacency list.
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] road : cities) {
            int city1 = road[0];
            int city2 = road[1];
            graph.get(city1).add(city2);
            graph.get(city2).add(city1);
        }

        // Perform DFS to find connected components.
        boolean[] visited = new boolean[n + 1];
        long totalCost = 0;

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                long componentCost = dfs(i, graph, visited, c_road);
                totalCost += c_lib + componentCost;
            }
        }

        return totalCost;
    }

    private static long dfs(int city, Map<Integer, List<Integer>> graph, boolean[] visited, int c_road) {
        visited[city] = true;
        long componentCost = 0;

        for (int neighbor : graph.get(city)) {
            if (!visited[neighbor]) {
                componentCost += c_road;
                componentCost += dfs(neighbor, graph, visited, c_road);
            }
        }

        return componentCost;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int q = scanner.nextInt(); // Number of queries

        for (int i = 0; i < q; i++) {
            int n = scanner.nextInt(); // Number of cities
            int m = scanner.nextInt(); // Number of roads
            int c_lib = scanner.nextInt(); // Cost to build a library
            int c_road = scanner.nextInt(); // Cost to repair a road

            int[][] cities = new int[m][2];
            for (int j = 0; j < m; j++) {
                cities[j][0] = scanner.nextInt();
                cities[j][1] = scanner.nextInt();
            }

            long result = roadsAndLibraries(n, c_lib, c_road, cities);
            System.out.println(result);
        }

        scanner.close();
    }
}