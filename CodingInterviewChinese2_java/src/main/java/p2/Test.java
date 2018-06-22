package p2;

public class Test {
    public static void main(String[] args) {
        Singleton.print();
        Singleton.print();
        Singleton.print();
        Singleton2.print();
        Singleton2.instance();
        Singleton2.print();
        Singleton2.print();
        System.out.println(Singleton4.INSTANCE);
    }
}
