package p60;

import p59.MaxInSlidingWindow;

public class DicesProbability {
    static int maxValue = 6;
    public static void printProbability(int number) {
        if (number<1)
            return;
        int[][] probability = new int[2][maxValue * number + 1];
        int flag = 0;
        for (int i=1;i<=maxValue;i++)
            probability[flag][i] = 1;
        for (int k=2;k<=number;k++) {
            for (int i=0;i<k;i++)
                probability[1-flag][i] = 0;
            for (int i=k;i<=maxValue*k;i++) {
                probability[1-flag][i] = 0;
                for (int j=1;j<=i && j<=maxValue;j++)
                    probability[1-flag][i] += probability[flag][i-j];
            }
            flag = 1 - flag;
        }
        double total = Math.pow(maxValue,number);
        for (int i=number;i<=maxValue*number;i++) {
            double ratio = probability[flag][i] / total;
            System.out.println(i + ":" + ratio);
        }
    }

    public static void main(String[] args) {
        printProbability(0);
        System.out.println();
        printProbability(1);
        System.out.println();
        printProbability(2);
        System.out.println();
        printProbability(3);
        System.out.println();
    }
}
