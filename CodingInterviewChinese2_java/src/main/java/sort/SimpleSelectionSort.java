package sort;

public class SimpleSelectionSort {
    /**
     * 简单选择排序:在要排序的一组数中，选出最小（或者最大）的一个数与第1个位置的数交换；
     *              然后在剩下的数当中再找最小（或者最大）的与第2个位置的数交换，
     *              依次类推，直到第n-1个元素（倒数第二个数）和第n个元素（最后一个数）比较为止。
     * 不稳定排序
     * 时间复杂：O(n^2)
     * 空间复杂度：O(1)
     */

    public static void Sort(int[] number) {
        for (int i=0;i<number.length;i++) {
            int min = i;
            for (int j=i+1;j<number.length;j++) {
                if (number[j]<number[min])
                    min = j;
            }
            int temp = number[i];
            number[i] = number[min];
            number[min] = temp;
        }
    }
}
