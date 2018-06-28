package Array;

// arrays/Ex19.java
// TIJ4 Chapter Arrays, Exercise 19, page 778
/* Create a class with an int field that's initialized from a constructor
* argument. Create two arrays of these objects, using identical
* intitialization values for each array, and show that Arrays.equals() says
* that they are unequal. Add an equals() method to your class to fix the
* problem.
*/
import java.util.*;
import static net.mindview.util.Print.*;

class A2 {
    protected int x;
    A2(int x) { this.x = x; }
    public boolean equals(Object b) {
        System.out.println(b.getClass().getSimpleName());
        return (b.getClass().getSimpleName().equals("A2")
                && this.x == ((A2)b).x) ? true : false;
    }
}

public class Ex19 {
    public static void main(String[] args) {
        A2[] a1 = { new A2(1), new A2(2), new A2(3) };
        A2[] a2 = { new A2(1), new A2(2), new A2(3) };
        print(Arrays.toString(a1));
        print(Arrays.toString(a2));
        print(Arrays.equals(a1, a2));
        //print(a1[0].equals(a1[0]));
    }
}
