/**
 * Name         :
 * Matric No    :
 * Plab Acct.   :
 *
 */

import java.util.*;

public class Cards {
    TailedLinkedList<Card> cards;

    Cards() {
        cars = new TailedLinkedList<Card>();
    }

    private void swap(int a, int b, int c, int d) {
        ListNode<Card> beforeA = get(a-2);
        ListNode<Card> A = beforeA.getNext();
        ListNode<Card> B = get(b-1);
        ListNode<Card> afterB = B.getNext();
        ListNode<Card> beforeC = get(c-2);
        ListNode<Card> C = beforeC.getNext();
        ListNode<Card> D = get(d-1);
        ListNode<Card> afterD = D.getNext();
        beforeA.setNext(C);
        B.setNext(afterD);
        beforeC.setNext(A);
        D.setNext(afterB);
    }

    private void details(int index) {
        Card t = cards.get(index);
        System.out.printf("%s %d\n", t.name, t.age);
    }

    private void shuffle() {
        ListNode<Card> first;
        ListNode<Card> second;
        
    }

    private void print() {
        ListNode<Card> t = cards.getHead();
        while(true) {
            System.out.print(t.getElement().name);
            if(t.getNext() == null) {
                break;
            } else {
                t = t.getNext();
                System.out.print(" ");
            }
        }
    }

    public void run() {
        // implement your "main" method here

    }
    
    public static void main(String[] args) {
        Cards myCards = new Cards();
        myCards.run();
    }
}

class Card {
    String name;
    int age;
    Card(String name, int age) {
        this.name = name; this.age = age;
    }
}

class TailedLinkedList<E> {

    // Data attributes
    private ListNode<E> head;
    private ListNode<E> tail;
    private int num_nodes;

    public TailedLinkedList() {
        this.head = null;
        this.tail = null;
        this.num_nodes = 0;
    }

    // Return true if list is empty; otherwise return false.
    public boolean isEmpty() {
        return (num_nodes == 0);
    }

    // Return number of nodes in list.
    public int size() {
        return num_nodes;
    }

    // Return value in the first node.
    public E getFirst() throws NoSuchElementException {
        if (head == null)
            throw new NoSuchElementException("can't get from an empty list");
        else
            return head.getElement();
    }

    // Return true if list contains item, otherwise return false.
    public boolean contains(E item) {
        for (ListNode<E> n = head; n != null; n = n.getNext())
            if (n.getElement().equals(item))
                return true;

        return false;
    }



    // Add item to front of list.
    public void addFirst(E item) {
        head = new ListNode<E>(item, head);
        num_nodes++;
        if (num_nodes == 1) tail = head;
    }

    // Return reference to first node.
    public ListNode<E> getHead() {
        return head;
    }

    // Return reference to last node of list.
    public ListNode<E> getTail() {
        return tail;
    }

    // Add item to end of list.
    public void addLast(E item) {
        if (head != null) {
            tail.setNext(new ListNode<E>(item));
            tail = tail.getNext();
        } else {
            tail = new ListNode<E>(item);
            head = tail;
        }
        num_nodes++;
    }

    // Remove node after node referenced by current
    public E removeAfter(ListNode<E> current) throws NoSuchElementException {
        E temp;
        if (current != null) {
            ListNode<E> nextPtr = current.getNext();
            if (nextPtr != null) {
                temp = nextPtr.getElement();
                current.setNext(nextPtr.getNext());
                num_nodes--;
                if (nextPtr.getNext() == null) // last node is removed
                    tail = current;
                return temp;
            } else
                throw new NoSuchElementException("No next node to remove");
        } else { // if current is null, we want to remove head
            if (head != null) {
                temp = head.getElement();
                head = head.getNext();
                num_nodes--;
                if (head == null)
                    tail = null;
                return temp;
            } else
                throw new NoSuchElementException("No next node to remove");
        }
    }

    // Remove first node of list.
    public E removeFirst() throws NoSuchElementException {
        return removeAfter(null);
    }

    // Remove item from list
    public E remove(E item) throws NoSuchElementException {
        ListNode<E> current = head;
        if (current == null) {
            throw new NoSuchElementException("No node to remove");
        }
        if (current.getElement().equals(item)) {
            return removeAfter(null);
        }
        while (current.getNext().getElement() != null) {
            if (current.getNext().getElement().equals(item)) {
                return removeAfter(current);
            }
            current = current.getNext();
        }
        throw new NoSuchElementException("No node to remove");
    }

    public ListNode<E> get(int index) {
        ListNode<E> res = head;
        for(int i=0;i<index-1;i++) {
            res = res.getNext();
        }
        return res;
    }
}

class ListNode<E> {
    protected E element;
    protected ListNode<E> next;

    /* constructors */
    public ListNode(E item) {
        this.element = item;
        this.next = null;
    }

    public ListNode(E item, ListNode<E> n) {
        element = item;
        next = n;
    }

    /* get the next ListNode */
    public ListNode<E> getNext() {
        return this.next;
    }

    /* get the element of the ListNode */
    public E getElement() {
        return this.element;
    }

    public void setNext(ListNode<E> item) {
        this.next = item;
    }

    public void setElement(E item) {
        this.element = item;
    }
}

