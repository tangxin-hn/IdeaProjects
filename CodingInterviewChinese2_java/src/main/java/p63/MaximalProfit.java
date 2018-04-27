package p63;

public class MaximalProfit {
    public static int maxDiff(int[] data) {
        if (data==null || data.length<2)
            return 0;
        int min = data[0];
        int diff = data[1] - min;
        for (int i=2;i<data.length;i++) {
            if (data[i]<min)
                min = data[i];
            else if (data[i]-min>diff)
                diff = data[i] - min;
        }
        return diff;
    }
}
