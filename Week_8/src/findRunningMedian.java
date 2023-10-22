import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class findRunningMedian {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Queue<Integer> maxPQ = new PriorityQueue<Integer>(N / 2 + 1, Collections.reverseOrder());
        Queue<Integer> minPQ = new PriorityQueue<Integer>(N / 2 + 1);

        for (int i = 0; i < N; i++) {
            int x = scanner.nextInt();

            if (maxPQ.isEmpty() || x <= maxPQ.peek()) {
                maxPQ.add(x);
            } else {
                minPQ.add(x);
            }

            if (maxPQ.size() > minPQ.size() + 1) {
                minPQ.add(maxPQ.poll());
            } else if (minPQ.size() > maxPQ.size()) {
                maxPQ.add(minPQ.poll());
            }

            double median;
            if (maxPQ.size() == minPQ.size()) {
                median = (maxPQ.peek() + minPQ.peek()) / 2.0;
            } else {
                median = maxPQ.peek();
            }

            System.out.printf("%.1f\n", median);
        }
    }
}
