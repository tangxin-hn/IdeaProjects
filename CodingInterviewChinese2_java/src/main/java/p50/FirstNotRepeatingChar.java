package p50;

public class FirstNotRepeatingChar {
    public static char firstNotRepeatingChar(String str) {
        if (str==null)
            return '\0';
        int[] counts = new int[256];
        for (int i=0;i<str.length();i++) {
            counts[str.charAt(i)]++;
        }
        for (int i=0;i<str.length();i++) {
            if (counts[i]==1)
                return (char)i;
        }
        return '\0';
    }
}
