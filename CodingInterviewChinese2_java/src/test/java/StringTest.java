public class StringTest {
    public static void main(String[] args) {

        System.out.println('\0');

        String string = "hello";
        string.toUpperCase();
        String s = string;
        ChangeString(string);
        System.out.println(string + s);


        char[] str1 = "hello".toCharArray();
        char[] str2 = "hello".toCharArray();
        char[] str3 = new char[10];
        if (str3[0]==0)
            System.out.println("0");
        System.out.println(str1.length);
        System.out.print(str3.length);
        if (str1==str2)
            System.out.println("same");
        else
            System.out.println("not same");
    }
    private static void ChangeString(String s) {
        s = "world";
    }
}
