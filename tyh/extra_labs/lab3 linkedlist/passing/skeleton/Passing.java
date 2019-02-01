
/**
 *	Name		: 
 *	Matric No.	: 
 */

import java.util.*;

public class Passing {
    public static void main(String[] args) {
       
        }
    }
}

class LinkedList<E> {
    protected ListNode<E> head = null;
    protected int numNodes = 0;

    public int size(){
       
    }
    public void addAfter(int index, E after) {
       
    }

    public void swap(int index, int startFrom){
       
    }

    public void reverse(){
        
    }

    public void addFirst(E item){
        this.head = new ListNode<E>(item,head);
        this.numNodes ++;
    }

    public E remove(int index){
        
    }

    public boolean contains(E item){
        
    }
    public int findIndex(E item) {
        
    }

    public ListNode<E> get(int index){
        
    }
}

class ListNode<E> {
    protected E element;
    protected ListNode<E> next;

    /* constructors */
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

class Person{
    
}
