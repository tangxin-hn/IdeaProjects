package p53;

public class IntegerIdenticalToIndex {
    public static int getNumberSameAsIndex(int[] data) {
        if (data==null || data.length==0)
            return -1;
        int start = 0;
        int end = data.length-1;
        int mid = 0;
        while (start<=end) {
            mid = (start + end) >> 1;
            if (data[mid] == mid)
                return mid;
            else if (data[mid] > mid)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }
}
