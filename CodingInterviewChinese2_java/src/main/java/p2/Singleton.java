package p2;

public class Singleton {
    private Singleton() {
        System.out.println("An instance of Singleton is created.");
    }

    public static void print()
    {
        System.out.println("Singleton Print");
    }

    private static Singleton instance = new Singleton();
    public static Singleton instace(){
        return instance;
    }
}
