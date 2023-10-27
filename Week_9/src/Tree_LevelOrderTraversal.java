import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

//class Node{
//    Node left;
//    Node right;
//    int data;
//    Node(int data){
//        this.data = data;
//        left = null;
//        right = null;
//    }
//}
public class Tree_LevelOrderTraversal {
    public static void levelOrder(Node root){
        Queue<Node> queue = new LinkedList<>();
        if(root != null){
            queue.add(root);
        }
        while(!queue.isEmpty()){
            Node p = queue.poll();
            System.out.print(p.data + " ");
            if(p.left != null) queue.add(p.left);
            if(p.right != null) queue.add(p.right);
        }
    }
    public static Node insert(Node root, int data){
        if(root == null){
            return new Node(data);
        }
        else {
            Node cur;
            if(data <= root.data){
                cur = insert(root.left, data);
                root.left = cur;
            }
            else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node root = null;
        while(n-- > 0){
            int data = sc.nextInt();
            root = insert(root, data);
        }
        sc.close();
        levelOrder(root);
    }
}
