import java.util.HashSet;
import java.util.Scanner;

public class Pairs_again {
    public static int countPairs(int[] a, int k){
        HashSet<Integer> numSet = new HashSet<>();
        int count = 0;
        for(int i : a){
            if(numSet.contains(i - k)) {
                count++;
            }
            if(numSet.contains(i + k)) {
                count++;
            }
            numSet.add(i);
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        System.out.println(countPairs(a, k));
    }
}
