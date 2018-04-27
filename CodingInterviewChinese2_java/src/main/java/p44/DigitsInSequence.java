package p44;

public class DigitsInSequence {
    public static int digitAtIndex(int index) {
        if (index<0)
            return -1;
        int digits = 1;
        while (true) {
            int number = countOfIntegers(digits);
            if (index < number * digits)
                return digitAtIndex(index,digits);
            index -= number * digits;
            digits++;
        }
    }
    public static int digitAtIndex(int index,int digits) {
        int number = beginNumber(digits) + index/digits;
        int indexFromRight = digits-index%digits;
        for (int i=1;i<indexFromRight;i++)
            number /= 10;
        return number%10;
    }
    public static int beginNumber(int digits) {
        if (digits==1)
            return 0;
        return (int)Math.pow(10,digits-1);
    }
    public static int countOfIntegers(int digits) {
        if (digits==1)
            return 10;
        return 9 * (int)Math.pow(10,digits-1);
    }
    public static void main(String[] args) {
        System.out.print(digitAtIndex(10));
    }
}
