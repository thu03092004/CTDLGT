import java.util.Scanner;

class Node {
    Node left;
    Node right;
    int data;
    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}

public class Tree_InorderTraversal {
    // de quy
    public static void inOrder(Node root){
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
    // chèn một giá trị mới vào cây nhị phân
    /*
    Hàm `insert` trong đoạn mã trên được sử dụng để chèn một giá trị mới vào cây nhị phân. Dưới đây là cách hoạt động của hàm `insert`:

    1. Tham số `root` là một nút gốc của cây nhị phân đã tồn tại hoặc là `null` nếu cây rỗng.
    2. Nếu `root` là `null`, tức là cây rỗng, hàm tạo một nút mới với giá trị `data` và trả về nút mới này.
    3. Nếu `root` không phải là `null`, hàm tiếp tục xử lý như sau:
        - So sánh giá trị `data` với giá trị của `root.data` để xác định xem giá trị mới sẽ được chèn vào phía trái hay phía phải của `root`.
        - Nếu `data` nhỏ hơn hoặc bằng `root.data`, hàm đệ quy gọi chính nó với tham số là `root.left` (nút con trái của `root`) và `data`. Kết quả trả về từ đệ quy này được gán cho biến `cur`.
        - Nếu `data` lớn hơn `root.data`, hàm đệ quy gọi chính nó với tham số là `root.right` (nút con phải của `root`) và `data`. Kết quả trả về từ đệ quy này được gán cho biến `cur`.
        - Sau khi gọi đệ quy và nhận được nút `cur` từ đệ quy, nút `cur` sẽ được gán vào nút con trái (`root.left`) hoặc nút con phải (`root.right`) của `root`, tùy thuộc vào kết quả so sánh ở bước trước.
    4. Cuối cùng, hàm trả về nút gốc `root` của cây nhị phân đã được chèn giá trị mới.

    Tổng quan, hàm `insert` này sử dụng đệ quy để tìm vị trí thích hợp để chèn giá trị mới vào cây nhị phân, duyệt qua các nút gốc và các nút con, và thực hiện chèn vào vị trí phù hợp dựa trên giá trị của các nút.
     */
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
        while(n-- > 0){
            int data = sc.nextInt();
            root = insert(root, data);
        }
        sc.close();
        inOrder(root);
    }
}
