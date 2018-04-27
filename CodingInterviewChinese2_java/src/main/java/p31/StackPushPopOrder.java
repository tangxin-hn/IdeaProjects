package p31;

import java.util.Stack;

public class StackPushPopOrder {
    public static boolean isPopOrder(int[] pushs, int[] pops) {
        if (pushs==null || pops==null || pushs.length!=pops.length)
            return false;
        Stack<Integer> stack = new Stack<>();
        int pos = 0;
        for (int i=0;i<pops.length;i++) {
            while (stack.empty() || stack.peek()!=pops[i]) {
                if (pos>=pushs.length)
                    return false;
                stack.push(pushs[pos]);
                pos++;
            }
            stack.pop();
        }
        return true;
    }
    public static void test(String testName, int[] pushs, int[] pops, boolean expected)
    {
        if(testName != null)
            System.out.print(testName + " begins: ");

        if(isPopOrder(pushs,pops) == expected)
            System.out.println("Passed.");
        else
            System.out.println("FAILED.---------------------------------");
    }

    public static void test1()
    {
        int[] push = {1, 2, 3, 4, 5};
        int[] pop = {4, 5, 3, 2, 1};

        test("test1", push, pop, true);
    }

    public static void test2()
    {
        int[] push = {1, 2, 3, 4, 5};
        int[] pop = {3, 5, 4, 2, 1};

        test("test2", push, pop, true);
    }

    public static void test3()
    {
        int[] push = {1, 2, 3, 4, 5};
        int[] pop = {4, 3, 5, 1, 2};

        test("test3", push, pop, false);
    }

    public static void test4()
    {
        int[] push = {1, 2, 3, 4, 5};
        int[] pop = {3, 5, 4, 1, 2};

        test("test1", push, pop, false);
    }

    public static void test5()
    {
        int[] push = {1};
        int[] pop = {2};

        test("test5", push, pop, false);
    }
    public static void test6()
    {
        int[] push = {1};
        int[] pop = {1};

        test("test6", push, pop, true);
    }
    public static void test7()
    {

        test("test7", null, null, false);
    }


    public static void main(String[] args)
    {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
    }
}
