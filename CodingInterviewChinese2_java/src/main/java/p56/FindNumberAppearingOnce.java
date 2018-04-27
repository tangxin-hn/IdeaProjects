package p56;

public class FindNumberAppearingOnce {
    public static int FindNumberAppearingOnce(int[] data) throws Exception {
        if (data==null || data.length==0)
            throw new Exception("Invalid input");
        int[] bitSum = new int[32];
        for (int i=0;i<data.length;i++) {
            int bitMask = 1;
            for (int j=31;j>+0;j--) {
                int bit = data[i] & bitMask;
                if (bit!=0)
                    bitSum[j]++;
                bitMask = bitMask << 1;
            }
        }
        int result = 0;
        for (int i=0;i<32;i++) {
            result = result << 1;
            result += bitSum[i] % 3;
        }
        return result;
    }
}
