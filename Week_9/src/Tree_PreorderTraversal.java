import java.util.Scanner;

// class Node
// ...

public class Tree_PreorderTraversal {
    //ngan xep ???
    // de quy
    public static void preOrder(Node root){
        if(root == null) return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static Node insert(Node root, int data){
        if(root == null){
            return new Node(data);
        }
        else{
            Node cur;
            if(data <= root.data){
                cur = insert(root.left, data);
                root.left = cur;
            }
            else{
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
        while (n-- > 0){
            int data = sc.nextInt();
            root = insert(root, data);
        }
        sc.close();
        preOrder(root);
    }
}
