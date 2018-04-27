package p40;

import java.util.TreeMap;

import static sort.QuickSort.partition;

public class KLeastNumbers {
    // ====================方法1====================
    public static void getKLeastNumbers1(int[] input, int[] output, int k) {
        if (input==null || k<=0 || input.length<k)
            return;
        int start = 0;
        int end = input.length-1;
        int index = partition(input,start,end);
        while (index!=k-1) {
            if (index>k-1)
                end = index - 1;
            else
                start = index + 1;
            index = partition(input,start,end);
        }
        for (int i=0;i<k;i++)
            output[i] = input[i];
    }
    // ====================方法2====================
    // 使用了TreeMap, 无法处理重复数据
    public static void getKLeastNumbers2(int[] input, int[] output, int k) {
        if (input==null || k<=0 || input.length<k)
            return;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for (int i=0;i<input.length;i++) {
            if (map.size()<k) {
                map.put(input[i],input[i]);
            } else {
                if (map.lastEntry().getKey()>input[i]) {
                    map.pollLastEntry();
                    map.put(input[i], input[i]);
                }
            }
        }
        for (int i=0;i<k;i++) {
            output[i] = map.pollFirstEntry().getKey();
        }
    }

    // ====================测试代码====================
    public static void test(String testName, int[] data, int[] expectedResult, int k) {
        if(testName != null)
            System.out.println(testName + " begins: ");

        if(expectedResult == null) {
            System.out.print("The input is invalid, we don't expect any result.\n");
        } else {
            System.out.print("Expected result: \n");
            for(int i = 0; i < k; ++ i)
                System.out.print(expectedResult[i] + " ");
            System.out.print("\n");
        }
        int[] copy = null;
        if (data!=null) {
            copy = new int[data.length];
            for (int i=0;i<data.length;i++)
                copy[i] = data[i];
        }

        System.out.print("Result for solution1:\n");
        int[] output = null;
        if (k>0 && k<=data.length) {
            output = new int[k];
        }
        getKLeastNumbers1(data,output, k);
        if(output != null)
        {
            for(int i = 0; i < output.length; ++ i)
                System.out.print(output[i] + " ");
            System.out.print("\n");
        }

        System.out.print("Result for solution2:\n");
        getKLeastNumbers2(copy, output, k);
        if(output != null) {
            for(int i = 0; i < output.length; ++ i)
                System.out.print(output[i] + " ");
            System.out.print("\n");
        }
        System.out.print("\n\n");
    }

    public static void test1() {
        int data[] = {4, 5, 1, 6, 2, 7, 3, 8};
        int expected[] = {1, 2, 3, 4};
        test("Test1", data, expected, expected.length);
    }
    public static void test2() {
        int data[] = {4, 5, 1, 6, 2, 7, 3, 8};
        int expected[] = {1, 2, 3, 4, 5, 6, 7, 8};
        test("Test2", data, expected, expected.length);
    }
    public static void test3() {
        int data[] = {4, 5, 1, 6, 2, 7, 3, 8};
        int[] expected = null;
        test("Test3", data, expected, 10);
    }
    public static void test4() {
        int data[] = {4, 5, 1, 6, 2, 7, 3, 8};
        int expected[] = {1};
        test("Test4", data, expected, expected.length);
    }
    public static void test5() {
        int data[] = {4, 5, 1, 6, 2, 7, 3, 8};
        int expected[] = null;
        test("Test5", data, expected, 0);
    }

    //有重复数据
    public static void test6() {
        int data[] = {4, 5, 1, 6, 2, 7, 2, 8};
        int expected[] = {1, 2, 2};
        test("Test6", data, expected, expected.length);
    }
    public static void test7() {
        test("Test7", null, null, 0);
    }
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
    }
}
