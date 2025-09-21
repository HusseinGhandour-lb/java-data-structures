public class Array_List<E> {
    private E[] data;
    private int size;

    @SuppressWarnings("unchecked")
    public Array_List(int initialCapacity){
        data = (E[])new Object[initialCapacity];
    }

    public Array_List(){
        this(10);
    }

    public boolean add(E e){
        boolean result = false;
        if(size == data.length){
            @SuppressWarnings("unchecked")
            E[] newdata = (E[]) new Object[data.length + 5];
            for(int i=0;i<data.length;i++){
                newdata[i] = data[i];
            }
            data = newdata;
            result = true;
        }
        data[size] = e;
        size++;
        return result;
    }
    
    public int size(){
        return size;
    }

    public boolean contains(E o){
        for(int i=0; i<size; i++){
            if(o.equals(data[i]))
                return true;
        }
        return false;
    }

    public E removeLast() throws Exception{
        if(size == 0)
            throw new ArrayIndexOutOfBoundsException();
        else{
            E temp = data[size -1];
            data[size-1]=null;
            size--;
            return temp;
        }
    }

    public E get(int index) throws Exception{
        if(index<0 || index>size || size==0){
            throw new ArrayIndexOutOfBoundsException();
        }
        return data[index];
    }
}