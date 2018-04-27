import java.lang.reflect.*;

public class ReflectTest {

    //一个简单的例子
    public static void test1() {
        try {
            Class c = Class.forName("java.util.Stack");
            Method m[] = c.getDeclaredMethods();
            for (int i = 0; i < m.length; i++)
                System.out.println(m[i].toString());
        } catch (Throwable e) {
            System.err.println(e);
        }
    }

    //使用 Reflection
    public static void test2() {
        try {
            Class cls = Class.forName("A");
            boolean b1 = cls.isInstance(new Integer(37));
            System.out.println(b1);
            boolean b2 = cls.isInstance(new A());
            System.out.println(b2);
        } catch (Throwable e) {
            System.err.println(e);
        }
    }

    //找出类的方法
    public static void test3() {
        try {
            Class cls = Class.forName("A");
            Method methlist[] = cls.getDeclaredMethods();
            for (int i = 0; i < methlist.length; i++) {
                Method m = methlist[i];
                System.out.println("name = " + m.getName());
                System.out.println("decl class = " + m.getDeclaringClass());
                Class pvec[] = m.getParameterTypes();
                for (int j = 0; j < pvec.length; j++)
                    System.out.println("param #" + j + " " + pvec[j]);
                Class evec[] = m.getExceptionTypes();
                for (int j = 0; j < evec.length; j++)
                    System.out.println("exc #" + j + " " + evec[j]);
                System.out.println("return type = " + m.getReturnType());
                System.out.println("-----");
            }
        } catch (Throwable e) {
            System.err.println(e);
        }
    }

    //获取构造器信息
    public static void test4() {
        try {
            Class cls = Class.forName("A");
            Constructor ctorlist[] = cls.getDeclaredConstructors();
            for (int i = 0; i < ctorlist.length; i++) {
                Constructor ct = ctorlist[i];
                System.out.println("name = " + ct.getName());
                System.out.println("decl class = " + ct.getDeclaringClass());
                Class pvec[] = ct.getParameterTypes();
                for (int j = 0; j < pvec.length; j++)
                    System.out.println("param #" + j + " " + pvec[j]);
                Class evec[] = ct.getExceptionTypes();
                for (int j = 0; j < evec.length; j++)
                    System.out.println("exc #" + j + " " + evec[j]);
                System.out.println("-----");
            }
        } catch (Throwable e) {
            System.err.println(e);
        }
    }

    //获取类的字段
    public static void test5() {
        try {
            Class cls = Class.forName("A");
            Field fieldlist[] = cls.getDeclaredFields();
            for (int i = 0; i < fieldlist.length; i++) {
                Field fld = fieldlist[i];
                System.out.println("name = " + fld.getName());
                System.out.println("decl class = " + fld.getDeclaringClass());
                System.out.println("type = " + fld.getType());
                int mod = fld.getModifiers();
                System.out.println("modifiers = " + Modifier.toString(mod));
                System.out.println("-----");
            }
        } catch (Throwable e) {
            System.err.println(e);
        }
    }

    //根据方法的名称来执行方法
    public static void test6() {
        try {
            Class cls = Class.forName("A");
            Class partypes[] = new Class[2];
            partypes[0] = Integer.TYPE;
            partypes[1] = Integer.TYPE;
            Method meth = cls.getMethod("add", partypes);
            A methobj = new A();
            Object arglist[] = new Object[2];
            arglist[0] = new Integer(37);
            arglist[1] = new Integer(47);
            Object retobj = meth.invoke(methobj, arglist);
            Integer retval = (Integer) retobj;
            System.out.println(retval.intValue());

            Method method = cls.getMethod("isOdd", int.class);
            boolean flag = (boolean) method.invoke(method,2);
            System.out.println(flag);

        } catch (Throwable e) {
            System.err.println(e);
        }
    }

    //创建新的对象
    public static void test7() {
        try {
            Class cls = Class.forName("A");
            Constructor ct = cls.getConstructor(Integer.TYPE);
            Object retobj = ct.newInstance(5);
        } catch (Throwable e) {
            System.err.println(e);
        }
    }

    //改变字段(域)的值--只能改变public
    public static void test8() {
        try {
            Class cls = Class.forName("A");
            Field fld = cls.getField("d");
            A f2obj = new A();
            System.out.println("d = " + f2obj.d);
            fld.setDouble(f2obj, 12.34);
            System.out.println("d = " + f2obj.d);
        } catch (Throwable e) {
            System.err.println(e);
        }

        System.out.println("what");

        try {
            Class cls = Class.forName("A");
            Field fld = cls.getField("a");
            A f2obj = new A();
            System.out.println("a = " + f2obj.a);
            fld.setInt(f2obj, 12);
            System.out.println("a = " + f2obj.a);
        } catch (Throwable e) {
            System.err.println(e);
        }
    }

    //使用数组
    public static void test9() {
        try {
            Class cls = Class.forName("java.lang.String");
            Object arr = Array.newInstance(cls, 10);
            Array.set(arr, 5, "this is a test");
            String s = (String) Array.get(arr, 5);
            System.out.println(s);
        } catch (Throwable e) {
            System.err.println(e);
        }

        int dims[] = new int[]{5, 10, 15};
        Object arr = Array.newInstance(Integer.TYPE, dims);
        Object arrobj = Array.get(arr, 3);
        Class cls = arrobj.getClass().getComponentType();
        System.out.println(cls);
        arrobj = Array.get(arrobj, 5);
        Array.setInt(arrobj, 10, 37);
        int arrcast[][][] = (int[][][]) arr;
        System.out.println(arrcast[3][5][10]);
    }

    public static void main(String args[]) {
        test6();
    }
}
class A {
    int a;
    public double d;
    public static final double dd = 4.5;
    private static final String s = "hello";
    public A() {
        this.a = 0;
        System.out.println(this.a);
    }
    public A(int a) {
        this.a = a;
        System.out.println(a);
    }

    public static boolean isOdd(int number) {
        if ((number&1)==1)
            return true;
       return false;
    }

    public int add(int a, int b) {
        return a + b;
    }
}