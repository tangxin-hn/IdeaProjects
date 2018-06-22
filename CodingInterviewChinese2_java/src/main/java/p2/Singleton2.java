package p2;

public class Singleton2 {
    private Singleton2() {}
    public static final Singleton2 instance() {
        return Nested.instance;
    }
    private static class Nested{
        private static final Singleton2 instance = new Singleton2();
    }
    public static void print(){
        System.out.println("Singleton2");
    }
}
