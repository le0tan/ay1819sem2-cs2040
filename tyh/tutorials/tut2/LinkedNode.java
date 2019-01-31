public class LinkedNode<E> {
  E elem;
  LinkedNode<E> prev;
  LinkedNode<E> next;
  LinkedNode(E elem) {
    this.elem = elem;
    this.prev = null;
    this.next = null;
  }
  LinkedNode() {
    this.elem = null;
    this.prev = null;
    this.next = null;
  }
  LinkedNode(E elem, LinkedNode<E> prev, LinkedNode<E> next) {
    this.elem = elem;
    this.prev = prev;
    this.next = next;
  }
  public void setNext(LinkedNode<E> next) { this.next = next; }
  public void setPrev(LinkedNode<E> prev) { this.prev = prev; }
}
