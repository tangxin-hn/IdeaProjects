package p12;

public class StringPathInMatrix {
    public static boolean hasPath(char[][] matrix,char[] str) {
        if (matrix==null || str==null || matrix.length==0 || matrix[0].length==0)
            return false;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int pathLength = 0;
        for (int i=0;i<matrix.length;i++) {
            for (int j=0;j<matrix[0].length;j++) {
                if (hasPathCore(matrix,i,j,str,pathLength,visited))
                    return true;
            }
        }
        return false;
    }
    private static boolean hasPathCore(char[][] matrix,int row,int col,char[] str,int pathLength,boolean[][] visited) {
        if (pathLength==str.length)
            return true;
        if ( row>=0 && row<matrix.length && col>=0 && col<matrix[0].length
                && matrix[row][col]==str[pathLength] && visited[row][col]==false) {
            visited[row][col] = true;
            if (hasPathCore(matrix,row+1,col,str,pathLength+1,visited)
                    || hasPathCore(matrix,row-1,col,str,pathLength+1,visited)
                    || hasPathCore(matrix,row,col+1,str,pathLength+1,visited)
                    || hasPathCore(matrix,row,col-1,str,pathLength+1,visited))
                return true;
            visited[row][col] = false;
        }
        return false;
    }

    // ====================测试代码====================
    public static void test(String testName, char[][] matrix,  char[] str, boolean expected)
    {
        if(testName != null)
            System.out.println(testName + " begins");

        if(hasPath(matrix, str) == expected)
            System.out.println("Passed.");
        else
            System.out.println("FAILED.");
    }

//ABTG
//CFCS
//JDEH

    //BFCE
    public static void test1()
    {
    char[][] matrix = {"ABTG".toCharArray(),"CFCS".toCharArray(),"JDEH".toCharArray()};
    char[] str = "BFCE".toCharArray();

        test("test1", matrix, str, true);
    }

//ABCE
//SFCS
//ADEE

    //SEE
    public static void test2()
    {
        char[][] matrix = {"ABCE".toCharArray(),"SFCS".toCharArray(),"ADEE".toCharArray()};
        char[] str = "SEE".toCharArray();

        test("test2", matrix, str, true);
    }

//ABTG
//CFCS
//JDEH

    //ABFB
    public static void test3()
    {
        char[][] matrix = {"ABTG".toCharArray(),"CFCS".toCharArray(),"JDEH".toCharArray()};
        char[] str = "ABFB".toCharArray();

        test("test3", matrix, str, false);
    }

    public static void main(String[] argc)
    {
        test1();
        test2();
        test3();
    }
}
