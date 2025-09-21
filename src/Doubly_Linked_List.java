public class Doubly_Linked_List<E> {
    
    private Node<E> header, trailer;
    private int size;

    public Doubly_Linked_List(){
        header = new Node<E>(null, null, null);
        trailer = new Node<E>(null, header, null);
        header.setNext(trailer);
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public E first(){
        if(size == 0){
            return null;
        }
        return header.getNext().getElement();
    }
    
    public E last(){
        if(isEmpty()){
            return null;
        }
        return trailer.getPrev().getElement();
    }

    public void addBetween(E e, Node<E> before, Node<E> after){
        Node<E> node = new Node<>(e, before, after);
        before.setNext(node);
        after.setPrev(node);
        size++;
    }

    public void addFirst(E e){
        addBetween(e, header, header.getNext());
    }

    public void addLast(E e){
        addBetween(e, trailer.getPrev(), trailer);
    }

    public E remove(Node<E> r){
        Node<E> next = r.getNext();
        Node<E> prev = r.getPrev();
        prev.setNext(next);
        next.setPrev(prev);
        size--;
        return r.getElement();
    }

    public E removeFirst(){
        if(isEmpty()){
            return null;
        }
        return remove(header.getNext());
    }

    public E removeLast(){
        if(isEmpty()){
            return null;
        }
        return remove(trailer.getPrev());
    }

    public Node<E> getByIndex(int idx){
        if ((size==0) || (idx>size) || (idx<0)) return null;
        Node<E> n = header;
        for(int i=0; i<idx; i++){
            n = n.getNext();
        }
        return n;
    }

    public E get(int idx){
        Node<E> n = getByIndex(idx);
        if (n == null) return null;
        return n.getElement();
    }

    public void set(int idx, E e){
        Node<E> n = getByIndex(idx);
        if (n == null)return;
        n.setElement(e);
    }

    public E remove(int idx){
        Node<E> n = getByIndex(idx);
        if (n == null) return null;
        return remove(n);
    }

    public String toString(){
       if (size == 0) return "[]";

    StringBuilder sb = new StringBuilder();
    sb.append("[");
    Node<E> n = header.getNext();
    while (n != trailer) {
        sb.append(n.getElement());
        n = n.getNext();
        if (n != trailer) {
            sb.append(", ");
        }
    }
    sb.append("]");
    return sb.toString();
    }

    @SuppressWarnings("hiding")
    private class Node<E> {
        private E element;
        private Node<E> prev, next;

        public Node(E element, Node<E> prev, Node<E> next){
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

        public E getElement(){
            return element;
        }

        public void setElement(E element){
            this.element = element;
        }

        public Node<E> getNext(){
            return next;
        }

        public void setNext(Node<E> next){
            this.next = next;
        }

        public void setPrev(Node<E> prev){
            this.prev = prev;
        }

        public Node<E> getPrev(){
            return prev;
        }

        @Override
        public String toString(){
            return element.toString();
        }
    }
}