import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BinarySearch {
    public static int binarySearch(int[] a, int number){
        int left = 0;
        int right = a.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(a[mid] == number) return mid;
            else if(a[mid] < number) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int N = sc.nextInt();
        int[] a = new int[N];
        for(int i = 0; i < N; i++){
            a[i] = random.nextInt(100);
        }
        // in ra mang gom N phan tu ngau nhien tu 0 den 99
        for(int i = 0; i < N; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
        // sap xep
        Arrays.sort(a);
        // in ra mang sau khi sap xep
        for(int i = 0; i < N; i++){
            System.out.print(a[i] + " ");
        }
    }
}
