import java.util.*;

class ExtendedLinkedList <E> extends BasicLinkedList <E> {

	// not in API Class LinkedList
	public ListNode <E> getFirstPtr ()
		{ return head; }

	// not in API Class LinkedList
	public void addAfter (ListNode <E> current, E item) {
		if (current != null) { 
			current.next = new ListNode <E> (item, current.next);
			num_nodes++;
		} else {
			head = new ListNode <E> (item, head);
			num_nodes++;
		}
	}

	// not in API Class LinkedList
	public E removeAfter (ListNode <E> current) throws NoSuchElementException {
		E temp;
		if (current != null) {
			if (current.next != null) {
				temp = current.next.element;
				current.next = current.next.next;
				num_nodes --;
				return temp;
			} else throw new NoSuchElementException("No next node to remove");
		} else { // if current is null, assume we want to remove head
			if (head != null) {
				temp = head.element;
				head = head.next; 
				num_nodes --;
				return temp;
			} else throw new NoSuchElementException("No next node to remove");
		}
	}

	public E remove (E item) throws NoSuchElementException {
		if (head == null) throw new NoSuchElementException ("can't find item to remove");

		// besides the following, can also use iterator in BasicLinkedList.java
		for (ListNode <E> n=head, prev=null; n != null; prev=n, n=n.next) 
			if (n.getElement().equals(item) ) 
				return removeAfter (prev);

		throw new NoSuchElementException ("can't find item to remove");
	}
}
