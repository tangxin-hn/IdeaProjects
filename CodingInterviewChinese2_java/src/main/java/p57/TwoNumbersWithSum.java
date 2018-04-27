package p57;

public class TwoNumbersWithSum {
    public static boolean findTwoNumbersWithSum(int[] data, int[] result, int sum) {
        if (data == null || result == null || data.length < 2 || result.length<2) {
            return false;
        }
        int start = 0;
        int end = data.length - 1;
        while (start<end) {
            if (data[start] + data[end] == sum) {
                result[0] = data[start];
                result[1] = data[end];
                return true;
            } else if (data[start] + data[end] < sum) {
                start++;
            } else {
                end--;
            }
        }
        return false;
    }
}
