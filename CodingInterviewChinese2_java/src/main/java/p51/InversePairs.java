package p51;

public class InversePairs {
    public static int inversePairs(int[] numbers) {
        if (numbers==null || numbers.length<=1)
            return 0;
        int start = 0;
        int end = numbers.length-1;
        int[] copy = new int[numbers.length];
        for (int i=0;i<numbers.length;i++)
            copy[i] = numbers[i];
        return inversePairsCore(numbers,copy,start,end);
    }
    public static int inversePairsCore(int[] numbers,int[] copy,int start,int end) {
        if (start==end) {
            copy[start] = numbers[start];
            return 0;
        }
        int mid = (start+end)/2;
        int left = inversePairsCore(copy,numbers,start,mid);
        int right = inversePairsCore(copy,numbers,mid+1,end);
        int i = mid;
        int j = end;
        int index = end;
        int count = 0;
        while (i>=start && j>mid) {
            if (numbers[i]>numbers[j]) {
                count += (j - mid);
                copy[index--] = numbers[i--];
            } else {
                copy[index--] = numbers[j--];
            }
        }
        while (i>=start)
            copy[index--] = numbers[i--];
        while (j>mid)
            copy[index--] = numbers[j--];
        return left + right + count;
    }
    public static void main(String[] args) {
        int[] numbers = { 1, 2, 1, 2, 1 };
        System.out.println(inversePairs(numbers));
    }
}
