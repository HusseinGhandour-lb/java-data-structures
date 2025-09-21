public class Stack_Array<E> implements Stack<E> {
    
    private E[] data;
    private int topidx = -1;

    public Stack_Array(){
        this(10);
    }

    @SuppressWarnings("unchecked")
    public Stack_Array(int initialCapacity){
        data = (E[]) new Object[initialCapacity];
    }

    public int size(){
        return topidx+1;
    }

    public boolean isEmpty(){
        return topidx==-1;
    }

    public void push(E e){
        if(topidx == data.length - 1)
            System.out.println("Stack is full");
        else{
            data[topidx] = e;
            topidx++;
        }
    }

    public E top(){
        if(isEmpty())
            return null;
        return data[topidx];
    }

    public E pop(){
        if(isEmpty())
            return null;
        E temp = data[topidx];
        data[topidx] = null;
        topidx--;
        return temp;
    }
    
}