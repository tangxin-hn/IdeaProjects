package p19;

public class RegularExpressions {
    public static boolean match(char[] str, char[] pattern) {
        if (str==null || pattern==null)
            return false;
        return matchCore(str,0,pattern,0);
    }
    public static boolean matchCore(char[] str, int pos1, char[] pattern, int pos2) {
        if (str.length==pos1 && pattern.length==pos2)
            return true;
        else if (str.length!=pos1 && pattern.length==pos2)
            return false;
        if (pos2<pattern.length-1 && pattern[pos2+1]=='*') {
            if (str.length==pos1)
                return matchCore(str,pos1,pattern,pos2+2);
            if (pattern[pos2]==str[pos1] || pattern[pos2] =='.') {
                return matchCore(str,pos1+1,pattern,pos2) ||
                        matchCore(str,pos1+1,pattern,pos2+2) ||
                        matchCore(str,pos1,pattern,pos2+2);
            } else {
                return matchCore(str,pos1,pattern,pos2+2);
            }
        } else if (str.length==pos1){
            return false;
        } else if (str[pos1]==pattern[pos2] || pattern[pos2]=='.') {
            return matchCore(str,pos1+1,pattern,pos2+1);
        }
        return false;
    }
    public static void test(String testName, String string, String pattern, boolean expected)
    {
        if(testName != null)
            System.out.println(testName + " begins: ");

        if(match(string.toCharArray(), pattern.toCharArray()) == expected)
            System.out.println("Passed.");
        else
            System.out.println("FAILED.");
    }

    public static void main(String[] args) {
        test("test01", "", "", true);
        test("test02", "", ".*", true);
        test("test03", "", ".", false);
        test("test04", "", "c*", true);
        test("test05", "a", ".*", true);
        test("test06", "a", "a.", false);
        test("test07", "a", "", false);
        test("test08", "a", ".", true);
        test("test09", "a", "ab*", true);
        test("test10", "a", "ab*a", false);
        test("test11", "aa", "aa", true);
        test("test12", "aa", "a*", true);
        test("test13", "aa", ".*", true);
        test("test14", "aa", ".", false);
        test("test15", "ab", ".*", true);
        test("test16", "ab", ".*", true);
        test("test17", "aaa", "aa*", true);
        test("test18", "aaa", "aa.a", false);
        test("test19", "aaa", "a.a", true);
        test("test20", "aaa", ".a", false);
        test("test21", "aaa", "a*a", true);
        test("test22", "aaa", "ab*a", false);
        test("test23", "aaa", "ab*ac*a", true);
        test("test24", "aaa", "ab*a*c*a", true);
        test("test25", "aaa", ".*", true);
        test("test26", "aab", "c*a*b", true);
        test("test27", "aaca", "ab*a*c*a", true);
        test("test28", "aaba", "ab*a*c*a", false);
        test("test29", "bbbba", ".*a*a", true);
        test("test30", "bcbbabab", ".*a*a", false);

    }
}
