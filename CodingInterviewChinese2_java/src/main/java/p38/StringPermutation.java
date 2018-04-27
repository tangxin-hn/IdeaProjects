package p38;

public class StringPermutation {
    public static void permutation(char[] chars) {
        if (chars==null || chars.length==0)
            return;
        permutation(chars,0);
    }
    public static void permutation(char[] chars,int pos) {
        if (pos==chars.length) {
            System.out.println(chars.toString());
        } else {
            for (int i=pos;i<chars.length;i++) {
                char temp = chars[i];
                chars[i] = chars[pos];
                chars[pos] = temp;

                permutation(chars,pos+1);

                temp = chars[i];
                chars[i] = chars[pos];
                chars[pos] = temp;
            }
        }
    }
}
