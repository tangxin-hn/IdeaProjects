package p2;

public class Singleton2 {
    private Singleton2() {
        System.out.println("An instance of Singleton2 is created.");
    }

    public static void print()
    {
        System.out.println("Singleton2 Print");
    }

    public static Singleton2 instance() {
        return Nested.instance;
    }
    static class Nested{
        Nested() {}
        static Singleton2 instance = new Singleton2();
    }
}
