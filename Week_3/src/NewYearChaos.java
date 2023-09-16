import java.util.Scanner;

public class NewYearChaos {
    public static void minimumBribes(int[] a){
        // khởi tạo biến đếm số lượng hối lộ
        int bribes = 0;
        // duyệt từ cuối hàng về đầu hàng
        for(int i = a.length - 1; i >= 0; i--){
            // nếu người hiện tại đứng trước hơn 2 vị trí so với ban đầu
            if((a[i] - (i + 1)) > 2){
                // in ra va ket thuc ham
                System.out.println("Too chaotic");
                return;
            }
            // duyet tu vi tri lon hon giua 0 va a[i] - 2 den vi tri i
            for(int j = Math.max(0, a[i] - 2); j < i; j++){
                // neu co nguoi dung truoc co so lon hon hien tai
                if(a[j] > a[i]) {
                    // tang bien dem len 1
                    bribes++;
                }
            }
        }
        System.out.println(bribes);
        return;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t; i++){
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int j = 0; j < n; j++){
                a[j] = sc.nextInt();
            }
            minimumBribes(a);
        }
        sc.close();
    }
}
