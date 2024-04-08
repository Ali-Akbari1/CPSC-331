


public class Exercise3{

    public static void main(String[] args){

        // Create Stack and Queue
        Stack<Integer> stack = new Stack<>(Integer.class, 12);
        Queue<Integer> queue = new Queue<>(Integer.class, 12);

        int[] elementsToAdd = {2, 9, 3, 1, 8, 9, 0, 7, 8, 4, 5, 3};

        // Push the elements into the stack
        for (int element : elementsToAdd) {
            stack.push(element);
        }
        System.out.println("Input Stack: " + stack);


        // Two while loops to reverse the stack
        while (!stack.isEmpty()){
            queue.enqueue(stack.pop());
        }

        while (!queue.isEmpty()){
            stack.push(queue.dequeue());
        }


        
        System.out.println("Output Reversed Stack: " + stack);


        
        while (!stack.isEmpty()){
            queue.enqueue(stack.pop());
        }

        while (!queue.isEmpty()){
            stack.push(queue.dequeue());
        }
        

        // Generate more queues and stacks
        Stack<Integer> uniqueSet = new Stack<>(Integer.class, 12);
        Queue<Integer> uniqueQueue = new Queue<>(Integer.class, 9);
        Stack<Integer> uniqueStack = new Stack<>(Integer.class, 9);



        while(!stack.isEmpty()){

            // Pop an element from the stack
            int tmp = stack.pop();
            boolean found = false; 

            // Iterate through uniqueSet to check for duplicates
            for (int i = 0; i < uniqueSet.getSize(); i++){
                if (uniqueSet.get(i) == null){
                    i++;
                }
                else if (uniqueSet.get(i) == tmp){
                    found = true;
                    break;
                }
            }

            // If found is not true push tmp to uniqueSet and uniqueQueue
            if (!found){
                uniqueSet.push(tmp);
                uniqueQueue.enqueue(tmp);
            }
            }



        while (!uniqueQueue.isEmpty()){
            uniqueStack.push(uniqueQueue.dequeue());
        }

        

            System.out.println("Output Queue with unique values: " + uniqueStack);

        
        }


    }

