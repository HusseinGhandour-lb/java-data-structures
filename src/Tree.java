import java.util.ArrayList;
public class Tree<E> {

    private TreeNode<E> root;
    private int sz;

    public int size(){
        return sz;
    }

    public boolean isEmpty(){
        return sz == 0;
    }

    private class TreeNode<E>{
        
        private E element;
        private TreeNode<E> parent;
        private ArrayList<TreeNode<E>> children = new ArrayList<>();

        public E getElement(){
            return element;
        }

        public void setElement(E element){
            this.element = element;
        }

        public TreeNode<E> getParent(){
            return parent;
        }

        public void setparent(TreeNode<E> parent){
            this.parent = parent;
        }

        public ArrayList<TreeNode<E>> getChildren(){
            return children;
        }

        public void setChildren(ArrayList<TreeNode<E>> children){
            this.children = children;
        }

        public boolean isRoot(){
            return parent == null;
        }

        public boolean isExternal(){
            return children.isEmpty();
        }

        public boolean isInternal(){
            return !isExternal();
        }
    }

}
