public static boolean ok;
public static int getNode(SinglyLinkedListNode llist, int positionFromTail) {
        // Write your code here
        SinglyLinkedListNode tmp = llist;
        int length = 0;
        while(tmp != null){
        length++;
        tmp = tmp.next;
        }
        int position = length - positionFromTail - 1;
        while(position > 0){
        llist = llist.next;
        position--;
        }
        return llist.data;
        }