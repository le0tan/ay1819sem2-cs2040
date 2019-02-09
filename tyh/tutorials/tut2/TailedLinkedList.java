import java.util.*;

class TailedLinkedList <E>  extends ExtendedLinkedList <E> {

  protected ListNode <E> tail = null;

  public ListNode <E> getTail () {
	  return tail;
  }

  public void addFirst (E item) {
	super.addFirst ( item );
	if (num_nodes == 1) 
		tail = head;
  }

  public void addLast (E item) {
    if (head != null) {    
      tail.next = new ListNode <E> ( item );
      tail = tail.next;
      num_nodes++;
    } else {
      tail = new ListNode <E> ( item );
      head = tail;
      num_nodes++;
    }
  }
  
  public void addAfter (ListNode <E> current, E item) {
    super.addAfter (current, item);

    if (current != null) {
      if (current == tail)  // can "if (current.next.next == null)" work too ?
        tail = current.next;
    } else {
      if (tail == null) tail = head;
    }
  }

  /*
  public void addAfter (ListNode <E> current, E item) {
    ListNode <E> temp;
    if (current != null) {
      temp = new ListNode <E> (item, current.next);
      current.next = temp;
      num_nodes++;
      if (temp.next == null) tail = temp;
    } else {
      head = new ListNode <E> (item, head); 
      num_nodes++;
      if (tail == null) tail = head;
    }
  }
  
  */

  // we need to look through all deletion methods....
  public E removeAfter (ListNode <E> current) throws NoSuchElementException {
	  E temp = super.removeAfter(current);

	  if (current != null) {  
			if (current.next == null) tail = current;
	  } else  // removing head
	    	if (head == null) tail = null;	

	  return temp;
  }
  
  public E removeFirst ( ) throws NoSuchElementException {
	  return removeAfter( null );
  }

  // Okay to use remove from ExtendedLinkedList 
  // public E remove (E item) throws NoSuchElementException {
}
