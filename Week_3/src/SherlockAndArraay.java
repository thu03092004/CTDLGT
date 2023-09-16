import java.util.Scanner;

public class SherlockAndArraay {
    public static String check(int[] a) {
        int sum_left = 0, sum_right = 0;
        for (int i = 1; i < a.length; i++) {
            sum_right += a[i];
        }
        if (sum_left == sum_right) return "YES";
        for (int i = 0; i < a.length - 2; i++) {

            sum_left += a[i];
            sum_right -= a[i + 1];
            System.out.println(sum_left + " " + sum_right);
            if (sum_left == sum_right) return "YES";
        }
        return "NO";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int j = 0; j < t; j++) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            System.out.println(check(a));
        }
    }
}
