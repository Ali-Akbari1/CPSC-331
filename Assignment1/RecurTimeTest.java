


public class RecurTimeTest {

    public static int recursiveBinarySearch(int[] arr, int low, int high, int target) {
        /*
         * int[] arr: Sorted array as input
         * int low: lower bound array index
         * int high: upper bound array index
         * target: Value that is being searched for in the array
         *
         * return: int [Either return the index of element that is being searched for or return -1 if not found]
         */
        // PLEASE MODIFY THIS FUNCTION TO CORRECTLY IMPLEMENT RECURSIVE BINARY SEARCH


        int mid = (low + high)/2;

        if (low > high){

            System.out.println("Recursive Binary Search");
            return -1;

        }

        else if (target == arr[mid]){
            return mid; 


        }
        else if (target < arr[mid]){

            return recursiveBinarySearch(arr, low, mid -1, target);

        }

        else{

            return recursiveBinarySearch(arr, mid+1, high, target);

        }
    }

    public static void main(String[] args) {

        
        int[] array = new int[10]; // Change length here
        for (int i  = 0; i < array.length; i++){
            array[i]= i;
        }


        // How the function is called

        long startTime = System.nanoTime();

        int result = recursiveBinarySearch(array, 0, array.length - 1, target);

        long endTime = System.nanoTime();


        System.out.println("That took " + (endTime - startTime) + " nanoseconds");

        if (result == -1) {
            System.out.println("Element not present");
        }
        else {
            System.out.println("Element found at index " + result);
        }
    }
}