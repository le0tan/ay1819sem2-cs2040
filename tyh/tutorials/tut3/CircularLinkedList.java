public class CircularLinkedList<E> {
    private int _size;
    private ListNode<E> _head;
    private ListNode<E> _tail;

    public void addFirst(E element) {
        _size++;
        _head = new ListNode<E>(element, _head);
        if (_tail == null)
            _tail = _head;
        _tail.setNext(_head);
    }

    public void swap(int index) {
        if(_size <= 1) {
            return;
        } else {
            index = index % _size;
            ListNode<E> prev;
            if(index == 0) {
                prev = _tail;
            } else {
                prev = _head;
                for(int i=0; i<index-1; i++) {
                    prev = prev.getNext();
                }
            }
            ListNode<E> cur = prev.getNext();
            ListNode<E> b = cur.getNext();
            ListNode<E> c = b.getNext();
            boolean isHeadA = cur == _head ? true : false;
            boolean isTailA = cur == _tail ? true : false;
            boolean isHeadB = b == _head ? true : false;
            boolean isTailB = b == _tail ? true : false;
            prev.setNext(b);
            cur.setNext(c);
            b.setNext(cur);
            if(isHeadA) _head = b;
            if(isTailA) _tail = b;
            if(isHeadB) _head = cur;
            if(isTailB) _tail = cur;
        }
    }

    public void print() {
        ListNode<E> cur = _head;
        do {
            System.out.println(cur.getElement());
            cur = cur.getNext();
        } while(cur != _tail);
        if(_head != _tail) {
            System.out.println(_tail.getElement());
        }
    }

    public static void main(String[] args) {
        CircularLinkedList<Integer> ls = new CircularLinkedList<Integer>();
        ls.addFirst(1);
        ls.addFirst(2);
        ls.addFirst(3);
        ls.print();
        ls.swap(0);
        ls.print();
    }
}