import java.util.*;

public class SimpleTextEditor {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int Q = sc.nextInt();
        String text = "";
        Stack <String> oldVersion = new Stack<>();
        for(int i = 0; i < Q; i++){
            int request = sc.nextInt();
            switch(request){
                //append
                case 1:
                {
                    oldVersion.push(text);
                    String append = sc.next();
                    text += append;
                    break;
                }
                //delete
                case 2:
                {
                    oldVersion.push(text);
                    int k = sc.nextInt();
                    String newText = text.substring(0, text.length() - k);
                    text = newText;
                    break;
                }
                //print
                case 3:
                {
                    int k = sc.nextInt();
                    System.out.println(text.charAt(k - 1));
                    break;
                }
                //undo
                case 4:
                {
                    if(!oldVersion.isEmpty()){
                        String oldText = oldVersion.pop();
                        text = oldText;
                    }
                    break;
                }
            }
        }
    }
}
