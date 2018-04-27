package p58;

public class ReverseWordsInSentence {
    public static void reverseSentence(char[] data) {
        if (data == null || data.length <= 1)
            return;
        int start = 0;
        int end = data.length-1;
        reverse(data,start,end);
        end = start;
        while (start<data.length) {
            while (end<data.length && data[end] != ' ')
                end++;
            reverse(data,start,end-1);
            end++;
            start = end;
        }

    }
    public static void reverse(char[] data,int start,int end) {
        if (data == null || start < 0 || end > data.length - 1)
            return;
        while (start < end) {
            char temp = data[start];
            data[start] = data[end];
            data[end] = temp;
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        char[] data = "".toCharArray();
        reverseSentence(data);
        System.out.println(new String(data));
    }
}
