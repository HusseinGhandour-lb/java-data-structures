public interface Stack<E> {

    public E top();
    public void push(E e);
    public int size();
    public E pop();
    public boolean isEmpty();
    
}