public class TreeNode<E> implements Comparable<E> {
    protected TreeNode<E> parent;
    protected TreeNode<E> left;
    protected TreeNode<E> right;
    protected E element;

    public TreeNode(E element) {
        this.element = element;
    }

    /*Getters*/

    public TreeNode<E> getParent() {
        return parent;
    }

    public E getElement() {
        return element;
    }

    public TreeNode<E> getLeft() {
        return left;
    }

    public TreeNode<E> getRight() {
        return right;
    }

    @Override
    public int compareTo(Object o) {
        TreeNode<E> temp = (TreeNode<E>) o;
        return this.hashCode() - temp.hashCode();
    }

    @Override
    public int hashCode(){
        int result = 31;
        int prime = 17;
        result = result * prime + element.hashCode();
        return result;
    }
}
