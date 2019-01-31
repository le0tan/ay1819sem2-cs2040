public class LinkedNode<E> {
  E elem;
  LinkedNode<E> prev;
  LinkedNode<E> next;
  LinkedNode(E elem) {
    this.elem = elem;
    this.prev = null;
    this.next = null;
  }
  public void setNext(E next) { this.next = next; }
  public void setPrev(E prev) { this.prev = prev; }
}
