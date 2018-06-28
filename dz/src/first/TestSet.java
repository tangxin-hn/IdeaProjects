package first;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class TestSet {
    public static void main(String[] args) {
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> list = new LinkedList<>();
        list.add(5);
        set.add(list);
        set.add(new LinkedList<>(list));
        System.out.println(set);
        List<Integer> list2 = new LinkedList<>();
        list2.add(5);
        System.out.print( list.equals(list2));
        set.clear();
        System.out.println(set);
    }
}
