package sort;

public class HeapSort {
    /**
     * 堆排序： 如何将n 个待排序的数建成堆；输出堆顶元素后，怎样调整剩余n-1 个元素，使其成为一个新堆。
     * 不稳定的排序
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(1)
     */
    public static void Sort(int[] number){
        BuildingHeap(number);
        for (int i=number.length-1;i>0;i--) {
            int temp = number[i];
            number[i] = number[0];
            number[0] = temp;
            HeadAdjust(number,0,i);
        }
    }
    private static void BuildingHeap(int[] number) {
        for (int i=(number.length-1)/2;i>=0;i--) {
            HeadAdjust(number,i,number.length);
        }
    }
    private static void HeadAdjust(int[] number, int pos, int length) {
        int tmp  = number[pos];
        int child = 2*pos+1; //左孩子结点的位置。(i+1 为当前调整结点的右孩子结点的位置)
        while (child < length) {
            if(child+1 <length && number[child]<number[child+1]) { // 如果右孩子大于左孩子(找到比当前待调整结点大的孩子结点)
                ++child ;
            }
            if(number[pos]<number[child]) {  // 如果较大的子结点大于父结点
                number[pos] = number[child]; // 那么把较大的子结点往上移动，替换它的父结点
                pos = child;       // 重新设置s ,即待调整的下一个结点的位置
                child = 2*pos+1;
            }  else {            // 如果当前待调整结点大于它的左右孩子，则不需要调整，直接退出
                break;
            }
            number[pos] = tmp;         // 当前待调整的结点放到比其大的孩子结点位置上
        }
    }
}
