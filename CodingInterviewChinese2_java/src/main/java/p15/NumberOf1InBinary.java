package p15;

public class NumberOf1InBinary {
    public static int numberOf1(int number) {
        int count=0;
        while (number!=0) {
            count++;
            number = (number - 1) & number;
        }
        return number;
    }
}
