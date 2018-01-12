public class StringTest {
    public static void main(String[] args) {
        String string = "hello";
        string.toUpperCase();
        String s = string;
        ChangeString(string);
        System.out.println(string + s);
    }
    private static void ChangeString(String s) {
        s = "world";
    }
}
