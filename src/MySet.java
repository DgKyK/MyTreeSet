import java.util.List;

public interface MySet<E> extends Iterable<E>{
    boolean add(E element);
    List<E> getAll();
    int size();
    TreeNode<E> find(E element);
}
