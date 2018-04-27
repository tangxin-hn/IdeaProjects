package sort;

public class ShellSort {
    /**
     * 希尔排序：先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，
     *           待整个序列中的记录“基本有序”时，再对全体记录进行依次直接插入排序。
     * 不稳的排序
     * 时间复杂度：依赖于增量因子序列d，不确定
     * 空间复杂度：无
     */

    public static void sort(int[] number) {
        if (number==null)
            return;
        int length = number.length;
        int dk = length/2;
        while (dk>=1) {
            secondSort(number,dk);
            dk = dk/2;
        }
    }
    private static void secondSort(int[] number, int dk) {
        for (int i=dk;i<number.length;i++) {
            if (number[i]<number[i-dk]) {
                int j = i - dk;
                int temp = number[i];
                number[i] = number[j];
                while (j >= 0 && number[j] > temp) {
                    number[j + dk] = number[j];
                    j = j - dk;
                }
                number[j + dk] = temp;
            }
        }
    }
}
