



public interface HashTableInterface<T extends Hashable> {

    public void clear();
    public void add (T item);
    public void remove(T item);
    public boolean contains(T item);

    
} 