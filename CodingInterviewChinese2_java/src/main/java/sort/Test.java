package sort;

public class Test {
    public static void main(String[] args) {
        int[] s1 = {5,3,3,4,2,1,5};
        int[] s2 = {6,7,3,4,2,4,2,9};
        RadixSort.Sort(s1);
        RadixSort.Sort(s2);
        for (int i=0;i<s1.length;i++)
            System.out.print(s1[i] );
        System.out.println();
        for (int i=0;i<s2.length;i++)
            System.out.print(s2[i] );
        System.out.println();
    }
}
