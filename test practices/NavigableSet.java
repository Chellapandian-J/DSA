import java.util.*;

class GFG {

    public static void main(String[] args){
        
        // Creating an object of NavigableSet with reference
        // to TreeSet class
        NavigableSet<String> ts = new TreeSet<>();

        // Elements are added using add() method
        ts.add("Geek");
        ts.add("For");
        ts.add("Geeks");
        ts.add("A");
        ts.add("B");
        ts.add("Z");

        System.out.println("Initial TreeSet " + ts);

        // Removing a specific existing element inserted
        // above
        ts.remove("B");

        // Printing the updated TreeSet
        System.out.println("After removing element " + ts);

        // Now removing the first element using pollFirst()
        // method
        ts.pollFirst();

        // Again printing the updated TreeSet
        System.out.println("After removing first " + ts);

        // Removing the last element using pollLast() method
        ts.pollLast();

        System.out.println("After removing last " + ts);
    }
}
/*
Output:
Initial TreeSet [A, B, Geek, Geeks, For, Z]
After removing element [A, Geek, Geeks, For, Z]
After removing first [Geek, Geeks, For, Z]
After removing last [Geek, Geeks, For]
*/