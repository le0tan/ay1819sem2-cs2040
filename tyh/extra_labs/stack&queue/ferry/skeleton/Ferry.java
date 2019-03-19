/**
 * Name         :
 * Matric No.   :
 * PLab Acct.   :
 */

import java.util.*;

public class Ferry {

    private void run() {
        // implement your "main" method here...
    }

    public static void main(String[] args) {
        Ferry trip = new Ferry();
        trip.run();
    }
}

class Queue<E> {
    
    private LinkedList<E> elements;
    
    public Queue() {
        elements = new LinkedList<E>();
    }
    
    public void enqueue(E element) {
        elements.add(element);
    }
    
    /**
     * Pre-Condition: The elements in the queue IS NOT EMPTY
     * Post-Condition: Returns the head of the queue AND removes it from the queue
     *
     * This method throws an exception if the queue is empty when called
     */
    public E dequeue() {
        return elements.removeFirst();
    }
    
    /**
     * Pre-Condition: The elements in the queue IS NOT EMPTY
     * Post-Condition: Returns the head of the queue but WITHOUT removing it
     *
     * This method throws an exception if the queue is empty when called
     */
    public E peek() {
        return elements.getFirst();
    }
    
    public int size() {
        return elements.size();
    }
    
    public boolean isEmpty() {
        return elements.isEmpty();
    }
    
    /**
     * Prints all elements inside the queue, starting from the head to tail
     * Note: For debugging purposes only. Do not call this method in your final
     * submission
     */
    public void print() {
        if (this.isEmpty()) {
            System.out.println("The queue is currently empty.");
        } else {
            System.out.println(elements.toString());
        }
    }
}

class Stack<E> {
    
    private LinkedList<E> elements;
    
    public Stack() {
        elements = new LinkedList<E>();
    }
    
    public void push(E element) {
        elements.addFirst(element);
    }
    
    /**
     * Pre-Condition: The elements in the stack IS NOT EMPTY
     * Post-Condition: Returns the top of the stack AND removes it from the stack
     *
     * This method throws an exception if the stack is empty when called
     */
    public E pop() {
        return elements.removeFirst();
    }
    
    /**
     * Pre-Condition: The elements in the stack IS NOT EMPTY
     * Post-Condition: Returns the top of the stack but WITHOUT removing it
     *
     * This method throws an exception if the stack is empty when called
     */
    public E peek() {
        return elements.getFirst();
    }
    
    public int size() {
        return elements.size();
    }
    
    public boolean isEmpty() {
        return elements.isEmpty();
    }
    
    /**
     * Prints all elements inside the stack, starting from the top to bottom
     * Note: For debugging purposes only. Do not call this method in your final
     * submission
     */
    public void print() {
        if (this.isEmpty()) {
            System.out.println("The stack is currently empty.");
        } else {
            System.out.println(elements.toString());
        }
    }
}
