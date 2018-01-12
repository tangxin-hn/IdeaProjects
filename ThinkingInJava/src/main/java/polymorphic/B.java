package polymorphic;

public class B extends A {
    @Override
    public void method1() {
        System.out.println("B.method1");
        method2();
    }
    @Override
    public void method2() {
        System.out.println("B.method2");
    }

    public static void main(String[] args) {
        A b = new B();
        b.method1();
    }
}
