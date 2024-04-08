
import java.lang.reflect.Array;
import java.util.Arrays;



public class Stack<T> implements StackInterface<T>{

    private T[] stack;
    private int topIndex;

    // Constructor 
    public Stack(Class<T> clazz, int maxSize){

        this.stack = (T[]) Array.newInstance(clazz, maxSize);
        
        this.topIndex = -1; 

    }

    // isEmpty function for the stack
    public boolean isEmpty(){
        return (topIndex == -1);

    }

    // isFull function for stack
    public boolean isFull(){
        return (topIndex == (stack.length - 1));
    }

    // Push function for stack
    public void push(T item){
        if (!isFull()){
            topIndex++;
            stack[topIndex] = item;
        }
        else{
            throw new OverflowException("Cannot push onto a full stack.");
    }}

    // Pop function for stack
    public T pop(){
        if (!isEmpty()){
            T tmp = stack[topIndex];
            stack[topIndex] = null;
            topIndex--;
            return tmp;
        }
        else{
            throw new UnderflowException("Cannot pop from an empty stack. ");
        }
    }

    // Peek function for Stack
    public T peek(){
        if (!isEmpty()){
            return stack[topIndex];
        }
        else{
            throw new UnderflowException("Cannot peek to an empty stack.");
        }
    }


    // Getter method for length of stack
    public int getSize(){
        return stack.length;
    }


    //Override toString to print out the stacks in a certain way
    public String toString(){

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < stack.length; i++){
            sb.append(stack[i]);
            if(i != stack.length - 1){
                sb.append(" - ");
            }
        }
        
        return "[" + sb.toString() + "]";
    }

    // toArray function to turn a stack into an array
    public T[] toArray() {
        T[] array = (T[]) Array.newInstance(stack.getClass().getComponentType(), topIndex + 1);
        for (int i = 0; i <= topIndex; i++) {
            array[i] = stack[i];
        }
        return array;
    }


    // Get function to return the value at the index 
    public T get(int index) {
        return (T) stack[index];
    }



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