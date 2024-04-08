

// Queue Interface
public interface QueueInterface<T>{

    public void enqueue(T item);
    public T dequeue();

    public boolean isEmpty();
    public boolean isFull();


}