import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class JesseCookies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N, K;
        N = scanner.nextInt();
        K = scanner.nextInt();

        Queue<Integer> pqueue = new PriorityQueue<Integer>(N);
        for (int i = 0; i < N; i++) {
            pqueue.add(scanner.nextInt());
        }

        int operations = 0;
        while (pqueue.size() > 1 && pqueue.peek() < K) {
            int leastSweet = pqueue.poll();
            int secondLeastSweet = pqueue.poll();
            int newCookieSweetness = leastSweet + 2 * secondLeastSweet;
            pqueue.add(newCookieSweetness);
            operations++;
        }

        if (pqueue.peek() < K) {
            System.out.println("-1");
        } else {
            System.out.println(operations);
        }
    }
}
