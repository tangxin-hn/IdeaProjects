package p65;

public class AddTwoNumbers {
    public static int add(int num1,int num2) {
        int sum;
        int carry;
        do {
            sum = num1 ^ num2;
            carry = (num1 & num2)<<1;
            num1 = sum;
            num2 = carry;
        } while (num2!=0);
        return sum;
    }
}
