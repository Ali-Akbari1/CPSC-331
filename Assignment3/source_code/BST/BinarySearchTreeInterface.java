public interface BinarySearchTreeInterface<T extends Comparable<T>> {
    boolean isEmpty();
    boolean isFull();
    int size();
    void clear();
    void add(T element);
    boolean contains(T element);
    void remove(T element);
    void reset(int order);
    T getNext(int order);
    void inorderTraversal();
    void postorderTraversal();
    void preorderTraversal();
}