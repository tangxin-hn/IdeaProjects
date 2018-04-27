package p57;

public class ContinuousSquenceWithSum {
    public static void findContinuousSequence(int sum) {
        if (sum<3)
            return;
        int small = 1;
        int big = 2;
        int mid = (sum + 1) / 2;
        int curSum = small + big;
        while (small < mid) {
            if (curSum == sum) {
                printContinuousSequence(small,big);
            }
            while (curSum>sum && small<big) {
                curSum -= small;
                small++;
                if (curSum == sum) {
                    printContinuousSequence(small,big);
                }
            }
            big++;
            curSum += big;
        }
    }
    public static void printContinuousSequence(int small,int big) {
        for (int i=small;i<=big;i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
