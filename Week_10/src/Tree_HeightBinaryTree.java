import java.util.Scanner;

class Node{
    Node left;
    Node right;
    int data;
    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}
public class Tree_HeightBinaryTree {
    public static int height(Node root){
        if(root == null) return -1;
        else{
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }
    public static Node insert(Node root, int data){
        if(root == null) return new Node(data);
        else{
            if(data < root.data){
                root.left = insert(root.left, data);
            }
            else {
                root.right = insert(root.right, data);
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        Node root = null;
        while (t-- > 0){
            int data = sc.nextInt();
            root = insert(root, data);
        }
        sc.close();
        int height = height(root);
        System.out.println(height);
    }
}