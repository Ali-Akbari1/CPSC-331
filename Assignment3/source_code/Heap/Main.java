import java.util.*;


public class Main{


    // Generate Random Number Function
    public static int generateRandomNumber(int n){
        Random random = new Random();
    
        int r = random.nextInt(n+1);
    
        return r;
    
    }

    public static void main(String[] args){

        // Make a sorted array
        int[] sortedArray = new int[1000];
        for (int i  = 0; i < sortedArray.length; i++){
            sortedArray[i]= i;
        }

        // Make a random array
        int[] randomArray = new int[1000];

        for (int i = 0; i < randomArray.length; i++){
            randomArray[i] = generateRandomNumber(1000);
        }
        

        // Make the Heapify and the One by One Heaps
        MaxHeap maxHeapifySorted = new MaxHeap(sortedArray.length);
        MaxHeap maxOneByOneSorted = new MaxHeap(sortedArray.length);

        MaxHeap maxHeapifyUnSorted = new MaxHeap(randomArray.length);
        MaxHeap maxOneByOneUnSorted = new MaxHeap(randomArray.length);

        // Build the maxheap
        int[] heapArraySorted = maxHeapifySorted.buildMaxHeapFromArray(sortedArray);

        // Get the max heap swaps
        int swapsHeapifySorted = maxHeapifySorted.getSwaps();

        System.out.println("Creation Sorted (Heapify): " + swapsHeapifySorted);

        // Build the maxheap
        int[] heapArrayUnsorted = maxHeapifyUnSorted.buildMaxHeapFromArray(randomArray);

        // Get the max heap swaps
        int swapsHeapifyUnsorted = maxHeapifyUnSorted.getSwaps();

        System.out.println("Creation Unsorted (Heapify): " + swapsHeapifyUnsorted);

        // Build the one by one max heap
        int[] heapArrayOneByOneSorted = maxOneByOneSorted.buildMaxHeapOneByOne(sortedArray);

        // Get the max heap swaps
        int swapsOneByOne = maxOneByOneSorted.getSwaps();

        System.out.println("Creation Sorted (One by One): " + swapsOneByOne);

        // Build the one by one max heap
        int[] heapArrayOneByOneUnSorted = maxOneByOneUnSorted.buildMaxHeapOneByOne(randomArray);

        // Get the max heap swaps
        int swapsOneByOneUnsorted = maxOneByOneUnSorted.getSwaps();

        System.out.println("Creation Unsorted (One by One): " + swapsOneByOneUnsorted);


        // Sort the heaps 
        maxHeapifySorted.heapSort(heapArraySorted);
        maxOneByOneSorted.heapSort(heapArrayOneByOneSorted);

        maxHeapifyUnSorted.heapSort(heapArrayUnsorted);
        maxOneByOneUnSorted.heapSort(heapArrayOneByOneUnSorted);


        // Print out the number of swaps
        System.out.println("Total (Heapify Sorted): " + maxHeapifySorted.getSwaps());
        System.out.println("Total (Heapify Unsorted): " + maxHeapifyUnSorted.getSwaps());

        System.out.println("Total (One by One Sorted): " + maxOneByOneSorted.getSwaps());
        System.out.println("Total (One by One Unsorted): " + maxOneByOneUnSorted.getSwaps());







    
    
    
    
}
}