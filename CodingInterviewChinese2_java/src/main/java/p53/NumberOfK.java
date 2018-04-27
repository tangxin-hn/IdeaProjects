package p53;

public class NumberOfK {
    public static int getFirstK(int[] data, int k) {
        if (data==null)
            return -1;
        int start = 0;
        int end = data.length-1;
        int mid = (end + start) / 2;
        while (start<=end){
            if (data[mid] == k && (mid==0 || data[mid-1] != k) )
                return mid;
            else if (data[mid]>=k)
                end = mid - 1;
            else
                start = mid + 1;
            mid = (end + start) / 2;
        }
        return -1;
    }
    public static int getLastK(int[] data, int k) {
        if (data==null)
            return -1;
        int start = 0;
        int end = data.length-1;
        int mid = (end + start) / 2;
        while (start<=end){
            if (data[mid] == k && (mid == end || data[mid+1] != k) )
                return mid + 1;
            else if (data[mid]<=k)
                start = mid + 1;
            else
                end = mid -1;
            mid = (end + start) / 2;
        }
        return -1;
    }
    public static int getNumberOfK(int[] data, int k) {
        if (data==null || data.length==0)
            return 0;
        return getLastK(data,k) - getFirstK(data,k);
    }

    public static void main(String[] args) {
        int[] data = {3, 3, 3, 3, 4, 5};;
        int k = 3;
        System.out.println(getNumberOfK(data,k));
    }
}
