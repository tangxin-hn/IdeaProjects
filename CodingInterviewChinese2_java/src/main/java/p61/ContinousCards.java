package p61;

import java.util.Arrays;

public class ContinousCards {
    public static boolean isContinuous(int[] number) {
        if (number==null || number.length<1)
            return false;
        Arrays.sort(number);
        int zero = 0;
        int gap = 0;
        for (int i=0;i<number.length && number[i]==0;i++) {
            zero++;
        }
        for (int i=zero;i<number.length-1;i++) {
            if (number[i]==number[i+1])
                return false;
            gap += number[i+1] - number[i] - 1;
        }
        if (gap-zero<=0)
            return true;
        return false;
    }
}
