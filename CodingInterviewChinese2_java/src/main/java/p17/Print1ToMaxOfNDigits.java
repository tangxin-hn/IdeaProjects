package p17;

public class Print1ToMaxOfNDigits {
    public static void print1ToMaxOfNDigits(int n) {
        if (n<=0)
            return;
        StringBuilder stringBuilder = new StringBuilder();
        print1ToMaxOfNDigitsRecursively(stringBuilder,n);
    }
    private static void print1ToMaxOfNDigitsRecursively(StringBuilder stringBuilder,int n) {
        if (stringBuilder.length()==n) {
            myPrint(stringBuilder);
            return;
        }
        for (int i=0;i<10;i++){
            stringBuilder.append((char)(i+'0'));
            print1ToMaxOfNDigitsRecursively(stringBuilder,n);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
    }
    private static void myPrint(StringBuilder stringBuilder) {
        boolean flag=true;
        for (int i=0;i<stringBuilder.length();i++) {
            if (flag && stringBuilder.charAt(i)=='0')
                continue;
            flag = false;
            System.out.print(stringBuilder.charAt(i));
        }
        if (!flag) {
            System.out.println();
        }
    }
    public static void main(String[] args) {
        print1ToMaxOfNDigits(-1);
        print1ToMaxOfNDigits(0);
        print1ToMaxOfNDigits(1);
        print1ToMaxOfNDigits(2);
    }
}
