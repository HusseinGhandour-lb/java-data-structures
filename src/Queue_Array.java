public class Queue_Array<E> implements Queue<E>{
    
    private E data[];
    private int f;
    private int sz;

    public Queue_Array(){
        this(10);
    }

    public Queue_Array(int capacity){
        data = (E[]) new Object[capacity];
    }

    public int size(){
        return sz;
    }

    public boolean isEmpty(){
        return sz == 0;
    }

    public void enque(E e){
        if (sz == data.length)
            System.out.println("The array is full");
        int r = (f+sz) % data.length;
        data[r] = e;
        sz++;
    }

    public E deque(){
        if (isEmpty())
            throw new IllegalAccessError("Queue is Empty");
        E value = data[f];
        data[f] = null;
        f = (f + 1) % data.length;
        sz--;
        return value;
    }

    public E front(){
        if (isEmpty()) 
            return null;
        return data[f];
    }

    @Override
public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    for (int i = 0; i < sz; i++) {
        int index = (f + i) % data.length;
        sb.append(data[index]);
        if (i < sz - 1) {
            sb.append(", ");
        }
    }
    sb.append("]");
    return sb.toString();
}

}