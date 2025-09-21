public interface Queue<E> {

    public int size();
    public boolean isEmpty();
    public void enque(E e);
    public E deque();
    public E front();

}