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
        
        NavigableSet<Integer> set = new TreeSet<>();
        set.add(10);
        set.add(20);
        set.add(30);

        System.out.println(set.ceiling(15)); // Output: 20
        System.out.println(set.lower(20));   // Output: 10
        System.out.println(set.descendingSet()); // Output: [30, 20, 10]

    }
}
/*
Output:
Initial TreeSet [A, B, Geek, Geeks, For, Z]
After removing element [A, Geek, Geeks, For, Z]
After removing first [Geek, Geeks, For, Z]
After removing last [Geek, Geeks, For]

navigable set is a sorted set that provides methods to navigate through the elements based on their natural ordering or a specified comparator.
It extends the SortedSet interface and provides additional methods for retrieving elements based on their position in the set, such as first(),
last(), lower(), higher(), floor(), and ceiling(). NavigableSet is implemented by TreeSet in Java, which uses a Red-Black tree to maintain the
sorted order of elements.
*/
