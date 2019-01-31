public class LinkedList<E> implements LinkedListInterface<E> {
  protected int numOfNodes = 0;
  protected LinkedNode<E> head = new LinkedNode<E>();
  protected LinkedNode<E> tail = new LinkedNode<E>();

	public boolean isEmpty() {
		return numOfNodes == 0;
	}

  public int size() {
    return numOfNodes;
  }

  public E front(){
    return head.elem;
  }

  public E back() {
    return tail.elem;
  }

  public void pushBack(E elem) {
    LinkedNode<E> t = new LinkedNode<E>(elem);
    t.prev = tail;
    tail.next = t;
  }

  public void addFront(E elem) {
    LinkedNode<E> t = new LinkedNode<E>(elem);
    t.next = head;
    head.prev = t;
  }

	public void remove() {
		if(!isEmpty()) {
			head = head.next;
			head.prev = null;
		}
	}

	public LinkedNode<E> getPointer(int idx) {
		if(idx<numOfNodes) {
			LinkedNode<E> t = head;
			for(int i=0;i<idx;i++) {
				t = t.next;
			}
			return t;
		} else {
			// throw an exception, but later
			return null;
		}
	}

	public void swapToFront(int idx) {
		LinkedNode<E> ptr = getPointer(idx);
		// Using Pointer
		LinkedNode<E> t = head.next;
		head.prev = ptr.prev;
		head.next = ptr.next;
		ptr.next = t;
		ptr.prev = null;
		// Create two nodes
//		LinkedNode<E> newHead = new LinkedNode<E>(ptr.elem, null, head.next);
//		LinkedNode<E> newCurrent = new LinkedNode<E>(head.elem, ptr.prev, ptr.next);
//		head.next.prev = newHead;
//		head = newHead;
//		ptr.prev.next = newCurrent;
//		ptr.next.prev = newCurrent;
		// Swap content
//		E temp = head.elem;
//		head.elem = ptr.elem;
//		ptr.elem = temp;
	}
}
