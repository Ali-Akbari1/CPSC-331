import java.util.Arrays;

public class MaxHeap {
    private int[] Heap; // Array to store heap elements
    private int size;
    private int maxsize;
    private int swaps;

    public MaxHeap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize + 1];
        Heap[0] = Integer.MAX_VALUE; // Sentinel value at the 0th index to make indexing easier
        this.swaps = 0;
    }

    // Returns the index of the parent for the node at index pos
    private int parent(int pos) {return pos / 2; }

    // Returns the index of the left child for the node at index pos
    private int leftChild(int pos) { return (2 * pos); }

    // Returns the index of the right child for the node at index pos
    private int rightChild(int pos) { return (2 * pos) + 1; }

    // Checks if the node at index pos is a leaf node
    private boolean isLeaf(int pos) { return pos > (size / 2) && pos <= size; }

    // Swaps two nodes of the heap at indexes fpos and spos
    private void swap(int fpos, int spos) {
        int tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
        swaps++;
    }

    private void maxHeapify(int pos) {
        if (!isLeaf(pos)) {
            // Check if right child exists before comparing
            boolean hasRightChild = rightChild(pos) <= size;
            if (Heap[pos] < Heap[leftChild(pos)] || (hasRightChild && Heap[pos] < Heap[rightChild(pos)])) {
                if (!hasRightChild || Heap[leftChild(pos)] > Heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    maxHeapify(leftChild(pos));
                } else {
                    swap(pos, rightChild(pos));
                    maxHeapify(rightChild(pos));
                }
            }
        }
    }

    // Inserts a new element into the heap
    public void insert(int element) {
        if (size >= maxsize) {
            return; // Heap is full
        }
        Heap[++size] = element;
        int current = size;

        // Move the new element up to maintain the heap property
        while (Heap[current] > Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    // Removes and returns the maximum element from the heap
    public int remove() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        int popped = Heap[1];
        Heap[1] = Heap[size--];
        maxHeapify(1);
        return popped;
    }

    public boolean isFull() { return size == maxsize; }

    public boolean isEmpty() { return size == 0; }

    public int size() { return size; }

    public int getMax() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return Heap[1];
    }

    // Heap sort Function
    public void heapSort(int[] array){
        int size = array.length;
        for (int i = 0; i < size; i++){
            insert(array[i]);
        }

        for (int i = size - 1; i >= 0; i--) {
            array[i] = remove();
        }

    }

    
    // Make a max heap from an array
    public int[] buildMaxHeapFromArray(int[] array) {
        this.size = array.length; // Update the size of the heap
        Heap = new int[this.size + 1]; // Allocate space for the heap
        System.arraycopy(array, 0, Heap, 1, array.length); // Copy the input array to the heap, starting from index 1

        for (int pos = size / 2; pos >= 1; pos--) {
            maxHeapify(pos);
        }

        int[] resultHeap = Arrays.copyOfRange(Heap, 1, size + 1);        return resultHeap;
    }
    
    // Getter method for the swaps
    public int getSwaps(){
        return swaps;
    }

    // Build a max heap using a one by one
    public int[] buildMaxHeapOneByOne(int[] array) {
        MaxHeap maxHeap = new MaxHeap(array.length);

        for (int i = 0; i < array.length; i++) {
            maxHeap.insert(array[i]);
        }

        swaps = maxHeap.getSwaps();
        int[] resultHeap = Arrays.copyOfRange(maxHeap.Heap, 1, maxHeap.size + 1);        return resultHeap;

    }
    

    }
