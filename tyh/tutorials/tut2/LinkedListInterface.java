public interface LinkedListInterface<E> {
  protected int numOfNodes = 0;
  protected LinkedNode<E> head;
  protected LinkedNode<E> tail;

  public int size();

  public E front();

  public E back();

  public void pushBack(E elem);

  public void addFront(E elem);
}
