import java.util.Arrays;
import java.util.Scanner;

//import java.util.Arrays;
//
//public class Sum_thuc_hanh {
//    public static int binarySearch(int[] a, int number){
//        int left = 0, right = a.length - 1;
//        while(left <= right){
//            int mid = (left + right) / 2;
//            if(a[mid] == number) return mid;
//            else if(a[mid] < number) left = mid + 1;
//            else right = mid - 1;
//        }
//        return -1;
//    }
//    public static void main(String[] args){
////        In in = new In(args[0]);
////        int[] a = in.readAllInts();
//        int[] a = {-1, -2, 1, 3, 2};
//        Arrays.sort(a);
//        for(int i = 0; i < a.length / 2; i++){
//            for(int k = a.length - 1; k > a.length / 2; k--){
//                int j = binarySearch(a, -a[i] - a[k]);
//                if(j != -1 && i < j && j < k) System.out.println(a[i] + " " + a[j] + " " + a[k]);
//            }
//        }
//    }
//}
public class Sum_thuc_hanh{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        for(int i = 0; i <= n - 3; i++){
            int j = i + 1;
            for(int k = n - 1; k >= i + 2; k--){
                while(j < k){
                    if(a[i] + a[j] + a[k] == 0) {
                        System.out.println(a[i] + " " + a[j] + " " + a[k]);
                        j++;
                    }
                    else if(a[i] + a[j] + a[k] < 0) j++;
                    else break;
                }
            }
        }
    }
}
