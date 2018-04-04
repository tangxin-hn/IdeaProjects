package sort;

public class QuickSort {
    /**
     * 快速排序：选择一个基准元素,通过一趟排序讲待排序的记录分割成独立的两部分。
     *          其中一部分记录的元素值均比基准元素值小，另一部分记录的 元素值比基准值大。
     *          然后分别对这两部分记录用同样的方法继续进行排序，直到整个序列有序
     * 不稳定排序
     * 时间复杂：O(nlogn)
     * 空间复杂度：0(1)
     */
    public static void Sort(int[] number){
        Recursion(number,0,number.length-1);
    }
    private static void Recursion(int[] number, int start, int end) {
        if (start<end) {
            int pos = Split(number,start,end);
            Recursion(number,start,pos-1);
            Recursion(number,pos+1,end);
        }
    }
    private static int Split(int[] number,int start,int end) {
        int privotKey = number[start];
        while (start<end) {
            while (end>start && number[end]>=privotKey)
                end--;
            int temp = number[end];
            number[end] = number[start];
            number[start] = temp;
            while (start<end && number[start]<=privotKey)
                start++;
            temp = number[start];
            number[start] = number[end];
            number[end] = temp;
        }
        return start;
    }
}
