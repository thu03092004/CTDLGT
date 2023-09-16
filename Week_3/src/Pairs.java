import java.util.Arrays;
import java.util.Scanner;

public class Pairs {
    public static boolean binarySearch(int[] a, int number){
        int left = 0, right = a.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(a[mid] == number) return true;
            else if(a[mid] > number) right = mid - 1;
            else left = mid + 1;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        int dem = 0;
        for(int i = 0 ; i < n; i++){
            if(binarySearch(a, a[i] + k)) dem++;
        }
        System.out.println(dem);
    }
}
