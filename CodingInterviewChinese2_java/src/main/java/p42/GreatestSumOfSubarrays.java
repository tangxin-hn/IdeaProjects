package p42;

public class GreatestSumOfSubarrays {
    public static boolean flag = true;
    public static int FindGreatestSumOfSubArray(int[] numbers) {
        flag = true;
        if (numbers == null || numbers.length==0) {
            flag = false;
            return 0;
        }
        int sum = numbers[0];
        int max = sum;
        for (int i=1;i<numbers.length;i++) {
            if (sum<0)
                sum = numbers[i];
            else
                sum += numbers[i];
            if (sum>max)
                max = sum;
        }
        return max;
    }
}
