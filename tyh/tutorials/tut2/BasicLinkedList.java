import java.util.*;

class BasicLinkedList <E> implements LinkedListInterface <E> {

	protected ListNode <E> head = null;
	protected int num_nodes = 0;

	public boolean isEmpty() 
		{ return (num_nodes == 0); }

	public int size( ) 
		{ return num_nodes; }

	public E getFirst ( ) throws NoSuchElementException {
		if (head == null) 
			throw new NoSuchElementException("can't get from an empty list");
		else return head.element;
	}

	public boolean contains (E item) {
		for (ListNode <E> n = head; n!= null; n=n.next)
			if (n.getElement().equals(item)) return true;

		return false;
	}

	public void addFirst (E item) {
		head = new ListNode <E> (item, head);
		num_nodes ++;
	}

	public E removeFirst ( ) throws NoSuchElementException {
	    ListNode <E> ln;
		if (head == null) 
			throw new NoSuchElementException ("can't remove from an empty list");
		else { 
			ln = head;
			head = head.next;
			num_nodes --;
	    	return ln.element;
		}
	}

	public void print2 ( ) throws NoSuchElementException {
		if (head == null)
			throw new NoSuchElementException ("Nothing to print...");

		ListNode <E> ln = head;
		System.out.print ("List is: " + ln.element);
		for (int i=1; i < num_nodes; i++) {
			ln = ln.next;
			System.out.print (", " + ln.element );
		}
		System.out.println(".");
	}

	public void print () throws NoSuchElementException {
		if (head == null)
			throw new NoSuchElementException ("Nothing to print...");

		Iterator <E> itr = iterator();
		System.out.print ("List is: " + itr.next() );
		while (itr.hasNext()) 
			System.out.print ( ", " + itr.next() );
		System.out.println(".");
	}

	public Iterator<E> iterator() { return new LinkedListIterator(); }
	private class LinkedListIterator implements Iterator<E> {
		private ListNode<E> current = head;

		public boolean hasNext(){ return current != null;}
		public void remove() 	{ throw new UnsupportedOperationException(); }
		public E next() {
			if ( !hasNext()) throw new NoSuchElementException();
			E element = current.element;
			current = current.next;
			return element;
		}
	}
}
