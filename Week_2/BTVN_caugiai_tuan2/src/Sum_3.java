import edu.princeton.cs.algs4.In;

public class Sum_3 {
    public static void main(String[] args) {
        In in = new In("D:\\Cau_giai\\btvn\\BTVN_caugiai_tuan2\\4Kints.txt");
        int[] a = in.readAllInts();
        for(int i = 0; i < a.length; i++){
            for(int j = i + 1; j < a.length; j++){
                for(int k = j + 1; k < a.length; k++){
                    if(a[i] + a[j] + a[k] == 0) System.out.println(a[i] + " " + a[j] + " " + a[k]);
                }
            }
        }
    }
}
