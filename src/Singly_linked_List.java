public class Singly_linked_List<E> {

    private Node<E> head, tail;
    private int size;

    public Singly_linked_List(){
        head = new Node<E>(null, null);
        tail = head;
    }

    public void reverse(){
        if(head == null && head.getNext() == null){return;}

        Node<E> current = head;
        Node<E> next = null;
        Node<E> prev = null;

        while (current != null) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        tail = head;
        head = prev;
    }

    public void merge(Singly_linked_List<E> list) {
        Node<E> baseTail = tail;         
        while (!list.isEmpty()) {
            E temp = list.removeFirst();
            Node<E> newNode = new Node<E>(temp, null);
            baseTail.setNext(newNode);
            baseTail = newNode; 
            size++;
        }
        tail = baseTail;
    }

    public void clear(){
        Node<E> node = head;
        Node<E> aux = head;

        while(node.getNext() != null){
            aux.setNext(node.getNext());
            node.setNext(null);
            node = aux;
        }
        size = 0;
        head = tail = null;
    }

    public void removeEvery1(){
        Node<E> current =head;
       
        int count = 0;
      Node<E>temp=null;
        while(current!=null ){
               
                
            if(count%5==0){
                if(temp==null){
                head = current.getNext();
                
                current = head;
                }
            else{
            temp.setNext(current.getNext());
           
            current= temp.getNext();
            }     
        }else{
                temp = current;
                current = current.getNext();
            }
            count++;
        }
}

    public void removeEvery(){
        if(head == null){return;}

        Node<E> node = head;
        Node<E> temp = null;
        int counter = 0;
        
        if (counter % 5 == 0) {
            head = head.getNext();
            counter++;
        }

        while(node.getNext() != null){
            counter++;
            if(counter % 5 == 0){
                temp.setNext(node.getNext());
            }
            else{
                temp = node;
            }
            node = node.getNext();
        }
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public E first(){
        if(isEmpty())
            return null;
        return head.getElement();
    }

    public void addFirst(E e){
        Node<E> n  = new Node<E>(e, null);
        if(isEmpty())
            head = tail = n;
        else{
            n.setNext(head);
            head = n;
        }
        size++;
    }

    public void addLast(E e){
        Node<E> n  = new Node<E>(e, null);
        if(isEmpty())
            head = tail = n;
        else{
            tail.setNext(n);
            tail = n;
        }
        size++;
    }

    public E removeFirst(){
        if(isEmpty())
            return null;
        else if (size == 1) {
            E temp = head.getElement();
            head = tail = null;
            size--;
            return temp;
        }
        
        Node<E> n = head.getNext(); 
        head.setNext(null);
        E temp = head.getElement();
        head = n;
        size--;
        return temp;
    }
    

    public E removeLast(){
        if(isEmpty())
            return null;
        else if (size == 1) 
            head = tail = null;
        E temp = tail.getElement();
        Node<E>  n = head;
        for(int i=0; i<size-2; i++){
            n = n.getNext();
        }
        n.setNext(null);
        size--;
        return temp;
    }

    public void set(int idx, E e) throws Exception{
        if(idx>size || idx<0 || size==0)
            throw new IndexOutOfBoundsException();
        Node<E> n = head;
        for(int i=0; i<idx; i++){
            n = n.getNext();
        }
        n.setElement(e);
    }

    public E get(int idx) throws Exception{
        if(idx>size || idx<0 || size==0)
            throw new IndexOutOfBoundsException();
        Node<E> n = head;
        for(int i=0; i<idx; i++){
            n = n.getNext();
        }
        return n.getElement();
    }

    public E remove(int idx) throws Exception{
        if(idx>size || idx<0 || size==0)
            throw new IndexOutOfBoundsException();
        if (idx==0) {removeFirst();}
        if (idx==size-1){removeLast();}
        Node<E> p = head;
        for(int i=0; i<idx-1; i++){
            p = p.getNext();
        }
        Node<E> n = p.getNext();
        E temp = n.getElement();
        p.setNext(n.getNext());
        n.setNext(null);
        size--;
        return temp;
    } 

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static Singly_linked_List intersection(Singly_linked_List list1, Singly_linked_List list2) throws Exception{
        Singly_linked_List res_list = new Singly_linked_List<>();
        for(int i=0; i<list1.size(); i++){
            for(int j=0; j<list2.size(); j++){
                if(list1.get(i).equals(list2.get(j))){
                    res_list.addLast(list2.get(j));
                }
            }
        }
        return res_list;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void split(Singly_linked_List main_list, Singly_linked_List list1, Singly_linked_List list2, int x) throws Exception{
        for(int i=0; i<x; i++){
            list1.addLast(main_list.get(i));
        }
        for(int i=x; i<main_list.size(); i++){
            list2.addLast(main_list.get(i));
        }
        System.out.print(list1);
        System.out.print(list2);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        if(isEmpty()){
            return "[]";
        }
        sb.append("[");
        Node<E> n = head;
        while (n != null) {
            sb.append(n.getElement());
            
            n = n.getNext();
            if(n != null){
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @SuppressWarnings("hiding")
    private class Node<E>{
        E element;
        Node<E> next;
        
        public Node(E element, Node<E> next){
            this.element = element;
            this.next = next;
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

        public String toString(){
            return element.toString();
        }
    }
}