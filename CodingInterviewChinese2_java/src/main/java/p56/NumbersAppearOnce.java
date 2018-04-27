package p56;

public class NumbersAppearOnce {
    public static void getNumbersAppearOnce(int[] data,int[] result) {
        if (data == null || data.length == 0)
            return;
        int sum = 0;
        for (int i=0;i<data.length;i++) {
            sum ^= data[i];
        }
        int pos = findFirstBitIs1(sum);

        result[0] = 0;
        result[1] = 0;
        for (int i=0;i<data.length;i++) {
            if (IsBit1(data[i],pos))
                result[0] ^= data[i];
            else
                result[1] ^= data[i];
        }
    }
    public static int findFirstBitIs1(int num) {
        int index = 0;
        while (((num & 1) == 0) && (index<32)) {
            index++;
            num = num >> 1;
        }
        return index;
    }
    public static boolean IsBit1(int num, int index){
        num = num >> index;
        return (num & 1) == 1;
    }
}
