package p2;

public class Singleton {
    private Singleton() {}
    private static Singleton instance = new Singleton();
    public static Singleton instace(){
        return instance;
    }
    public static void print(){
        System.out.println("Singleton");
    }
}
