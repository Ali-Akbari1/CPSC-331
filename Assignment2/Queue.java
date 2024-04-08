import java.lang.reflect.Array;
import java.util.Arrays;

public class Queue<T extends Comparable> implements QueueInterface<T>{
    private T[] queue;
    private int front, rear, size;

    // Constructor for the queue
    public Queue(Class<T> clazz, int maxSize){
        this.queue = (T[]) Array.newInstance(clazz, maxSize);
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    // Enqueue method for queues
    public void enqueue(T item){
        rear = (rear + 1) % queue.length;
        queue[rear] = item;
        size++;
    }
    // Dequeue method for queues
    public T dequeue(){
        T tmp = queue[front];
        queue[front] = null;
        front = (front + 1) %
        queue.length;
        size--;
        return tmp;
    }  
    
    // isEmpty method for queues
    public boolean isEmpty() {
        return (size == 0);
    }
    
    // isFull method for queues
    public boolean isFull() {
        return (size == queue.length);
    }

    // toString method 
    public String toString(){
        return Arrays.toString(queue);

    }

    // Getter method for size of the queue
    public int getSize(){
        return size;
    }

    // Getter method to get the front of the queue
    public int getFront(){
        return front;
    }


}