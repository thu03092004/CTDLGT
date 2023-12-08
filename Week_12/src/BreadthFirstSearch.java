import java.util.ArrayList;
import java.util.Scanner;

//import java.util.*;
//
//public class BreadthFirstSearch {
//
//    static int[] findShortestReach(ArrayList<ArrayList<Integer>> graph, int start) {
//        int[] costs = new int[graph.size()];
//        int UNIT_COST = 6;
//        for (int i = 0; i < costs.length; ++i) costs[i] = -1;
//
//        // Viết chương trình vào đây
//
//        return costs;
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int Q = scanner.nextInt();
//        for (int q = 0; q < Q; ++q) {
//            int N, M, start;
//            N = scanner.nextInt();
//            M = scanner.nextInt();
//            ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
//            for (int i = 0; i <= N; ++i) {
//                graph.add(new ArrayList<Integer>());
//            }
//            for (int i = 0; i < M; ++i) {
//                int n1, n2;
//                n1 = scanner.nextInt();
//                n2 = scanner.nextInt();
//                graph.get(n1).add(n2);
//                graph.get(n2).add(n1);
//            }
//            start = scanner.nextInt();
//            /*
//            for (int i = 0; i < N; ++i) {
//                Collections.sort(graph.get(i));
//            }
//            for (int i = 1; i <= N; ++i) {
//                System.out.println("Node: " + i);
//                System.out.println(graph.get(i).toString());
//            }
//            System.out.println("Start: " + start);
//            */
//            int[] costs = findShortestReach(graph, start);
//            for (int i = 1; i < costs.length; ++i) {
//                if (i == start) continue;
//                System.out.print(costs[i] + " ");
//            }
//            System.out.println();
//        }
//    }
//}

import java.util.*;

public class BreadthFirstSearch {

    static int[] findShortestReach(ArrayList<ArrayList<Integer>> graph, int start) {
        int[] costs = new int[graph.size()];
        int UNIT_COST = 6;
        for (int i = 0; i < costs.length; ++i) {
            costs[i] = -1;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        costs[start] = 0;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            for (int neighbor : graph.get(currentNode)) {
                if (costs[neighbor] == -1) {
                    // Node is not visited
                    costs[neighbor] = costs[currentNode] + UNIT_COST;
                    queue.add(neighbor);
                }
            }
        }

        return costs;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int Q = scanner.nextInt();
        for (int q = 0; q < Q; ++q) {
            int N, M, start;
            N = scanner.nextInt();
            M = scanner.nextInt();
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= N; ++i) {
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < M; ++i) {
                int n1, n2;
                n1 = scanner.nextInt();
                n2 = scanner.nextInt();
                graph.get(n1).add(n2);
                graph.get(n2).add(n1);
            }
            start = scanner.nextInt();

            int[] costs = findShortestReach(graph, start);
            for (int i = 1; i < costs.length; ++i) {
                if (i == start) continue;
                System.out.print(costs[i] + " ");
            }
            System.out.println();
        }
    }
}
