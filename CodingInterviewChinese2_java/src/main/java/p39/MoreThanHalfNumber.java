package p39;

import static sort.QuickSort.partition;

public class MoreThanHalfNumber {
    private static boolean flag = false;
    private static boolean checkMoreThanHalf(int[] numbers, int number) {
        int count=0;
        for (int i=0;i<numbers.length;i++) {
            if (numbers[i]==number)
                count++;
        }
        if (count>(numbers.length/2)) {
            flag = true;
            return true;
        }
        return false;
    }

    // ====================方法1====================
    public static int moreThanHalfNumber1 (int[] numbers) {
        flag = false;
        if (numbers==null || numbers.length==0)
            return 0;
        int mid = numbers.length/2;
        int start = 0;
        int end = numbers.length-1;
        int index = partition(numbers,start,end);
        while (index!=mid) {
            if (index>mid) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            index = partition(numbers,start,end);
        }
        int result = numbers[index];
        if (!checkMoreThanHalf(numbers,result))
            return 0;
        return result;
    }

    // ====================方法2====================
    public static int moreThanHalfNumber2 (int[] numbers) {
        flag = false;
        if (numbers==null || numbers.length==0)
            return 0;
        int number = numbers[0];
        int count = 1;
        for (int i=1;i<numbers.length;i++) {
            if (count==0) {
                count = 1;
                number = numbers[i];
            } else {
                if (numbers[i] == number)
                    count++;
                else
                    count--;
            }
        }
        if (!checkMoreThanHalf(numbers,number))
            return 0;
        return number;
    }
}
