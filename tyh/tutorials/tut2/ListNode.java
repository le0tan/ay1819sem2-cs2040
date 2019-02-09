import java.util.*;

class ListNode <E> {
	protected E element;
	protected ListNode <E> next;

	/* constructors */
	public ListNode (E item) { element = item; next = null; }
	public ListNode (E item, ListNode <E> n) { element = item; next=n;}

	/* get the next ListNode */
	public ListNode <E> getNext ( ) {
		return this.next;
	}

	/* get the element of the ListNode */
	public E getElement ( ) {
		return this.element;
	}
}
