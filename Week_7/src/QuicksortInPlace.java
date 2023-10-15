import java.util.Scanner;

public class QuicksortInPlace {
    public static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static void printArr(int[] a){
        for(int i : a ){
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public static int partition(int[] a, int low, int high){
        int pivot = a[high];
        int i = low; // place for swapping
        for(int j = low; j < high; j++){
            if(a[j] <= pivot){
                swap(a, i, j);
                i++;
            }
        }
        swap(a, i, high);
        printArr(a);
        return i;
    }
    public static void sort(int[] a, int low, int high){
        if(low >= high){
            return;
        }
        int pivot = partition(a, low, high);
        sort(a, low, pivot - 1);
        sort(a, pivot + 1, high);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        sort(a, 0, n - 1);
    }
}