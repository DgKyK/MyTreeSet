import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MyTreeSet<E> implements MySet<E> {
    private TreeNode<E> rootNode;
    private List<E> listOfElements;
    private int size = 0;

    public MyTreeSet() {
        this.listOfElements = new LinkedList<>();
        this.rootNode = new TreeNode<>(null);
    }

    @Override
    public boolean add(E element) {

        if (size == 0) {
            rootNode = new TreeNode<>(element);
            size++;
            return true;
        }

        TreeNode<E> newNode = new TreeNode<>(element);
        TreeNode<E> lastNode = findLastNode(rootNode, newNode);
        if (lastNode == null) {
            return false;
        }

        size++;
        newNode.parent = lastNode;

        if (newNode.compareTo(lastNode) > 0) {
            lastNode.right = newNode;
            return true;
        } else {
            lastNode.left = newNode;
            return true;
        }
    }

    private TreeNode<E> findLastNode(final TreeNode<E> previousNode, final TreeNode<E> newNode){
        int compare = newNode.compareTo(previousNode);
        TreeNode<E> lastNode = previousNode;

        if (compare > 0 && previousNode.getRight() != null) {
            lastNode = findLastNode(previousNode.getRight(), newNode);
            return lastNode;
        } else if (compare < 0 && previousNode.getLeft() != null) {
            lastNode = findLastNode(previousNode.getLeft(), newNode);
            return lastNode;
        } else if (compare == 0) {
            return null;
        }
        return lastNode;
    }

    @Override
    public List<E> getAll() {
        getSortedElements(rootNode, listOfElements);
        return listOfElements;
    }

    private void getSortedElements(TreeNode rootNode, List<E> treeNodesList){
        if(rootNode == null){
            return;
        }
        getSortedElements(rootNode.left, treeNodesList);
        treeNodesList.add((E)rootNode.element);
        getSortedElements(rootNode.right, treeNodesList);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public TreeNode<E> find(E element) {
        TreeNode<E> newNode = new TreeNode<>(element);
        return binarySearch(rootNode, newNode);
    }

    private TreeNode<E> binarySearch(TreeNode<E> previousNode, TreeNode<E> newNode) {
        int compare = newNode.compareTo(previousNode);

        if(compare > 0 && previousNode.right != null) {
            previousNode = binarySearch(previousNode.right, newNode);
        }
        if (compare < 0 && previousNode.left != null) {
            previousNode = binarySearch(previousNode.left, newNode);
        }

        if(compare == 0) {
            return previousNode;
        }

        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return new TreeIterator(rootNode);
    }

    private class TreeIterator implements Iterator<E> {
        private TreeNode<E> startNode;
        private List<E> treeSetElements;
        int counter = 0;

        public TreeIterator(TreeNode<E> startNode){
            treeSetElements = new LinkedList<>();
            this.startNode = startNode;
            getSortedElements(startNode, treeSetElements);
        }

        @Override
        public boolean hasNext() {
            return counter < treeSetElements.size();
        }

        @Override
        public E next() {
            return treeSetElements.get(counter++);
        }
    }
}
