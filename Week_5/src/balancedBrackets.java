import java.io.*;
import java.util.*;

class Result {
    // public static String isBalanced(String s) {
    //     char[] c = new char[1003];
    //     int top = 0;
    //     for(int i = 0; i < s.length(); i++){
    //         if(s.charAt(i) == '(' ||s.charAt(i) == '[' || s.charAt(i) == '{'){
    //             c[++top] = s.charAt(i);
    //         }
    //         else {
    //             if(top == 0){
    //                 return "NO";
    //             }
    //             else{
    //                 if((c[top] == '(' && s.charAt(i) == ')') || (c[top] == '[' && s.charAt(i) == ']') || (c[top] == '{' && s.charAt(i) == '}')){
    //                     --top;
    //                 }else{
    //                     return "NO";
    //                 }
    //             }
    //         }
    //     }
    // if(top == 0) return "YES";
    // return "NO";

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static boolean isMatching(char a, char b){
        return ( a == '(' && b == ')' ) ||
                ( a == '[' && b == ']' ) ||
                ( a == '{' && b == '}' );
    }
    public static String isBalanced(String s) {
        // Write your code here
        Stack<Character> str = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if(cur == '(' || cur == '[' || cur == '{'){
                str.push(cur);
            }
            else {
                if(str.isEmpty()){
                    return "NO";
                }
                else if(!isMatching(str.peek(), cur)){
                    return "NO";
                }
                else{
                    str.pop();
                }
            }
        }
        if(str.isEmpty()){
            return "YES";
        }
        else {
            return "NO";
        }

    }
}

public class balancedBrackets {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            String s = bufferedReader.readLine();

            String result = Result.isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
