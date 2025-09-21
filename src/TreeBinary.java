public class TreeBinary<E> {
    
    protected int size;
    protected TreeNode<E> root;

    public TreeBinary(TreeNode<E> root){
        this.root = root;
    }

    public TreeBinary(){}

    public int size(){return size;}

    public boolean isEmpty(){return size == 0;}

    public void visit(TreeNode<E> node){System.out.println(node.getElement());}

    public void inorder(TreeNode<E> node){
        if(node.hasLeft()) inorder(node.getLeft());
        visit(node);
        if(node.hasRight()) inorder(node.getRight());
    }

    public void inorder(){inorder(root);}

    public void preorder(TreeNode<E> node){
        visit(node);
        if(node.getLeft() != null) inorder(node.getLeft());
        if(node.getRight() != null) inorder(node.getRight());
    }

    public void pretorder(){preorder(root);}

        public void postorder(TreeNode<E> node){
        if(node.getLeft() != null) inorder(node.getLeft());
        if(node.getRight() != null) inorder(node.getRight());
        visit(node);
    }

    public void postorder(){postorder(root);}

    public int height(){
        return height(root);
    }

    public int height(TreeNode<E> node){
        if(node.isExternal()) return 0;

        int h1 = 0;
        if(node.getLeft() != null) h1 = height(node.getLeft());

        int h2 = 0;
        if(node.getRight() != null) h2 = height(node.getRight());

        return 1 + Math.max(h1, h2);
    }

    public class TreeNode<E>{

        private E element;
        private TreeNode<E> parent, left, right;

        public TreeNode(E element){
            this.element = element;
        }

        public TreeNode(E element, TreeNode<E> parent){
            this.element  = element;
            this.parent = parent;
        }

        public E getElement(){
            return element;
        }
        
        public void setElement(E element){
            this.element = element;
        }

        public TreeNode<E> getLeft(){
            return left;
        }
        
        public void setLeft(TreeNode<E> left){
            this.left = left;
        }

        public TreeNode<E> getRight(){
            return right;
        }
        
        public void setRight(TreeNode<E> right){
            this.right = right;
        }

        public TreeNode<E> getParent(){
            return parent;
        }
        
        public void setParent(TreeNode<E> parent){
            this.parent = parent;
        }

        public boolean isRoot(){return parent == null;}

        public boolean isExternal(){return ((left == null) && (right == null));}

        public boolean isInternal(){return ((left != null) || (right !=null));}

        public boolean hasRight(){return right != null;}

        public boolean hasLeft(){return left != null;}

        public int depth(){return depth(this);}

        public int depth(TreeNode<E> node){
            if(isRoot()) return 0;
            return 1 + depth(this.getParent());
        }
    }
}