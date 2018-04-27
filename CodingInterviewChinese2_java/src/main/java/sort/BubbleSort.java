package sort;

public class BubbleSort {
    /**
     * 冒泡排序：每当两相邻的数比较后发现它们的排序与排序要求相反时，就将它们互换。
     * 稳定的排序
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     */
    public static void sort(int[] number){
        for (int i=1;i<number.length;i++) {
            for (int j=i;j>0;j--) {
                if (number[j]<number[j-1]) {
                    int temp = number[j-1];
                    number[j-1] = number[j];
                    number[j] = temp;
                }
            }
        }
    }
}
