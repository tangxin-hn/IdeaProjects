package interfaces.P3;

public class B extends A {
    static int i=1;
    @Override
    public void print() {
        System.out.println(i);
    }

    public static void main(String[] args){
        B b = new B();
        b.print();
    }
}
