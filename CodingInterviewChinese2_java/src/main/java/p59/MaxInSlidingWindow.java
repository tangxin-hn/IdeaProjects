package p59;

import java.util.LinkedList;
import java.util.List;

public class MaxInSlidingWindow {
    public static int[] maxInWindows(int[] data,int size) {
        if (data==null || data.length<size)
            return null;
        int[] result = new int[data.length - size + 1];
        List<Integer> list = new LinkedList<>();
        for (int i=0;i<size;i++) {
            while (!list.isEmpty() && data[i]>data[list.get(list.size()-1)])
                list.remove(list.size()-1);
            list.add(i);
        }
        for (int i=size;i<data.length;i++) {
            result[i-size] = data[list.get(0)];
            while (!list.isEmpty() && data[i]>data[list.get(list.size()-1)])
                list.remove(list.size()-1);
            if (!list.isEmpty() && list.get(0)<=i-size)
                list.remove(0);
            list.add(i);
        }
        result[result.length-1] = data[list.get(0)];
        return result;
    }
    public static void main(String[] args) {
        int[] data = {2,3,4,2,6,2,5,1};
        int size = 3;
        int[] result = maxInWindows(data,3);
        for (int i=0;i<result.length;i++)
            System.out.print(result[i] + " ");
        System.out.println();
    }
}
