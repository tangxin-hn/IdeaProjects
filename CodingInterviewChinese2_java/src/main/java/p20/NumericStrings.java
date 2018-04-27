package p20;

public class NumericStrings {
    public static boolean isNumeric(String str) {
        if (str==null || str.length()==0)
            return false;
        StringBuilder stringBuilder = new StringBuilder(str);
        boolean numeric = scanInteger(stringBuilder);
        if (stringBuilder.length()!=0 && stringBuilder.charAt(0)=='.') {
            stringBuilder.deleteCharAt(0);
            numeric = scanUnsignedInteger(stringBuilder) || numeric;
        }
        if (stringBuilder.length()!=0 && (stringBuilder.charAt(0)=='e' || stringBuilder.charAt(0)=='E')) {
            stringBuilder.deleteCharAt(0);
            numeric = scanInteger(stringBuilder) &&  numeric;
        }
        return (stringBuilder.length()==0) && numeric;
    }
    private static boolean scanInteger(StringBuilder stringBuilder) {
        if (stringBuilder.length()==0)
            return false;
        if (stringBuilder.charAt(0)=='+' || stringBuilder.charAt(0)=='-') {
            stringBuilder.deleteCharAt(0);
        }
        return scanUnsignedInteger(stringBuilder);
    }
    private static boolean scanUnsignedInteger(StringBuilder stringBuilder) {
        if (stringBuilder.length()==0)
            return false;
        boolean flag = false;
        while (stringBuilder.length()!=0 && stringBuilder.charAt(0)>='0' && stringBuilder.charAt(0)<='9') {
            flag = true;
            stringBuilder.deleteCharAt(0);
        }
        return flag;
    }

    public static void test(String testName, String str, boolean expected)
    {
        if(testName != null)
            System.out.print(testName + " begins: ");

        if(isNumeric(str) == expected)
            System.out.println("Passed.");
        else
            System.out.println("FAILED.---------------------------------");
    }


    public static void main(String[] args) {
        test("test1", "100", true);
        test("test2", "123.45e+6", true);
        test("test3", "+500", true);
        test("test4", "5e2", true);
        test("test5", "3.1416", true);
        test("test6", "600.", true);
        test("test7", "-.123", true);
        test("test8", "-1E-16", true);
        test("test9", "1.79769313486232E+308", true);

        System.out.println("\n\n");

        test("test10", "12e", false);
        test("test11", "1a3.14", false);
        test("test12", "1+23", false);
        test("test13", "1.2.3", false);
        test("test14", "+-5", false);
        test("test15", "12e+5.4", false);
        test("test16", ".", false);
        test("test17", ".e1", false);
        test("test18", "e1", false);
        test("test19", "+.", false);
        test("test20", "", false);
        test("test21", null, false);

    }
}
