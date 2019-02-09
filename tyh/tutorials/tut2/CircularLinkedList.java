import java.util.*;

class CircularLinkedList <E> extends TailedLinkedList <E> {

  public void addFirst (E item) {
	  super.addFirst ( item );
	  tail.next = head;
  }

  public void addLast (E item ) {
	  super.addLast ( item );
	  tail.next = head;
  }

  public E removeAfter (ListNode <E> current) throws NoSuchElementException {
	  E temp = super.removeAfter (current);
	  // up till here no problem as long as it is not the following cases:
	  // case 1. removing both head and tail (but not done correctly by parent)
	  if ( num_nodes == 0 ) {  // can't test for head==null here
		  head = tail = null;
		  return temp;
	  }
	  // tail and head are not null now
	  // case 2a. removing head (because current==null)
	  if (current == null) {
		  System.out.println("case 2a");
		  tail.next = head;
		  return temp;
	  }
	  // case 2b. removing head (because current==tail)
	  if ( tail.next != head) {
		  System.out.println("case 2b");
		  head = tail.next;
		  return temp;
	  }
	  // case 3. removing tail (and not head, because current.next==tail)
	  if (current.next == head) {
		  tail = current;
		  return temp;
	  }
	  return temp;
  }

  public E removeFirst ( ) throws NoSuchElementException {
	  return removeAfter ( null );
  }

 // the one in ExtendedLinkedList can't be used due to infinite loop
  public E remove (E item) throws NoSuchElementException {
	  if (head == null) throw new NoSuchElementException("can't find item");

	  ListNode <E> n = head;
	  ListNode <E> prev = null;
	  for (int i=0; i < num_nodes; i++, prev=n, n=n.next)  
			 if (n.element.equals(item)) 
				 return removeAfter (prev);

	  throw new NoSuchElementException ("can't find item to remove");
  }

  // the one in BasicLinkedList can't be used as it would go into infinite loop
  public boolean contains (E item) throws NoSuchElementException {
	  if ( head == null ) return false;
	  ListNode <E> n = head;
	  for (int i=0; i < num_nodes; i++) { 
		  if (n.element.equals(item)) { return true; }
		  n = n.next;
	  }
	  return false;
  }
}
