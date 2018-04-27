package p49;

public class UglyNumber {
    public static int getUglyNumber(int index) {
        if (index<=0)
            return 0;
        int[] uglyNumbers = new int[index];
        uglyNumbers[0] = 1;
        int nextPos = 1;

        int pos2 = 0;
        int pos3 = 0;
        int pos5 =0;

        while (nextPos<index) {
            int min = Math.min(uglyNumbers[pos2]*2, uglyNumbers[pos3]*3);
            min = Math.min( min,uglyNumbers[pos5]*5);
            uglyNumbers[nextPos] = min;
            while (pos2<nextPos && uglyNumbers[pos2]*2<=min)
                pos2++;
            while (pos3<nextPos && uglyNumbers[pos3]*3<=min)
                pos3++;
            while (pos5<nextPos && uglyNumbers[pos5]*5<=min)
                pos5++;
            nextPos++;
        }
        return uglyNumbers[index-1];
    }

    public static void main(String[] args) {
        System.out.print(getUglyNumber(0));
    }
}
