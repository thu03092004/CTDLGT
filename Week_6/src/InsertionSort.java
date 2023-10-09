import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        int tmp = a[n-1];
        for(int i = n - 2; i >= 0; i--){
            if(a[i] > tmp){
                a[i + 1] = a[i];
                for(int j = 0; j < n; j++){
                    System.out.print(a[j] + " ");
                }
                System.out.println();
            }
            else{
                a[i + 1] = tmp;
                for(int j = 0; j < n; j++){
                    System.out.print(a[j] + " ");
                }
                System.out.println();
                break;
            }
        }
        if(a[0] > tmp){
            a[0] = tmp;
            for(int j = 0; j < n; j++){
                System.out.print(a[j] + " ");
            }
            System.out.println();
        }
    }
}
