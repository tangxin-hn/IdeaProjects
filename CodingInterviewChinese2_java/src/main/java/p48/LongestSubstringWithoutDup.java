package p48;

public class LongestSubstringWithoutDup {
    public static int longestSubstringWithoutDuplication(String str) {
        int curLen = 0;
        int maxLen = 0;
        int[] pos = new int[26];
        for (int i=0;i<26;i++)
            pos[i] = -1;

        for (int i=0;i<str.length();i++) {
            int preIndex = pos[str.charAt(i)-'a'];
            if (preIndex==-1 || i-preIndex>curLen) {
                curLen++;
            } else {
                if (curLen>maxLen)
                    maxLen = curLen;
                curLen = i - preIndex;
            }
            pos[str.charAt(i)-'a'] = i;
        }
        if (curLen>maxLen)
            maxLen = curLen;
        return maxLen;
    }
    public static void main(String[] args) {
        System.out.print(longestSubstringWithoutDuplication(""));
    }
}
