import java.util.Scanner;

// tom tat: in ra 2 so co chenh lech nho nhat
// su dung thuat toan merge sort
public class ClosestNumber {
    public static int[] a = new int[100005];
    public static int[] tmp = new int[100005];
    public static int n;
    public static void mergesort(int[] a, int left, int right){
        if(left == right) return;
        int mid = left + (right - left) / 2;
        mergesort(a, left, mid);
        mergesort(a, mid + 1, right);
        int pt1 = left;
        int pt2 = mid + 1;
        int sz = 0;
        while(pt1 <= mid && pt2 <= right){
            if(a[pt1] <= a[pt2]){
                tmp[sz++] = a[pt1++];
            }
            else{
                tmp[sz++] = a[pt2++];
            }
        }
        while(pt1 <= mid){
            tmp[sz++] = a[pt1++];
        }
        while(pt2 <= right){
            tmp[sz++] = a[pt2++];
        }
        for(int i = 0; i < sz; i++){
            a[left + i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        mergesort(a, 0, n - 1);
        int min = a[1] - a[0];
        for(int i = 1; i < n - 1; i++){
            min = Math.min(min, a[i+1] - a[i]);
        }
        for(int i = 0; i < n - 1; i++){
            if(a[i+1] - a[i] == min){
                System.out.print(a[i] + " " + a[i+1] + " ");
            }
        }
    }
}
