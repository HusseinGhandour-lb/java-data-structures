public class Stack_Singly_List<E> implements Stack<E>{
    
    private Singly_linked_List<E> stsl = new Singly_linked_List<>();

    public int size(){
        return stsl.size();
    }

    public void push(E e){
        stsl.addFirst(e);
    }

    public E pop(){
        return stsl.first();
    }

    public E top(){
        return stsl.removeFirst();
    }

    public boolean isEmpty(){
        return stsl.isEmpty();
    }
    
    public void parenthesis(String var){
        Singly_linked_List<E> s = new Singly_linked_List<>();
        char c;
        
    }
}