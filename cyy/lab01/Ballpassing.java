import java.util.Scanner;
import java.util.NoSuchElementException;

/**
 * Name         : Chen Yongyan
 * Matric. No   : A0177871N
 * PLab Acct.   : 
 */


public class  Ballpassing{

    /**
     * This is a universal class for ListNode
     * @param <E>
     */
    class ListNode <E> {

        protected E element;
        protected ListNode <E> next, last;
        
        public ListNode(E item){
            element = item;
            next = null;
            last = null;
        }

        public ListNode(E item, ListNode <E> l, ListNode <E> n){
            element = item;
            last = l;
            next = n;
        }

        public ListNode <E> getLast(){ return this.last; }

        public ListNode <E> getNext(){ return this.next; }

        public E getElement(){ return this.element; }

        public void changeLast(ListNode <E> l){ this.last = l; }

        public void changeNext(ListNode <E> n){ this.next = n; }
        
        public void changeElement(E e){ this.element = e; }

    }
    
    /**
     * Another universal class for circular linked list.
     * @param <E>
     */

    public class CircularList <E> {

        protected ListNode <E> pointer = null, head = null;
        protected int len = 0;
        
        public boolean isEmpty(){ return (len == 0); }
        
        public int length() { return len; }
        
        public E getCurrent() throws NoSuchElementException{
            if (pointer == null)
                throw new NoSuchElementException("Empty List");
            else
                return pointer.getElement();
        }

        public void toNext() throws NoSuchElementException{
            if (pointer == null)
                throw new NoSuchElementException("Empty List");
            else
                pointer = pointer.getNext();
        }

        public void toLast() throws NoSuchElementException{
            if (pointer == null)
                throw new NoSuchElementException("Empty List");
            else
                pointer = pointer.getLast();
        }

        public void removeCurrent() throws NoSuchElementException{
            if (pointer == null)
                throw new NoSuchElementException("Empty List");
            else{
                ListNode <E> l = pointer.getLast();
                ListNode <E> n = pointer.getNext();
                l.changeNext(n);
                n.changeLast(l);
                pointer = n;
                len--;
            }
        }

        public void addAfter(E item){
            if (pointer == null){
                pointer = new ListNode <E> (item);
                pointer.changeLast(pointer);
                pointer.changeNext(pointer);
                head = pointer;
            }
            else{
                ListNode <E> n = pointer.getNext();
                ListNode <E> e = new ListNode <E> (item, pointer, n);
                pointer.changeNext(e);
                n.changeLast(e);
            }
            len++;
        }

        public void addBefore(E item){
            if (pointer == null){
                pointer = new ListNode <E> (item);
                pointer.changeLast(pointer);
                pointer.changeNext(pointer);
                head = pointer;
            }
            else{
                ListNode <E> l = pointer.getLast();
                ListNode <E> e = new ListNode <E> (item, l, pointer);
                pointer.changeLast(e);
                l.changeNext(e);
            }
            len++;
        }

        public void print(int l, int r) throws NoSuchElementException{
            if (pointer == null){
                throw new NoSuchElementException("Empty List");
            }
            ListNode <E> p = head;
            for (int i = 0; i < l; i++) p = p.getNext();
            System.out.print(p.getElement());
            for (int i = l; i < r - 1; i++){
                p = p.getNext();
                System.out.print("  "+p.getElement());
            }
            System.out.println(p.getElement());
        }

        public void print(){
            print(0, len);
        }

    }

    void run(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        CircularList <String> list = new CircularList <String> ();
        
        for (int i = 0; i < n; i++) list.addBefore(sc.next());
        // Edited here. Based on the understanding of "Circulation".

        int m = sc.nextInt();
        String order;

        for (int i = 0; i < m; i++){
            order = sc.next();
            switch (order){
                case "LEAVE":
                    list.removeCurrent();
                    break;
                case "JOIN":
                    list.addAfter(sc.next());
                case "NEXT":
                    list.toNext();
                    break;
            }
            System.out.println(list.getCurrent());
        }
        sc.close();
    }

	public static void main(String[] args) {
		Ballpassing newBallpassing = new Ballpassing();
		newBallpassing.run();
	}
}
