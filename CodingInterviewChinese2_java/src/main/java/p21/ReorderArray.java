package p21;

import java.lang.invoke.*;
import java.lang.reflect.*;

public class ReorderArray {

    public static void  reorderOddEven_1(int[] numbers) {
        if (numbers==null || numbers.length<=1)
            return;
        int start=0;
        int end = numbers.length-1;
        while (start<end) {
            while (start<end && ((numbers[start] & 1) == 1)) {
                start++;
            }
            while (start<end && ((numbers[end] & 1) ==0)) {
                end--;
            }
            if (start<end) {
                int temp = numbers[start];
                numbers[start] = numbers[end];
                numbers[end] = temp;
            }
        }
    }

    public static void  reorderOddEven_2(int[] numbers, Method meth) throws Exception {
        if (numbers==null || numbers.length<=1)
            return;
        int start=0;
        int end = numbers.length-1;
        while (start<end) {
            while (start<end && (boolean)(meth.invoke(meth,numbers[start]))) {
                start++;
            }
            while (start<end && (!(boolean)(meth.invoke(meth,numbers[end])))) {
                end--;
            }
            if (start<end) {
                int temp = numbers[start];
                numbers[start] = numbers[end];
                numbers[end] = temp;
            }
        }
    }

    public static void  reorderOddEven_3(int[] numbers, MethodHandle methodHandle) throws Throwable  {
        if (numbers==null || numbers.length<=1)
            return;
        int start=0;
        int end = numbers.length-1;
        while (start<end) {
            while (start<end && (boolean)(methodHandle.invoke(numbers[start]))) {
                start++;
            }
            while (start<end && (!(boolean)(methodHandle.invoke(numbers[end])))) {
                end--;
            }
            if (start<end) {
                int temp = numbers[start];
                numbers[start] = numbers[end];
                numbers[end] = temp;
            }
        }
    }

    // ====================测试代码====================
    public static void printArray(int numbers[])
    {
        if(numbers==null || numbers.length == 0)
            return;

        for(int i = 0; i < numbers.length; ++i)
            System.out.print( numbers[i] + " ");

        System.out.println();
    }

    public static void test(String testName, int numbers[])
    {
        if(testName != null)
            System.out.print(testName + " begins:");
        int[] copy;
        int[] copy2;
        if (numbers==null) {
            copy  = null;
            copy2 = null;
        } else {
            copy = new int[numbers.length];
            copy2 = new int[numbers.length];
            for (int i = 0; i < numbers.length; ++i) {
                copy[i] = numbers[i];
                copy2[i] = numbers[i];
            }
        }

        System.out.println("test for solution 1:");
        printArray(numbers);
        reorderOddEven_1(numbers);
        printArray(numbers);


        try {
            Class cls = Class.forName("p21.Fuc");
            Method method = cls.getMethod("isOdd",int.class);
            System.out.println("test for solution 2:");
            printArray(copy);
            reorderOddEven_2(copy,method);
            printArray(copy);
        } catch (Throwable e) {
            System.err.println(e);
        }

        try {
            MethodHandles.Lookup lookup = MethodHandles.lookup();
            MethodHandle mh = lookup.findStatic(Fuc.class, "isOdd", MethodType.methodType(boolean.class,int.class));
            System.out.println("test for solution 3:");
            printArray(copy2);
            reorderOddEven_3(copy2,mh);
            printArray(copy2);
        } catch (Throwable e) {
            System.err.println(e);
        }
    }

    public static void test1()
    {
        int numbers[] = {1, 2, 3, 4, 5, 6, 7};
        test("test1", numbers);
    }

    public static void test2()
    {
        int numbers[] = {2, 4, 6, 1, 3, 5, 7};
        test("test2", numbers);
    }

    public static void test3()
    {
        int numbers[] = {1, 3, 5, 7, 2, 4, 6};
        test("test3", numbers);
    }

    public static void test4()
    {
        int numbers[] = {1};
        test("test4", numbers);
    }

    public static void test5()
    {
        int numbers[] = {2};
        test("test5", numbers);
    }

    public static void test6()
    {
        test("test6", null);
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
    }
}
class Fuc{
    public static boolean isOdd(int number) {
        return (number & 1) == 1;
    }
}
