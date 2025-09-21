public class Queue_Doubly<E> implements Queue<E>{

    private Doubly_Linked_List<E> qudl = new Doubly_Linked_List<>();

    public int size(){
        return qudl.size();
    }

    public boolean isEmpty(){
        return qudl.isEmpty();
    }

    public void enque(E e){
        qudl.addLast(e);
    }

    public E deque(){
        return qudl.removeFirst();
    }

    public E front(){
        return qudl.first();
    }

}