package exercise0;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Radu.Hoaghe on 4/20/2015.
 *
 * Exercise 0: Iterate over the keys of a Map using keySet method (this method returns a Set of all the map keys) and
 *          print all its elements.
 */
public class Exercise0 {

    public Exercise0(){

    }

    public void iterateThroughMap(){

        // TODO Exercise #0 a) Create a Map (HashMap) and add elements to it (using put() method)
        // TODO Exercise #0 a) Hint: Don't forget to specify the types of the key and value when creating the Map
        Map<String, Double> myMap = new HashMap<String, Double>();
        // TODO Exercise #0 b) Iterate over the Map using keySet() method and print all its elements
        // TODO Exercise #0 b) The elements could be printed like this: [key1=value1, key2=value2, ...]
        myMap.put("pepsi", 2.5);
        myMap.put("cola", 1.0);
        myMap.put("fanta", 0.5);

        Set<String> keys = myMap.keySet();
        //Iterator<String> it = keys.iterator();
        System.out.print("[");
        for (String currentElement : keys)  {
            System.out.print(currentElement + " = " + myMap.get(currentElement) + ", ");
        }
        System.out.print("]");
    }

    public static void main(String[] args) {
        Exercise0 exercise0 = new Exercise0();
        exercise0.iterateThroughMap();
    }
}
