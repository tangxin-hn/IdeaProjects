package p53;

public class MissingNumber {
    public static int getMissingNumber(int[] data) {
        if (data==null || data.length==0)
            return -1;
        int start = 0;
        int end = data.length-1;
        int mid = (start + end) / 2;
        while (start <= end) {
            if (mid != data[mid]) {
                if (mid==0 || data[mid-1] == mid-1)
                    return mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            mid = (start + end) / 2;
        }
        if (end == data.length)
            return data.length;
        return -1;
    }
}
