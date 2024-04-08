public class RecursiveBinarySearch {

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


        // Initialize mid as the middle index of the array
        int mid = (low + high)/2;

        /*
        
        If the low number is greater than the high number
        Than the number is not in the array and return -1
        */
        if (low > high){

            System.out.println("Recursive Binary Search");
            return -1;

        }

        // If the target is at middle index return the middle index
        else if (target == arr[mid]){
            return mid; 


        }
        /*
        If the target is less than the number at the middle than
        the target must be in the left half of the array
        */ 
        else if (target < arr[mid]){

            return recursiveBinarySearch(arr, low, mid -1, target);

        }

        /*

        Else the number at the middle of the array is greater than the 
        target and the target must be in the right half of the array

        */ 
        else{

            return recursiveBinarySearch(arr, mid+1, high, target);

        }
    }

    public static void main(String[] args) {
        int[] array = { 2, 3, 4, 10, 40 };
        int target = 10;
        // How the function is called
        int result = recursiveBinarySearch(array, 0, array.length - 1, target);

        if (result == -1) {
            System.out.println("Element not present");
        }
        else {
            System.out.println("Element found at index " + result);
        }
    }
}