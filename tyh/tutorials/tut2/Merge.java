/**
 * Merge
 */
public class Merge {
    public static BasicLinkedList<> merge(BasicLinkedList<> a, BasicLinkedList<> b) {
        BasicLinkedList<> temp = new BasicLinkedList<>();
        temp.num_nodes = a.size() + b.size();
        if(a.isEmpty()) {
            temp.head = b.head;
        } else if(b.isEmpty()) {
            temp.head = a.head;
        } else {
            ListNode<> cur;
            ListNode<> up;
            ListNode<> down;
            if(a.head.getElement() > b.head.getElement()) {
                temp.head = b.head;
            } else {
                temp.head = a.head;
            }
            cur = temp.head;

        }
    }
    public static void main(String[] args) {
        
    }
}