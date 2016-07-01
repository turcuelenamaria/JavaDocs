package exercise.exercise3;

import java.util.Comparator;

/**
 * Created by Elena on 01.07.2016.
 */
public class MyComparator implements Comparator<String> {
    public int compare(String o1, String o2) {
        if (o1.length() == o2.length()) {
            return 0;
        } else if (o1.length() > o2.length())
            return 1;
        else return -1;
    }

    public boolean equals(String obj) {
        if (this.toString().length() == obj.length()) {
            return true;
        }
        return false;
    }
}
