package p47;

public class MaxValueOfGifts {
    public static int getMaxValue_solution1(int[][] gifts) {
        if (gifts==null || gifts.length==0 || gifts[0].length==0)
            return 0;
        int[][] maxVal = new int[gifts.length][gifts[0].length];
        for (int i=0;i<gifts.length;i++) {
            for (int j=0;j<gifts[0].length;j++) {
                int up = 0;
                int left = 0;
                if (i>0)
                    up = maxVal[i-1][j];
                if (j>0)
                    left = maxVal[i][j-1];
                maxVal[i][j] = gifts[i][j] + Math.max(up,left);
            }
        }
        return maxVal[gifts.length-1][gifts[0].length-1];
    }

    public static int getMaxValue_solution2(int[][] gifts) {
        if (gifts==null || gifts.length==0 || gifts[0].length==0)
            return 0;
        int[] maxVal = new int[gifts[0].length];
        for (int i=0;i<gifts.length;i++) {
            for (int j=0;j<gifts[0].length;j++) {
                int up = 0;
                int left = 0;
                if (i>0)
                    up = maxVal[j];
                if (j>0)
                    left = maxVal[j-1];
                maxVal[j] = gifts[i][j] + Math.max(up,left);
            }
        }
        return maxVal[gifts[0].length-1];
    }
}
