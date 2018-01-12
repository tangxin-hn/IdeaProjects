package interfaces.P4;

interface A{void killA();}
interface B extends A{void killB();}
interface C extends A{void killC();}
interface D extends B,C{void killD();}

public class P13 implements D {
    public void killA() {
        System.out.println("killA");
    }
    public void killB() {
        System.out.println("killB");
    }
    public void killC() {
        System.out.println("killC");
    }
    public void killD() {
        System.out.println("killD");
    }
}
