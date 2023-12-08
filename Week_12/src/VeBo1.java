import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class VeBo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Queue<Integer> maxPQ = new PriorityQueue<>(100000, Collections.reverseOrder());
        Queue<Integer> minPQ = new PriorityQueue<>(100000);
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            if (maxPQ.isEmpty() || x <= maxPQ.peek()) {
                maxPQ.add(x);
            } else {
                minPQ.add(x);
            }
            if (n % 2 == 1) {
                if (maxPQ.size() > minPQ.size() + 1) {
                    minPQ.add(maxPQ.poll());
                } else {
                    if (!minPQ.isEmpty()) {
                        maxPQ.add(minPQ.poll());
                    }
                }
            } else {
                if (maxPQ.size() > minPQ.size()) {
                    minPQ.add(maxPQ.poll());
                } else {
                    if (!minPQ.isEmpty()) {
                        maxPQ.add(minPQ.poll());
                    }
                }
            }
        }
        int sz = n;
        while (m-- > 0) {
            int x = sc.nextInt();
            if (x == 1) {
                sz++;
                int number_add = sc.nextInt();
                if (maxPQ.isEmpty() || number_add <= maxPQ.peek()) {
                    maxPQ.add(number_add);
                } else {
                    minPQ.add(number_add);
                }

                if (sz % 2 == 1) {
                    if (maxPQ.size() == minPQ.size() + 1) {
                        continue;
                    } else if (maxPQ.size() > minPQ.size() + 1) {
                        minPQ.add(maxPQ.poll());
                    } else {
                        maxPQ.add(minPQ.poll());
                    }
                } else {
                    if (maxPQ.size() == minPQ.size()) {
                        continue;
                    } else if (maxPQ.size() < minPQ.size()) {
                        maxPQ.add(minPQ.poll());
                    } else {
                        minPQ.add(maxPQ.poll());
                    }
                }
            } else if (x == 2) {
                sz--;
                maxPQ.poll();
                if (sz % 2 == 0 && maxPQ.size() < minPQ.size()) {
                    maxPQ.add(minPQ.poll());
                }
                if (sz % 2 == 1 && maxPQ.size() < minPQ.size() + 1) {
                    maxPQ.add(minPQ.poll());
                }
            } else {
                System.out.println(maxPQ.peek());
            }
        }
    }
}