
/**
 *	Name		: 
 *	Matric No.	:
 */

import java.util.*;

public class Classroom {
    public static void main(String[] args) {
        // define your main method here...

    
    }
    

    

}

class LinkedList<E> {
    protected ListNode<E> head = null;
    protected int numNodes = 0;

    public int size(){
        return numNodes;
    }

    public E remove(int index){
       
    }

    public void addFirst(E item){
        this.head = new ListNode<E>(item,head);
        this.numNodes ++;
    }

    public void addAfter(int index, E after) {
        
    }
    
    public int findIndex(E item) {
        
    }

    public boolean contains(E item){
       
    }

    public ListNode<E> get(int index){
        
    }
}

class ListNode<E> {
    protected E element;
    protected ListNode<E> next;
    
    /* constructor */
    public ListNode(E item) {
        element = item;
        next = null;
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
