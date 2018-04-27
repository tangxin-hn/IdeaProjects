package p13;

public class RobotMove {
    public static int movingCount(int threshold,int rows,int cols) {
        if (threshold<0 || rows<=0 || cols<=0)
            return 0;
        boolean[][] visited = new boolean[rows][cols];
        return movingCountCore(threshold,rows,cols,0,0,visited);
    }
    private static int movingCountCore(int threshold,int rows, int cols,int row,int col,boolean[][] visited) {
        if (row>=0 && row<rows && col>=0 && col<cols && !visited[row][col] && check(row,col,threshold)) {
            visited[row][col] = true;
            return 1 + movingCountCore(threshold,rows,cols,row+1,col,visited) +
                    movingCountCore(threshold,rows,cols,row-1,col,visited) +
                    movingCountCore(threshold,rows,cols,row,col+1,visited) +
                    movingCountCore(threshold,rows,cols,row,col-1,visited);
        }
        return 0;
    }
    private static boolean check(int row,int col,int threshold) {
        int sum = 0;
        while (col>0) {
            sum += col%10;
            col /=10;
        }
        while (row>0) {
            sum += row%10;
            row /=10;
        }
        return sum<=threshold;
    }

    // ====================测试代码====================
    private static void test(String testName, int threshold, int rows, int cols, int expected)
    {
        if(testName != null)
            System.out.print(testName + " begins: ");

        if(movingCount(threshold, rows, cols) == expected)
            System.out.print("Passed.\n");
        else
            System.out.print("FAILED.\n");
    }

    // 方格多行多列
    private static void test1()
    {
        test("Test1", 5, 10, 10, 21);
    }

    // 方格多行多列
    private static void test2()
    {
        test("Test2", 15, 20, 20, 359);
    }

    // 方格只有一行，机器人只能到达部分方格
    private static void test3()
    {
        test("Test3", 10, 1, 100, 29);
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }
}
