public class ObjectTest {
    public String value = null;
    public ObjectTest(String v) {
        value = v;
    }

    public boolean equals(ObjectTest o) {
        System.out.println("hii");
        if (o==this)
            return true;
        if (o instanceof ObjectTest) {
            System.out.println("hi");
            ObjectTest objectTest = (ObjectTest) o;
            return value.equals(objectTest.value);
        }
        return false;
    }
    public static void main(String[] args) {
        ObjectTest objectTest3 = new ObjectTest("ObjectTest");
        Object objectTest4 = new ObjectTest("ObjectTest");
        if (objectTest4 instanceof ObjectTest) {
            System.out.println("hi");
            ObjectTest objectTest = (ObjectTest) objectTest4;
            System.out.println(objectTest3.value.equals(objectTest.value));
        }
        System.out.println(objectTest3.equals(objectTest4));
    }
}
