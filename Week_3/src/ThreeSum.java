//import edu.princeton.cs.algs4.In;
//import edu.princeton.cs.algs4.StdOut;
//import edu.princeton.cs.algs4.Stopwatch;
//
//public class ThreeSum {
//
//    // Do not instantiate.
//    private ThreeSum() {
//    }
//
//
//    public static void printAll(int[] a) {
//        int n = a.length;
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                for (int k = j + 1; k < n; k++) {
//                    if (a[i] + a[j] + a[k] == 0) {
//                        StdOut.println(a[i] + " " + a[j] + " " + a[k]);
//                    }
//                }
//            }
//        }
//    }
//
//
//    public static int count(int[] a) {
//        int n = a.length;
//        int count = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                for (int k = j + 1; k < n; k++) {
//                    if (a[i] + a[j] + a[k] == 0) {
//                        count++;
//                    }
//                }
//            }
//        }
//        return count;
//    }
//
//    public static void main(String[] args) {
//        In in = new In(args[0]);
//        int[] a = in.readAllInts();
//        Stopwatch timer = new Stopwatch();
//        int count = count(a);
//        StdOut.println("elapsed time = " + timer.elapsedTime());
//        StdOut.println(count);
//    }
//}

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.SuffixArray;

import java.util.Arrays;

public class ThreeSum {
    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] a = in.readAllInts();
        Arrays.sort(a);
        for(int i = 0; i < a.length - 2; i++){
            int j = i + 1;
            int k = a.length - 1;
            while(j < k){
                if(a[i] + a[j] + a[k] == 0){
                    System.out.println(a[i] + " " + a[j] + " " + a[k]);
                    j++;
                    k--;s
                }
                else if(a[i] + a[j] + a[k] > 0) k--;
                else j++;
            }
        }
    }
}