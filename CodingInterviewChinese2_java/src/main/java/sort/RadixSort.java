package sort;

public class RadixSort {
    /**
     * 基数排序：是按照低位先排序，然后收集；再按照高位排序，然后再收集；依次类推，直到最高位。
     * 稳定的排序
     * 时间复杂：O(n(r+d))
     * 空间复杂度：0(1)
     */
    public static void sort(int[] number) {
        if (number==null)
            return;
        int max = number[0];
        for (int i=1;i<number.length;i++) {
            if (number[i]>max)
                max = number[i];
        }
        int maxRadix=0;
        while (max>0) {
            maxRadix++;
            max /= 10;
        }
        secondSort(number,maxRadix);
    }
    private static void secondSort(int L[],int maxRadix)
    {
        int length = L.length;
        int m=1,k=0,lsp=0;
        int[][] temp=new int[10][length];
        while(k<maxRadix) //遍历所有关键字
        {
            for(int i=0;i<length;i++) //分配过程
            {
                if(L[i]<m)
                    lsp = 0;
                else
                    lsp = (L[i] / m) % 10; //确定关键字
                temp[lsp][i] = L[i];
            }
            collectElement(L,temp); //收集
            m=m*10;
            k++;
        }
    }
    private static void collectElement(int[] L,int[][] temp) {
        int count=0;
        for (int i=0;i<temp.length;i++) {
            for (int j=0;j<temp[0].length;j++) {
                if (temp[i][j]!=0) {
                    L[count] = temp[i][j];
                    temp[i][j] = 0;
                    count++;
                }
            }
        }
    }
}
