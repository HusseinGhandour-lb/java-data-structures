public class BST<E extends Comparable<E>> extends TreeBinary<E> {

    public BST(TreeNode<E> root){
        super(root);
    }

    public BST(){}

    public void insert(E item){
        if(root == null){
            root = new TreeNode<E>(item);
            size++;
        }
        else{insert(item, root);}
    }

    public void insert(E item, TreeNode<E> subroot){
        if(item.compareTo(subroot.getElement()) < 0){
            if(subroot.hasLeft()){
                insert(item, subroot.getLeft());
            }
            else{
                TreeNode<E> node = new TreeNode(item, subroot);
                subroot.setLeft(node);
            }
        }
        else{
            if(subroot.hasRight()){
                insert(item, subroot.getRight());
            }
            else{
                TreeNode<E> node = new TreeNode(item, subroot);
                subroot.setRight(node);
            }
        }
        size++;
    }

    public void inserNR(E item){
        if(root == null){root = new TreeNode<E>(item);}

        else{
            TreeNode<E> node = root;
            while(true){
                if(item.compareTo(node.getElement()) < 0){
                    if(node.hasLeft()){
                        node = node.getLeft();
                    }
                    else{
                        TreeNode<E> n = new TreeNode<E>(item, node);
                        node.setLeft(n);
                        break;
                    }
                }
                else {
                    if(node.hasRight()){
                        node = node.getRight();
                    }
                    else{
                        TreeNode<E> n = new TreeNode<E>(item, node);
                        node.setRight(n);
                        break;
                    }                
                }        
            }
        }
        size++;
    }

    public boolean contains(E item){
        if(isEmpty()) return false;

        TreeNode<E> node = root;
        if(item.compareTo(node.getElement()) == 0){
            return true;
        }

        else if(item.compareTo(node.getElement()) < 0){
            if(node.hasLeft()){node = node.getLeft();}
            else{return false;}
        }

        else{
            if(node.hasRight()){node = node.getRight();}
            else{return false;}
        }
        return false;
    }

    public E remove(TreeNode<E> node){
        TreeNode<E> leftn = node.getLeft();
        TreeNode<E> rightn = node.getRight();
        E element = node.getElement();

        if((leftn == null) && (rightn == null)){
            if(node == root){
                root = null;
            }
            else{
                TreeNode<E> parentNode = node.getParent();
                if(parentNode.getLeft() == node){parentNode.setLeft(null);}
                else{parentNode.setRight(null);}
            }
        }

        if((leftn != null) ^ (rightn != null)){
            TreeNode<E> n;
            if(leftn != null){n =leftn;}
            else if(rightn != null){n = rightn;}
            else{n = null;}
            if(node == root){
                root = n;
                n.setParent(null);
            }
            else{
                TreeNode<E> parentNode = node.getParent();
                if(parentNode.getLeft() == node){parentNode.setLeft(n);}
                else{parentNode.setRight(n);}
                n.setParent(parentNode);
            }
        }

        if((leftn != null) && (rightn != null)) {
            TreeNode<E> smallestLarge = rightn;
            while (smallestLarge.getLeft() != null) {
                smallestLarge = smallestLarge.getLeft();
            }

            TreeNode<E> smallestLargeParent = smallestLarge.getParent();
            TreeNode<E> parentNode = node.getParent();

            if (node == root) {
                smallestLarge.setLeft(root.getLeft());
                if (root.getLeft() != null) {
                    root.getLeft().setParent(smallestLarge);
                }

                if (smallestLarge.getRight() != null) {
                    smallestLarge.getRight().setParent(smallestLargeParent);
                }

                if (smallestLargeParent.getLeft() == smallestLarge) {
                    smallestLargeParent.setLeft(smallestLarge.getRight());
                } else {
                    smallestLargeParent.setRight(smallestLarge.getRight());
                }

                smallestLarge.setRight(root.getRight());
                if (root.getRight() != null) {
                    root.getRight().setParent(smallestLarge);
                }

                root = smallestLarge;
                smallestLarge.setParent(null);

            } else {
                smallestLarge.setLeft(node.getLeft());
                if (node.getLeft() != null) {
                    node.getLeft().setParent(smallestLarge);
                }

                if (smallestLarge.getRight() != null) {
                    smallestLarge.getRight().setParent(smallestLargeParent);
                }

                if (smallestLargeParent.getLeft() == smallestLarge) {
                    smallestLargeParent.setLeft(smallestLarge.getRight());
                } else {
                    smallestLargeParent.setRight(smallestLarge.getRight());
                }

                smallestLarge.setRight(node.getRight());
                if (node.getRight() != null) {
                    node.getRight().setParent(smallestLarge);
                }

                if (parentNode.getLeft() == node) {
                    parentNode.setLeft(smallestLarge);
                } else {
                    parentNode.setRight(smallestLarge);
                }

                smallestLarge.setParent(parentNode);
            }
        }
        size--;
        return element;
    }
}