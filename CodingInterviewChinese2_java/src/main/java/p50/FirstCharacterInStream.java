package p50;

public class FirstCharacterInStream {
    private int[] occurrence;
    public FirstCharacterInStream() {
        occurrence = new int[256];
        for (int i=0;i<256;i++)
            occurrence[i] = -1;
    }
    public void insert(char ch) {
        if (occurrence[ch]==-1)
            occurrence[ch] = 0;
        else if (occurrence[ch]>=0)
            occurrence[ch] = -2;
    }
    public char FirstAppearingOnce() {
        char ch = '\0';
        int minIndex = Integer.MAX_VALUE;
        for (int i=0;i<256;i++) {
            if (occurrence[i]<minIndex) {
                ch = (char)i;
                minIndex = occurrence[i];
            }
        }
        return ch;
    }
}
