import java.util.Scanner;

public class printInReverse {
    Node head = null;
    public class Node{
        int data;
        Node next;
        public Node(int data, Node next){
            this.data = data;
            this.next = null;
        }
    }
    public void append(int data){
        head = append(data, head);
    }
    private Node append(int data, Node node){
        if(node == null) return new Node(data, null);
        node.next = append(data, node.next);
        return node;
    }
    public String toString(){
        return toString(head);
    }
    private String toString(Node node){
        if(node == null) return "\n";
        return node.data + "\n" + toString(node.next);
    }
    public static void reversePrint(Node list) {
        if (list.next != null) reversePrint(list.next);
        System.out.println(list.data);

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t; i++){
            int n = sc.nextInt();
            printInReverse list = new printInReverse();
            for(int j = 0; j < n; j++){
                int x = sc.nextInt();
                list.append(x);
            }
            reversePrint(list.head);
        }
    }
}
