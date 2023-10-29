import java.util.LinkedList;
import java.util.Scanner;

class MyPriorityQueue<E extends Comparable<E>> {
    private LinkedList<E> queue;

    public MyPriorityQueue() {
        queue = new LinkedList<>();
    }

    public void add(E element) {
        if (queue.isEmpty()) {
            queue.add(element);
        } else {
            int index = 0;
            while (index < queue.size() && element.compareTo(queue.get(index)) > 0) {
                index++;
            }
            queue.add(index, element);
        }
    }

    public E peek() {
        if (queue.isEmpty()) {
            return null;
        }
        return queue.getFirst();
    }

    public E poll() {
        if (queue.isEmpty()) {
            return null;
        }
        return queue.removeFirst();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }
}

public class bai_bonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int dem = 0;
        MyPriorityQueue<Integer> myPriorityQueue = new MyPriorityQueue<>();
        for (int i = 0; i < n; i++) {
            myPriorityQueue.add(sc.nextInt());
        }
        while(myPriorityQueue.peek() < k && myPriorityQueue.size() > 1){
            int first = myPriorityQueue.poll();
            int second = myPriorityQueue.poll();
            int new_int = first + second * 2;
            myPriorityQueue.add(new_int);
            dem++;
        }
        if(myPriorityQueue.peek() < k){
            System.out.println("-1");
        } else{
            System.out.println(dem);
        }
    }
}