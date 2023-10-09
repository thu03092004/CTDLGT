import java.util.Scanner;

class MyNode{
    int data;
    MyNode next;
    MyNode(int value){
        this.data = value;
        this.next = null;
    }
}
public class insertANodeAtASpecificPosition {
    public static MyNode insertNodeAtPosition(MyNode list, int data, int position){
        MyNode current = list;
        MyNode node = new MyNode(data);
        int count_pos = 1;
        while (count_pos < position){
            current = current.next;
            count_pos++;
        }
        MyNode tmp = current.next;
        current.next = node;
        node.next = tmp;
        return list;
    }
    public static void print(MyNode head){
        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        MyNode list = null;
        MyNode temp = null;
        MyNode prev = null;
        for(int i = 0; i < n; i++){
            int value = sc.nextInt();
            temp = new MyNode(value);
            if(list == null){
                list = temp;
            }
            else{
                prev.next = temp;
            }
            prev = temp;
        }
        int data = sc.nextInt();
        int position = sc.nextInt();
        insertNodeAtPosition(list, data, position);
        print(list);
    }
}
