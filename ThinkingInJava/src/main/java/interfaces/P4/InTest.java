package interfaces.P4;

interface Test {
    int i=5;
}
public class InTest implements Test{
    public static void main(String[] args) {
        System.out.println(i);
    }
}