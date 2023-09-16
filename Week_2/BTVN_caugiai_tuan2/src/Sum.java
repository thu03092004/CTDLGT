import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdArrayIO;

public class Sum {
    public static void main(String[] args) {
        In in = new In("D:\\Cau_giai\\btvn\\BTVN_caugiai_tuan2\\4Kints.txt"); // tạo luồng đọc file
        int[] a = in.readAllInts(); // đọc toàn bộ file vào mảng a
        //StdArrayIO.print(a); // in mảng ra màn hình
        for(int i = 0; i < a.length; i++){
            for(int j = i + 1; j < a.length; j++){
                if(a[j] == (-1) * a[i]) System.out.println(a[i] + " " + a[j]);
            }
        }
    }
}