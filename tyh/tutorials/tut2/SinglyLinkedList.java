public class SinglyLinkedList<E> implements BasicLinkedListInterface<E> {
	protected int numOfNodes = 0;
	protected SinglyLinkedNode<E> head = new SinglyLinkedNode<E>();

	
	public boolean isEmpty() {
		return numOfNodes == 0;
	}
  public int size() {
		return numOfNodes;
	}
  public E front() {
		return head.elem;
	}
  public void addFront(E elem) {
		SinglyLinkedNode<E> temp = new SinglyLinkedNode<E>(elem);
		temp.next = head;
		head = temp;
	}
	public void remove() {
		head = head.next;
	}
	public void logicalRemove(SinglyLinkedNode<E> target) {
		SinglyLinkedNode<E> temp = head;
		while(temp.next != target)
			temp = temp.next;
		temp.next = target.next;
	}
	public SinglyLinkedNode<Integer> merge(SinglyLinkedList<Integer> a, SinglyLinkedList<Integer> b) {
		if(a.isEmpty()) return b.head;
		else if(b.isEmpty()) return a.head;
		else {
			SinglyLinkedNode<Integer> head = a.head.elem < b.head.elem ? a.head : b.head;
			SinglyLinkedNode<Integer> cur = head;
			SinglyLinkedNode<Integer> ptr1 = head == a.head ? a.head.next : a.head;
			SinglyLinkedNode<Integer> ptr2 = head == b.head ? b.head.next : b.head;
			for(int i=1;i<a.size()+b.size();i++) {
				if(ptr2 == null || ptr1.elem < ptr2.elem) {
					cur.next = ptr1;
					ptr1 = ptr1.next;
					cur = cur.next;
				} else {
					cur.next = ptr2;
					ptr2 = ptr2.next;
					cur = cur.next;
				}
			}
			return head;
		}
	}
}
