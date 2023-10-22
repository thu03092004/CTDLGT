import java.util.Scanner;

public class StringReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        boolean check = true;
        for(int i = 0; i < a.length()/2; i++){
            if(a.charAt(i) != a.charAt(a.length() - 1 - i)){
                check = false;
                break;
            }
        }
        if(check) {
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }
}
