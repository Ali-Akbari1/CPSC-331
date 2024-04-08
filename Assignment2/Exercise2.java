



public class Exercise2{
    public static void main(String[] args){


        // Create Queues and stacks
        Queue<Integer> queue = new Queue<>(Integer.class, 9);
        Queue<Integer> updatedQueue = new Queue<>(Integer.class, 9);
        Queue<Integer> updatedQueueAfterDivison = new Queue<>(Integer.class, 9);
        Queue<Integer> updatedQueueAfterSorting = new Queue<>(Integer.class, 5);
        Stack<Integer> stack = new Stack<>(Integer.class, 9);
        Stack<Integer> reverseStack = new Stack<>(Integer.class, 9);
        Stack<Integer> newStack = new Stack<>(Integer.class, 9);
        Stack<Integer> newStack1 = new Stack<>(Integer.class, 5);

        // Create queue with the elements 
        int[] elementsToAdd = {3, 15, 0, 18, 4, 10, 2, 5, 25};
        for (int element : elementsToAdd) {
            queue.enqueue(element);
        }

        System.out.println("Step-1 : ");
        System.out.println("Initial Queue - " + queue);


        /* 
         Two while loops to dequeue elements into a stack and then 
         pop elements from the stack and enqueue them to an updated queue
         essentially reversing the queue

        */
        while (!queue.isEmpty()){
            stack.push(queue.dequeue());
        }

        while (!stack.isEmpty()){
            updatedQueue.enqueue(stack.pop());
        }



        System.out.println("Updated Queue - " + updatedQueue);
        System.out.println("Step-2 : ");
        System.out.println("Updated Queue - " + updatedQueue);



        while (!updatedQueue.isEmpty()) {
            stack.push(updatedQueue.dequeue());
        }

        while(!stack.isEmpty()){
            reverseStack.push(stack.pop());
        }


        

        while(!reverseStack.isEmpty()){
            int curr = reverseStack.pop(); // Pop current element
            if (!reverseStack.isEmpty()){
                
                int next = reverseStack.peek(); // Get the next element without removing it 
                int value = 0;

                // If either value is 0 set the value to 0
                if (next == 0 || curr == 0){
                    value = 0;
                }

                // If current greater than equal to next divide next by current
                else if (curr >= next){
                    value = curr / next; 
                }
                
                // Else next is greater than current 
                else{
                    value = next / curr; 
                }
                // Enqueue the result
                updatedQueueAfterDivison.enqueue(value);
            }


            else{
                updatedQueueAfterDivison.enqueue(curr);
            }

        }

        System.out.println("Updated Queue (After Division) - " + updatedQueueAfterDivison);

    


    System.out.println("Step-3:" );
    System.out.println("Updated Queue (After Division) - " + updatedQueueAfterDivison);

    
    while (!updatedQueueAfterDivison.isEmpty()) {
        newStack.push(updatedQueueAfterDivison.dequeue());
    }
    while (!newStack.isEmpty()) {

        // Pop the current element 
        int current = newStack.pop(); 

        // If the stack is empty push the first element 
        if (newStack1.isEmpty()) {
            newStack1.push(current);
        } else {

            // Move elements from newStack1 to newStack until current is greater or equal
            while (!newStack1.isEmpty() && current < newStack1.peek() ) {
                newStack.push(newStack1.pop());
            }
             // Push current element if it's not already in newStack1
            if (newStack1.isEmpty() || current != newStack1.peek()) {
                newStack1.push(current);
            }
        }
    }




    /*
    
    Three while loops to reverse the queue in the right order
    
     
     */
    while (!newStack1.isEmpty()) {
        updatedQueueAfterSorting.enqueue(newStack1.pop());
        
    }


    while (!updatedQueueAfterSorting.isEmpty()) {
        newStack1.push(updatedQueueAfterSorting.dequeue());
        
    }

    while (!newStack1.isEmpty()) {
        updatedQueueAfterSorting.enqueue(newStack1.pop());
        
    }


    System.out.println("Updated Queue (After Sorting) - " + updatedQueueAfterSorting);

    }

        

}
