package sort;

public class MergeSort {
    /**
     * 归并排序：将两个（或两个以上）有序表合并成一个新的有序表，即把待排序序列分为若干个子序列，
     *          每个子序列是有序的。然后再把有序子序列合并为整体有序序列。
     * 稳定的排序
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(n）
     */
    public static void Sort(int[] number) {
        int[] temp = new int[number.length];
        Recursion(number,temp,0,number.length-1);
    }
    private static void Recursion(int[] number,int[] temp,int start,int end) {
        if (end>start) {
            int middle = (start+end)/2;
            Recursion(number,temp,start,middle);
            Recursion(number,temp,middle+1,end);
            Merge(number,temp,start,middle,end);
        }
    }
    private static void Merge(int[] number,int[] temp,int start,int middle,int end) {
        int i,j,k;
        for (i=0,j=start,k=middle+1;j<=middle && k<=end;i++) {
            if (number[j]<=number[k]) {
                temp[i] = number[j];
                j++;
            } else {
                temp[i] = number[k];
                k++;
            }
        }
        while (j<=middle) {
            temp[i] = number[j];
            i++;
            j++;
        }
        while (k<=end) {
            temp[i] = number[k];
            i++;
            k++;
        }
        for (i=0;i<=end-start;i++) {
            number[start+i] = temp[i];
        }
    }
}
