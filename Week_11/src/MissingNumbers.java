import java.util.*;

public class MissingNumbers {
    public static List<Integer> missingNumbers(List<Integer> a, List<Integer> b) {
        Collections.sort(a);
        Collections.sort(b);
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < b.size(); i++){
            if(a.contains(b.get(i))) {
                a.remove(b.get(i));
            } else {
                if(!result.contains(b.get(i))) {
                    result.add(b.get(i));
                }
            }
        }
        Collections.sort(result);
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> a = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            a.add(x);
        }
        int m = sc.nextInt();
        List<Integer> b = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            int x = sc.nextInt();
            b.add(x);
        }
        List<Integer> result = new ArrayList<>();
        result = missingNumbers(a, b);
        for(int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
    }
}
