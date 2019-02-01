public class SinglyLinkedNode<E> {
	public E elem;
	public SinglyLinkedNode<E> next;
	SinglyLinkedNode() {
		elem = null;
		next = null;
	}
	SinglyLinkedNode(E elem) {
		this.elem = elem;
		next = null;
	}
	SinglyLinkedNode(E elem, SinglyLinkedNode<E> next) {
		this.elem = elem;
		this.next = next;
	}
}
