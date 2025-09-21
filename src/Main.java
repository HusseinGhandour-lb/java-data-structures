public class Main {
    public static void main(String[] args) {

        //Binary Search Tree
        BST<Integer> t = new BST<>();
        t.inserNR(6);
        t.inserNR(2);
        t.inserNR(9);
        t.inserNR(1);
        t.inserNR(4);
        t.inserNR(8);
        t.inserNR(10);

        t.inorder();
        
        //Queue using array
        Queue_Array<Integer> qa = new Queue_Array<>();
        qa.enque(1);
        qa.enque(2);
        qa.enque(3);
        qa.enque(4);
        qa.enque(5);
        qa.enque(6);
        qa.enque(7);
        qa.enque(8);
        qa.enque(9);
        qa.enque(10);
        qa.deque();
        qa.deque();
        qa.enque(11);
        System.out.println(qa);

        //Doubly Linked List
        Doubly_Linked_List<Integer> dl = new Doubly_Linked_List<>();
        dl.addLast(2);
        dl.addLast(1);
        dl.addLast(4);
        int val = dl.get(1);
        System.out.println(dl);
        dl.set(2, 3);
        System.out.println(val);
        System.out.println(dl);
        dl.removeFirst();
        System.out.println(dl);

        //Array List
        Array_List<Integer> al = new Array_List<>();
        System.out.println(al.size());
        al.add(1);
        al.add(2);
        al.add(3);
        System.out.println(al.size());
        if(al.contains(2)){
            System.out.println("2 exists");
        }
        try {
            al.removeLast();
        } 
        catch (Exception e) {
        }
        if(al.contains(3)){
            System.out.println("2 exists");
        }
        System.out.println(al.size());
         
        //Singley Linked List
        Singly_linked_List<Integer> s1 = new Singly_linked_List<>();
        s1.addLast(-14);
        s1.addLast(-9);
        s1.addLast(-7);
        s1.addLast(-5);
        s1.addLast(-2);
        s1.addLast(-1);
        s1.addLast(2);
        s1.addLast(3);
        s1.addLast(5);
        s1.addLast(8);
        
        Singly_linked_List<Integer> s2 = new Singly_linked_List<>();
        s2.addLast(11);
        s2.addLast(14);
        s2.addLast(15);
        s2.addLast(19);
        s2.addLast(20);
        s2.addLast(23);
        s2.addLast(26);
        s2.addLast(32);
        s2.addLast(34);
        s2.addLast(40);
        
        System.out.println(s1 + "\n" + s2);
        s1.merge(s2);
        s1.clear();
        System.out.println(s1.size());   
    }
}