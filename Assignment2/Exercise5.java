
import java.util.Arrays;


public class Exercise5{


    // Simulate collisions function 
    public static Stack<Integer> simulateCollisions(int[] asteroids){

        // Create resultStack
        Stack<Integer> resultStack = new Stack<>(Integer.class, 2);

            // Iterate through the asteroids array
            for (int i = 0; i < asteroids.length; i++){

                // Current asteroid
                int curr = asteroids[i];

                System.out.println("Step-" + (i+1) + ": " + Arrays.toString(resultStack.toArray()));


                // If result stack is empty push the current asteroid
                if (resultStack.isEmpty()){
                    resultStack.push(curr);
                }

                else{

                    // Get the top asteroid from the result stack
                    int top = resultStack.peek();

                    // If the asteroids are moving in the same direction
                    // Push current into resultStack as they wont collide
                    if (((top < 0) && (curr < 0)) || ((top > 0) && (curr > 0))) {
                        resultStack.push(curr);
                    }

                    // Else if they are moving in opposite directions
                    else if (((top > 0) && (curr < 0)) || ((top < 0) && (curr > 0))){

                        // If the current is bigger push curr onto resultStack
                        if (Math.abs(curr) > Math.abs(top)){ 
                            resultStack.pop();
                            resultStack.push(curr);
                        }

                        // If they both have the same size discard both
                        else if (curr == -top || curr == top){
                            resultStack.pop();
                        }

                        // Keep the loop going if the top element in the result stack is bigger than curr
                        else if (curr < top || curr < -top){
                            continue;
                        }  
                    }
                }

            }

            System.out.println("Step-12: Final asteroid = " + Arrays.toString(resultStack.toArray()));
            return resultStack;

        }





    // Main function
    public static void main(String[] args){

        // Array of asteroids
        int[] asteroids = {7, 16, -16, -7, 5, -5, -21, 2, 2, 34, -9};

        // Print the array of asteroids
        System.out.println("Input asteroids = " + Arrays.toString(asteroids));

        // Call simulate collisions function
        simulateCollisions(asteroids);



    }


}