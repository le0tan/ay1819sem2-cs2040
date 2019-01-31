public class LinkedList implements LinkedListInterface<E> {
  protected int numOfNodes = 0;
  protected LinkedNode<E> head = new LinkedNode<>();
  protected LinkedNode<E> tail = new LinkedNode<>();

  public int size() {
    return numOfNodes;
  }

  public E front() {
    return head.elem;
  }

  public E back() {
    return tail.elem;
  }

  public void pushBack(E elem) {
    LinkedNode<E> t = new LinkedNode(elem);
    t.prev = tail;
    tail.next = t;
  }

  public void addFront(E elem) {
    LinkedNode<E> t = new LinkedNode(elem);
    t.tail = head;
    head.prev = t;
  }
}
