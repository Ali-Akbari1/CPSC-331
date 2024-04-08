public class IterTimeTest {

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
            therefore begin is incremented by 1
            */
            if (arr[mid] < target){
                begin = mid + 1;
            }


            /* 
            If the value in the middle of the array is greater than the target 
            then this means the element is in the left half of the array
            therefore last is decreased by 1
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



        int[] array = new int[1]; // Change length here
        for (int i  = 0; i < array.length; i++){
            array[i]= i;
        }

        int target = -1; // can make it so it looks for element not in the list so it takes the most time posssible


        long startTime = System.nanoTime();
        // How the function is called
        int result = iterativeBinarySearch(array, target);

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