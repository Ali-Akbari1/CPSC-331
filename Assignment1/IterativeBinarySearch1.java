public class IterativeBinarySearch {

    public static int iterativeBinarySearch(int[] arr, int target) {
        /*
         * int[] arr: Sorted array as input
         * target: Value that is being searched for in the array
         *
         * return: int [Either return the index of element that is being searched for or return -1 if not found]
         */
        // PLEASE MODIFY THIS FUNCTION TO CORRECTLY IMPLEMENT ITERATIVE BINARY SEARCH



        // Initialize begin and end to the start and end indices of the array
        int begin = 0; 
        int last = arr.length - 1; 

        while (begin <= last){


            // Middle index of array
            int mid = (begin + last)/2;



            /* 
            If the value in the middle of the array is less than the target 
            then this means the element is in the right half of the array
            therefore the beginning of the array is start of the right half of the array
            */
            if (arr[mid] < target){
                begin = mid + 1;
            }


            /* 
            If the value in the middle of the array is greater than the target 
            then this means the element is in the left half of the array
            therefore last is made into the ending of the left half of the array
            */

            else if (arr[mid] > target){
                last = mid - 1;
            }

            // Otherwise the element is at the middle index
            else{
                return mid;
            }

        }

        


        System.out.println("Iterative Binary Search");

        // If the element is not in the array return -1
        return -1;
    }

    public static void main(String[] args) {
        int[] array = { 2, 3, 4, 10, 40 };
        int target = 10;
        // How the function is called
        int result = iterativeBinarySearch(array, target);

        if (result == -1) {
            System.out.println("Element not present");
        }
        else {
            System.out.println("Element found at index " + result);
        }
    }
}