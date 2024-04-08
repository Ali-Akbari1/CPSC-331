


public class Exercise4 {
    public static void main(String[] args) {

        // Stack to store Tuple Objects
        Stack<Tuple> stack = new Stack<>(Tuple.class, 1);

        // Create the dictionary
        Tuple[] dictionary = new Tuple[6];


        // Add the items into the dictionary
        dictionary[0] = new Tuple("Nike", 450, 15);
        dictionary[1] = new Tuple("Adidas", 400, 10);
        dictionary[2] = new Tuple("Puma", 600, 30);
        dictionary[3] = new Tuple("Sorel", 360, 0);
        dictionary[4] = new Tuple("Aldo", 680, 15);
        dictionary[5] = new Tuple("Skechers", 390, 0);


        System.out.println();

        // Push the first tuple onto the stack
        stack.push(dictionary[0]);

        // Iterate through the dictionary
        for (int i = 1; i < 6; i++){

            // If i is 1 print out 1st step
            if (i == 1){
                System.out.println("1st step: " + stack);
            }


            // Get the first item from the stack
            Tuple firstItem = stack.peek();

            // Get the original price of first item
            double originalPrice = firstItem.getOriginalPrice();

            // Get the discount of first item
            double discount = firstItem.getDiscount();
    
            // Calculate the discounted price of the first item
            double prev = originalPrice - (originalPrice*(discount/100.0));

            /* 
             Get the original price and discount of the next item 
             in the dictionary and calculate the discounted price
            */
            Tuple nextItem = dictionary[i];

            double originPrice = nextItem.getOriginalPrice();
            double dscnt = nextItem.getDiscount();
    
            double next = originPrice - (originPrice*(dscnt/100.0));


            // Compare the discounted prices
            if (next < prev){

                // If the nextItem has a lower price put that into the stack and pop the currentItem out
                stack.pop();
                stack.push(nextItem);
                if (i+1 ==2 ){
                    System.out.println( (i+1) + "nd step: " + stack +  " as " + originPrice + " X " + 
                    dscnt + " percent = " + next + " is less than " + originalPrice);

                }
            }

            // If they have the same price compare the discounts of each
            else if (next == prev){
                System.out.println( (i+1) + "th step: " + stack +  " as " + originPrice + " X " + 
                dscnt + " percent = " + next + " = " + prev + " and 'Adidas has a discount'");

                // If the nextItem does not have a discount continue the loop
                if (dscnt == 0){
                    continue;
                }
                // If the firstItem in the dictionary doesnt have a discount put the nextItem into the stack
                else if(discount == 0){
                    stack.pop();
                    stack.push(nextItem);
                }
            }

            // Else the next Items discounted price is higher than the current Items
            // Continue the loop and print if possible
            else{

                if (i+1 ==3 ){
                    System.out.println( (i+1) + "rd step: " + stack +  " as " + originPrice + " X " + 
                    dscnt + " percent = " + next + " is greater than " + prev);

                }
                else{
                    System.out.println( (i+1) + "th step: " + stack +  " as " + originPrice + " X " + 
                    dscnt + " percent = " + next + " is greater than " + prev);

                }
            }
            }

        }




        



    }

