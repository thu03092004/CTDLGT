import java.util.PriorityQueue;
import java.util.Scanner;

public class Bai_bonus_Gift {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int sumK = 0;
        for(int i = 0; i < k; i++){
            priorityQueue.add(arr[i]);
            sumK += arr[i];
            System.out.print(sumK + " ");
        }
        for(int i = k; i < n; i++){
            // them 1 phan tu vao thi xoa phan tu nho nhat
            priorityQueue.add(arr[i]);
            sumK += arr[i];
            sumK -= priorityQueue.poll();
            System.out.print(sumK + " ");
        }
        sc.close();
    }
}