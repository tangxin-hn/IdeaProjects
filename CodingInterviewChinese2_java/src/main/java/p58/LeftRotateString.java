package p58;

public class LeftRotateString {
    public static void leftRotateString(char[] data,int n) {
        if (data == null || data.length <= n || data.length < 1 || n < 1)
            return;
        ReverseWordsInSentence.reverse(data,0,data.length-1);
        ReverseWordsInSentence.reverse(data,data.length-n,data.length);
        ReverseWordsInSentence.reverse(data,0,data.length-n-1);
    }
    public static void main(String[] args) {
        char[] data = "abcdefg".toCharArray();
        int n = 7;
        leftRotateString(data,n);
        System.out.println(new String(data));
    }
}
