package sort;

public class StraightInsertionSort {
    /**
     * 直接插入排序：将一个记录插入到已排序好的有序表中，从而得到一个新，记录数增1的有序表。
     * 稳定排序
     * 时间复杂：O(n^2)
     * 空间复杂度：O(1)
     */
    public static void sort(int[] number) {
        if (number==null)
            return;
        int length = number.length;
        for (int i=1;i<length;i++) {
            int j = i-1;
            int temp = number[i];
            while (j>=0 && number[j]>temp) {
                number[j] = number[j-1];
                j--;
            }
            number[j] = temp;
        }
    }
}
