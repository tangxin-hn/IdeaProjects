package p45;

import java.util.Arrays;
import java.util.Comparator;

public class SortArrayForMinNumber {
    String string1 = null;
    String string2 = null;
    public static void printMinNumber(int[] numbers) {
        if (numbers==null || numbers.length==0)
            return;
        String[] strings = new String[numbers.length];
        for (int i=0;i<numbers.length;i++)
            strings[i] = numbers[i] + "";

        Arrays.sort(strings,new MyComparator());
        for (int i=0;i<numbers.length;i++) {
            System.out.print(strings[i]);
        }
        System.out.println();
    }
    private static class MyComparator implements Comparator<String> {

        @Override
        public int compare(String p1, String p2) {
            String t1 = p1 + p2;
            String t2 = p2 + p1;
            return t1.compareTo(t2);
        }
    }

    public static void main(String[] args) {
        int[] numbers = {3, 5, 1, 4, 2};
        printMinNumber(numbers);
    }
}


