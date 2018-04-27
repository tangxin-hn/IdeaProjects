package p46;

public class TranslateNumbersToStrings {
    public static int getTranslationCount(int number) {
        if (number<0)
            return 0;
        String string = number + "";
        return getTranslationCount(string);
    }
    public static int getTranslationCount(String string) {
        int[] counts = new int[string.length()+1];
        counts[string.length()-1] = 1;
        counts[string.length()] = 1;
        for (int i=string.length()-2;i>=0;i--) {
            int n = (string.charAt(i)-'0')*10+(string.charAt(i+1)-'0');
            if (n>=10 && n<26)
                counts[i] += counts[i+2];
            counts[i] += counts[i+1];
        }
        return counts[0];
    }
    public static void main(String[] args) {
        System.out.print(getTranslationCount(-100));
    }
}
