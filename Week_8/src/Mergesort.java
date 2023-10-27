import java.util.Scanner;

public class Mergesort {
    public static int[] a = new int[10005];
    public static int[] tmp = new int[10005];
    public static int n;
    public static void mergesort(int[] a, int l, int r){
    if(l == r) {
        return;
    }
    int mid = l + (r - l) / 2;
    mergesort(a, l, mid);
    mergesort(a, mid+1, r);
    int pt1 = l;
    int pt2 = mid + 1;
    int sz = 0;
    while(pt1 <= mid && pt2 <= r){
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
    while (pt2 <= r){
        tmp[sz++] = a[pt2++];
    }
    for(int i = 0; i < sz; i++){
        a[l + i] = tmp[i];
    }
}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        mergesort(a, 0, n-1);
        for(int i = 0; i < n; i++){
            System.out.println(a[i]);
        }
    }
}
