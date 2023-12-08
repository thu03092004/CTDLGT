//Thực hiện các thao tác sau (vẽ/chạy bằng tay) với cây thứ tự bộ phận (cây max-heap):
//        - Thêm lần lượt vào cây: 1, 3, 10, 9, 6, 7, 4, 5, 2, 8
//        - Lấy và xoá giá trị lớn nhất (ở gốc) 4 lần liên tiếp

import java.util.Scanner;

public class Bai_2a {
    // Khai bao max heap, bat dau heap tu chi so 1
    static class MaxHeap{
        private int[] Heap;
        private int size; // xac dinh so luong phan tu hien tai
        private int maxsize; // xac dinh kich thuoc toi da cua cay
        public MaxHeap(int size){
            this.maxsize = size;
            this.size = 0;
            Heap = new int[this.maxsize + 1];
            Heap[0] = Integer.MAX_VALUE;
        }
        private int parent(int pos){
            return pos / 2;
        }
        private int leftChild(int pos){
            return (2*pos);
        }
        private int rightChild(int pos){
            return (2*pos + 1);
        }
        private void swap(int fpos, int spos){
            int tmp = Heap[fpos];
            Heap[fpos] = Heap[spos];
            Heap[spos] = tmp;
        }
        // chuyen goc xuong la
        private void downHeapify(int pos){
            if(pos >= size / 2 && pos <= size) return;

            if(Heap[pos] < Heap[leftChild(pos)]
                    || Heap[pos] < Heap[rightChild(pos)]){
                if(Heap[leftChild(pos)] > Heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    downHeapify(leftChild(pos));
                } else {
                    swap(pos, rightChild(pos));
                    downHeapify(rightChild(pos));
                }
            }
        }
        // tu la len goc
        private void heapifyUp(int pos){
            int temp = Heap[pos];
            while(pos > 0 && temp > Heap[parent(pos)]){
                Heap[pos] = Heap[parent(pos)];
                pos = parent(pos);
            }
            Heap[ pos] = temp;
        }
        public void insert(int element){
            Heap[size++] = element;
            int current = size;
            heapifyUp(current);
        }
        public int extractMax(){
            int max = Heap[1];
            Heap[1] = Heap[size--];
            downHeapify(1);
            return max;
        }
        public void print(){
            for(int i = 1; i <= size / 2; i++){
                System.out.print(+ Heap[i] + ": L- "
                        + Heap[2*i] + "R- " + Heap[2*i + 1]);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MaxHeap maxHeap = new MaxHeap(15);
        while(sc.hasNext()){
            int x = sc.nextInt();
            maxHeap.insert(x);
        }
        maxHeap.print();
        for(int i = 0; i < 4; i++){
            System.out.println(maxHeap.extractMax());
        }
    }
}
