public class ClassTest {
    private int b;
    private int a;
    public ClassTest() {
        a = 1;
        b = a + 2;
    }
    public void myPrint() {
        System.out.println(a + " " + b);
    }
    public static void main(String[] args) {
        ClassTest A = new ClassTest();
        A.myPrint();
    }
}
