package p3;

public class FindDuplication {
    static boolean duplicate(int[] numbers, int[] duplication) {
        if (numbers==null)
            return false;
        int length = numbers.length;
        int[] temp = new int[length];
        for (int i=0;i<length;i++)  {
            if (numbers[i]<0 || numbers[i]>length-1)
                return false;
            temp[numbers[i]]++;
        }
        for (int i=0;i<length;i++) {
            if (temp[i]>1) {
                duplication[0] = i;
                return true;
            }
        }
        return false;
    }

    static boolean duplicate2(int[] numbers, int[] duplication) {
        if (numbers==null)
            return false;
        int length = numbers.length;
        for (int i=0;i<length;i++) {
            if (numbers[i]<0 || numbers[i]>length-1)
                return false;
        }

        for (int i=0;i<length;i++) {
            while (numbers[i]!=i) {
                if (numbers[i]==numbers[numbers[i]]){
                    duplication[0] = numbers[i];
                    return true;
                }

                int temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
    }

    static void test(String testName, int numbers[], int expected[], boolean validArgument)
    {
        System.out.println(testName + " begins: ");

        int[] duplication={1};
        boolean validInput = duplicate2(numbers, duplication);
        if(validArgument == validInput)
        {
            if(validArgument)
            {
                if(contains(expected, duplication[0]))
                    System.out.print("Passed.\n");
                else
                    System.out.print("FAILED.\n");
            }
            else
                System.out.print("Passed.\n");
        }
        else
            System.out.print("FAILED.\n");
    }

    static boolean contains(int[] expected, int number) {
        for (int i=0;i<expected.length;i++) {
            if (expected[i]==number)
                return true;
        }
        return false;
    }

    // 重复的数字是数组中最小的数字
    static void test1()
    {
        int numbers[] = { 2, 1, 3, 1, 4 };
        int duplications[] = { 1 };
        test("Test1", numbers, duplications,  true);
    }
    // 重复的数字是数组中最大的数字
    static void test2()
    {
        int numbers[] = { 2, 4, 3, 1, 4 };
        int duplications[] = { 4 };
        test("Test2", numbers, duplications,  true);
    }
    // 数组中存在多个重复的数字
    static void test3()
    {
        int numbers[] = { 2, 4, 2, 1, 4 };
        int duplications[] = { 2, 4 };
        test("Test3", numbers,  duplications, true);
    }
    // 没有重复的数字
    static void test4()
    {
        int numbers[] = { 2, 1, 3, 0, 4 };
        int duplications[] = { -1 }; // not in use in the test function
        test("Test4", numbers,  duplications,  false);
    }

    // 没有重复的数字
    static void test5()
    {
        int numbers[] = { 2, 1, 3, 5, 4 };
        int duplications[] = { -1 }; // not in use in the test function
        test("Test5", numbers, duplications,  false);
    }

    // 无效的输入
    static void test6()
    {
        int[] numbers = null;
        int duplications[] = { -1 }; // not in use in the test function
        test("Test6", numbers,  duplications,  false);
    }
}
