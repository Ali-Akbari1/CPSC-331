


// Stack Interface
public interface StackInterface<T>{

    public void push(T item) throws OverflowException;
    public T pop() throws UnderflowException;
    public T peek() throws UnderflowException;

    public boolean isEmpty();
    public boolean isFull();



    // Exceptions
    public static class UnderflowException extends RuntimeException {
        public UnderflowException() {
        }
         
        public UnderflowException(String message) {
            super(message);
        }
    }

    public static class OverflowException extends RuntimeException {
        public OverflowException() {
        }
         
        public OverflowException(String message) {
            super(message);
        }
    }

}