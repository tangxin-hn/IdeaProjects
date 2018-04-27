package p67;

public class StringToInt {
    public static int statue = 0;
    public static int strToInt(String str) {
        statue = 0;
        long num = 0;
        char[] chars = str.toCharArray();
        int start = 0;
        int end = chars.length-1;
        if (str==null || str.length()==0) {
            statue = 1;
            return 0;
        }
        boolean minus = false;
         if (chars[0]=='+') {
             start++;
          } else if (chars[0]=='-') {
             start++;
             minus = true;
         }
        if (start>end) {
            statue = 1;
            return 0;
        }
        num = strToIntCore(chars,start,end,minus);
        return (int)num;
    }
    private static long strToIntCore(char[] chars,int start,int end,boolean minus) {
        long num = 0;
        for (int i=start;i<=end;i++) {
            if (chars[i]>'9' || chars[i]<'0') {
                statue = 1;
                return 0;
            }
            num = num * 10 + chars[i] - '0';
            if ((!minus && num>Integer.MAX_VALUE) || (minus && num>-Integer.MIN_VALUE)) {
                statue = 1;
                return 0;
            }
        }
        if (minus)
            num = -num;
        return num;
    }
}
