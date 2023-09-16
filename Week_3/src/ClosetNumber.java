import java.util.Arrays;
import java.util.Scanner;

public class ClosetNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        int min = a[1] - a[0];
        for(int i = 1; i < n - 1; i++){
            if((a[i+1] - a[i]) < min) min = a[i+1] - a[i];
        }
        for(int i = 0; i < n - 1; i++){
            if((a[i+1] - a[i]) == min){
                System.out.print(a[i] + " " + a[i+1] + " ");
            }
        }
    }
}
