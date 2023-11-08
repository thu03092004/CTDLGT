import java.util.Scanner;

class Node {
    public int ht;
    Node left;
    Node right;
    int val;

    Node(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

public class AVL {
    public static int getHeight(Node root) {
        return root == null ? -1 : root.ht;
    }

    public static void update_height(Node root) {
        root.ht = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    public static Node rotate_with_left(Node root) {
        Node temp = root.left;
        root.left = temp.right;
        temp.right = root;

        update_height(root);
        update_height(temp);
        return temp;
    }

    public static Node rotate_with_right(Node root) {
        Node temp = root.right;
        root.right = temp.left;
        temp.left = root;

        update_height(root);
        update_height(temp);
        return temp;
    }

    public static int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    public static Node insert(Node root, int value) {
        if (root == null) {
            Node ans = new Node(value);
            ans.left = null;
            ans.right = null;
            ans.ht = 0;
            return ans;
        } else if (value < root.val) {
            root.left = insert(root.left, value);
            if (getHeight(root.left) - getHeight(root.right) == 2) {
                if (value > root.left.val) {
                    root.left = rotate_with_right(root.left);
                }
                root = rotate_with_left(root);
            }
        } else {
            root.right = insert(root.right, value);
            if (getHeight(root.right) - getHeight(root.left) == 2) {
                if (value < root.right.val) {
                    root.right = rotate_with_left(root.right);
                }
                root = rotate_with_right(root);
            }
        }
        update_height(root);
        return root;
    }

    public static void printTreeInOrder(Node root) {
        if (root != null) {
            printTreeInOrder(root.left);
            System.out.print(root.val + "(BF=" + getBalanceFactor(root) + ") ");
            printTreeInOrder(root.right);
        }
    }

    public static void preOrder(Node root){
        if(root == null) return;
        System.out.print(root.val + "(BF=" + getBalanceFactor(root) + ") ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        Node root = null;
        while (t-- > 0) {
            int value = sc.nextInt();
            root = insert(root, value);
        }
        int x = sc.nextInt();
        root = insert(root, x);

        printTreeInOrder(root);
        System.out.println();

        preOrder(root);
    }

}