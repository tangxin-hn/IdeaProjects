package p43;

import java.util.Scanner;

public class NumberOf1Between1AndN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        if (n<=0)
            return;
        System.out.println(traverse(n));
        System.out.println(finfRule(n));
    }

    //方法1：遍历每一个数
    public static int traverse(int n){
        int number=0;
        for (int i=1;i<=n;i++) {
            number += numberOf1(i);
        }
        return number;
    }
    public static int numberOf1(int n) {
        int number=0;
        while (n!=0) {
            if (n%10==1)
                number++;
            n /= 10;
        }
        return number;
    }

    //方法2：找规律
    public static int finfRule(int n) {
        char[] chars = Integer.toString(n).toCharArray();
        int number = 0;
        int first = chars[0]-'0';
        int length = chars.length;
        if (length==1) {
            if (first==0)
                return 0;
            return 1;
        }
        int numFirstDigit=0;
        if (first>1)
            numFirstDigit = (int)Math.pow(10,length-1);
        else
            numFirstDigit = n%(int)Math.pow(10,length-1) + 1;
        int numOtherDigits=first*(length-1)*(int)Math.pow(10,length-2);
        int numRecursive = finfRule(n%(int)Math.pow(10,length-1));
        return numFirstDigit+numOtherDigits+numRecursive;
    }
}
