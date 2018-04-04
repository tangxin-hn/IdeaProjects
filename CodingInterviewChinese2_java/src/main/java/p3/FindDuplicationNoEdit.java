package p3;

public class FindDuplicationNoEdit {
    public static int getDuplication(final int[] numbers){
        if (numbers==null)
            return -1;
        int start = 1;
        int end = numbers.length-1;
        while (start<=end) {
            int middle = ((end-start)>>1) + start;
            int count = countRange(numbers,start,end);
            if (end==start) {
                if (count>1)
                    return start;
                else
                    break;
            }
            if (count>middle-start+1)
                end = middle;
            else
                start = middle+1;
        }
        return -1;
    }
    static int countRange(final int[] numbers,int start,int end) {
        if (numbers==null)
            return 0;
        int count=0;
        for (int i=0;i<numbers.length;i++) {
            if (numbers[i]>=start && numbers[i]<=end)
                count++;
        }
        return count;
    }
}
