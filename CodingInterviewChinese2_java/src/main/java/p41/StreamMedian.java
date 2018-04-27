package p41;

import java.util.ArrayList;
import java.util.List;

public class StreamMedian {
    private List<Integer> list;
    public StreamMedian(){
        list = new ArrayList<>();
    }
    public void insert(int val) {
        if (list.size()==0)
            list.add(val);
        else {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i)>val) {
                    list.add(i, val);
                    return;
                }
            }
            list.add(val);
        }
    }
    public double getMedian() throws Exception{
        if (list==null)
            throw new Exception("empty");
        if ((list.size()&1)==1)
            return list.get(list.size()/2);
        else
            return ((double)list.get(list.size()/2) + (double)list.get(list.size()/2-1))/2;
    }

    // ====================测试代码====================
    public static void test(String testName, StreamMedian numbers, double expected) throws Exception{
        if(testName != null)
            System.out.println(testName + " begins: ");

        if(Math.abs(numbers.getMedian() - expected) < 0.0000001)
            System.out.print("Passed.\n");
        else
            System.out.print("FAILED.-------------------\n");
    }

    public static void main(String[] args) throws Exception {
        StreamMedian numbers = new StreamMedian();

        System.out.print("test1 begins: ");
        try {
            numbers.getMedian();
            System.out.print("FAILED.\n");
        } catch(Exception e) {
            System.out.print("Passed.\n");
        }

        numbers.insert(5);
        test("test2", numbers, 5);

        numbers.insert(2);
        test("test3", numbers, 3.5);

        numbers.insert(3);
        test("test4", numbers, 3);

        numbers.insert(4);
        test("test6", numbers, 3.5);

        numbers.insert(1);
        test("test5", numbers, 3);

        numbers.insert(6);
        test("test7", numbers, 3.5);

        numbers.insert(7);
        test("test8", numbers, 4);

        numbers.insert(0);
        test("test9", numbers, 3.5);

        numbers.insert(8);
        test("test10", numbers, 4);

    }
}
