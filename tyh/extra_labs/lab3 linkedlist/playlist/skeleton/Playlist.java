/**
 * Name         :
 * Matric. No   :
 * PLab Acct.   :
 */

import java.util.*;

public class Playlist {

    private void run() {
        //implement your "main" method here
    }

    public static void main(String[] args) {
        Playlist myPlaylist = new Playlist();
        myPlaylist.run();
    }
}

class Song {
    //define appropriate attributes, constructors, and methods here
}


class DoublyLinkedList<E> {
    
    //Data attributes
    private ListNode<E> head;
    private ListNode<E> tail;
    private int size;
    
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    // returns the size of the linked list
    public int size() {
        return this.size;
    }
    
    // returns true if the list is empty, false otherwise
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    // adds the specified element to the beginning of the list
    public void addFirst(E element) {
        ListNode<E> newNode = new ListNode<E>(element);
        
        if (size == 0) {
            this.head = newNode;
            this.tail = this.head;
        } else {
            ListNode<E> oldHead = this.head;
            this.head = newNode;
            newNode.setNext(oldHead);
            oldHead.setPrev(newNode);
        }
        
        this.size++;
    }
    
    // retrieves the first element of the list
    public E getFirst() throws NoSuchElementException {
        if (head == null) {
            throw new NoSuchElementException("Cannot get from an empty list");
        } else {
            return head.getElement();
        }
    }
    
    // returns true if the list contains the element, false otherwise
    public boolean contains(E element) {
        for (ListNode<E> current = head; current != null; current = current.getNext()) {
            if (current.getElement().equals(element)) {
                return true;
            }
        }
        
        return false;
    }
    
    // removes the first element in the list
    public E removeFirst() throws NoSuchElementException {
        if (head == null) {
            throw new NoSuchElementException("Cannot remove from an empty list");
        } else {
            ListNode<E> currentHead = head;
            head = head.getNext();
            if (head == null) {
                tail = null;
            } else {
                head.setPrev(null);
            }
            this.size--;
            return currentHead.getElement();
        }
    }
    
    // Returns reference to first node.
    public ListNode<E> getHead() {
        return this.head;
    }
    
    // Returns reference to last node of list.
    public ListNode<E> getTail() {
        return this.tail;
    }
    
}

class ListNode<E> {
    private E element;
    private ListNode<E> next;
    private ListNode<E> prev;
    
    public ListNode(E newElement) {
        this.element = newElement;
        this.next = null;
        this.prev = null;
    }
    
    public void setElement(E newElement) {
        this.element = newElement;
    }
    
    public E getElement() {
        return this.element;
    }
    
    public void setPrev(ListNode<E> previous) {
        this.prev = previous;
    }
    
    public void setNext(ListNode<E> next) {
        this.next = next;
    }
    
    public ListNode<E> getNext() {
        return next;
    }
    
    public ListNode<E> getPrev() {
        return prev;
    }
}
