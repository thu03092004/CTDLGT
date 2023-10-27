import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class JavaHashSet {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        Scanner sc = new Scanner(System.in);

        // so dong nhap vao
        int n = sc.nextInt();

        // 2 mang de luu nhung gi nhap vao tren 1 dong
        String[] pair_left = new String[n];
        String[] pair_right = new String[n];

        for(int i = 0; i < n; i++){
            pair_left[i] = sc.next();
            pair_right[i] = sc.next();
            set.add(pair_left[i] + " " + pair_right[i]);
            System.out.println(set.size());
        }
    }
}
