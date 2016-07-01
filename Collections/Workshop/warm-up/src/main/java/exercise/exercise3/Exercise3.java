package exercise.exercise3;

import java.util.*;

/**
 * Created by Radu.Hoaghe on 04/20/2015.
 *
 * Exercise 3: Fill three Set implementations that you know (Hint: they were described during
 *             the earlier presentation) with the List<String> that is given to this class by
 *             its constructor.
 *
 *             Check out the elements that the list mentioned above contains and then, add them
 *             to your three Sets. After this check out the elements of your Sets. What do you
 *             remark? What could be the reason?
 *
 *             Finally, add to the one of the three Sets some elements
 *             that already exist in the Set (e.g add("that") and add("collection"))
 *
 *             To run your implementation, run the Exercise3Test class.
 */
public class Exercise3 extends MyComparator {

    // List containing some elements that need to be added into the Set
    private List<String> listToAdd;

    public Exercise3(List<String> l) {
        listToAdd = l;
    }

    public void addElementsToSets(){

        System.out.println("The elements that will be added to the Sets: " + listToAdd);
        // TODO Exercise #3 a) Check the content of the elements you will add into the Set
        Set<String> firstSet = new HashSet<String>();
        Set<String> secondSet = new LinkedHashSet<String>();
        Set<String> thirdSet = new TreeSet<String>(new MyComparator());
        // TODO Exercise #3 b) add the elements from listToAdd to the Sets
        firstSet.addAll(listToAdd);
        secondSet.addAll(listToAdd);
        thirdSet.addAll(listToAdd);
        // TODO Exercise #3 c) Check the content of the Sets
        System.out.println("\nThe elements contained in the first Set: " + firstSet.toString());

        System.out.println("\nThe elements contained in the second Set: " + secondSet.toString());

        System.out.println("\nThe elements contained in the third Set: " + thirdSet.toString());
        thirdSet.add("collection");
        thirdSet.add("that");

        System.out.println("\nThe elements contained in the TreeSet after inserting two duplicates: " + thirdSet.toString());

        // TODO Exercise #3 d) Add to the TreeSet two elements that already exist in the Set
        // TODO Exercise #3 d) and print again the TreeSet. What do you see?
    }
}
