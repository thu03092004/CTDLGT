import java.util.Scanner;

public class Bai_1 {
    //tim kiem nhi phan
    public static int binary_search(int[] a, int v, int left, int right){
        while(left <= right) {
            int mid = (left + right) / 2;
            if(a[mid] == v){
                return mid;
            }
            else if (a[mid] < v) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        System.out.println(binary_search(a, v, 0, n-1));
    }
}
