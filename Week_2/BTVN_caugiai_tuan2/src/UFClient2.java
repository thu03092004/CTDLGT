//cách 1:
//import edu.princeton.cs.algs4.StdIn;
//import edu.princeton.cs.algs4.StdOut;
//
//public class UFClient2 {
//    public static int root[] = new int[1000];
//
//    public static int find_root(int x) {
//        return root[x];
//    }
//
//    public static void main(String[] args) {
//        int N = StdIn.readInt();
//        for (int i = 0; i < N; i++) {
//            root[i] = i;
//        }
//        int count = N;
//        int dong = 0;
//        while (!StdIn.isEmpty()) {
//            if (count == 1) {
//                System.out.println(dong);
//                break;
//            }
//            int p = StdIn.readInt();
//            int q = StdIn.readInt();
//            dong++;
//            int root_p = find_root(p);
//            int root_q = find_root(q);
//            if (root_p != root_q) {
//                for (int j = 0; j < N; j++) {
//                    if (root_q == root[j]) {
//                        root[j] = root_p;
//                    }
//                }
//                count--;
//            }
//        }
//        if (count != 1) System.out.println("FAILED");
//    }
//}

// Cách 2

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.UF;

public class UFClient2 {
    public static void main(String[] args) {
        //đọc số lượng đối tượng N
        int N = StdIn.readInt();

        // khởi tạo cấu trúc dữ liệu Union-Find
        UF uf = new UF(N);

        int dem = 0;

        while(!StdIn.isEmpty()){
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            dem++;
            //nếu p, q không liên thông thì thực hiện lệnh union
            if(!uf.connected(p,q)){
                uf.union(p,q);

                //nếu sau lệnh union này, toàn bộ N đối tượng đã liên thông thì in ra stt
                if(uf.count() == 1){
                    System.out.println(dem);
                    break;
                }
            }
        }
        if(uf.count() > 1) System.out.println("FAILED");
    }
}
