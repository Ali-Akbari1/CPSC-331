public class Main{

public static void main(String[] args){


    // Create the Hash function
    HashFunction hashFunction = new MainHashFunction();

    // Create the hashtable
    HashTableSC<HashableObject> hashtable = new HashTableSC<>(hashFunction, 8);


      // Step 1: Insert students
      hashtable.insert(20500120, "Bob");
      hashtable.insert(20700200, "Alice");
      hashtable.insert(30100230, "Cathy");
      hashtable.insert(20200156, "Ali");

      // Step 2: Print the entire database
      System.out.println("Step 2: Database after insertion:");
      System.out.println(hashtable);

      // Step 3: Update Bob's name
      hashtable.insert(20500120, "Bobby");

      System.out.println(hashtable);

      // Step 4: Search for ID 20500120
      System.out.println("Step 4: Search for ID 20500120: " + hashtable.search(20500120));

      // Step 5: Retrieve value associated with ID 20700200
      System.out.println("Step 5: Retrieve value associated with ID 20700200: " + hashtable.retrieve(20700200));

      // Step 6: Remove student with ID 20700200
      hashtable.delete(20700200);

      // Step 7: Try to remove student with ID 20700200 again
      hashtable.delete(20700200);

      // Step 8: Try to retrieve value associated with ID 20700200
      System.out.println("Step 8: Retrieve value associated with ID 20700200: " + hashtable.retrieve(20700200));

      // Step 9: Print the updated database
      System.out.println("Step 9: Updated database:");
      System.out.println(hashtable);

    }

    
}



