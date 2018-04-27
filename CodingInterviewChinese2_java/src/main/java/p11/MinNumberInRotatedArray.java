package p11;

public class MinNumberInRotatedArray {
    public static int min(int[] number)throws Exception {
        if (number==null || number.length==0)
            throw new Exception("Invalid parameters");
        int start = 0, end = number.length - 1;
        int index = start;
        while (number[start]>=number[end]) {
            if (end-start==1) {
                index = end;
                break;
            }
            int mid = (start + end) / 2;
            if (number[start] == number[mid] && number[mid] == number[end])
                return minInOrder(number,start,end);
            if (number[start]<=number[mid])
                start = mid;
            if (number[end]>=number[mid])
                end = mid;
        }
        return number[index];
    }
    public static int minInOrder(int[] number,int start,int end) {
        int result = number[start];
        for (int i=start+1;i<=end;i++) {
            if (result>number[i])
                result = number[i];
        }
        return result;
    }
}
