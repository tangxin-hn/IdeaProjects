package p29;

public class PrintMatrix {
    public static void printMatrixClockwisely(int[][] matric) {
        if (matric==null || matric.length==0 || matric[0].length==0)
            return;
        int start=0;
        while (start*2<matric.length && start*2<matric[0].length) {
            printMatrixInCircle(matric, start);
            ++start;
        }
    }
    public static void printMatrixInCircle(int[][] matric, int start) {
        for (int i=start;i<matric[0].length-start;i++)
            System.out.println(matric[start][i]);
        for (int i=start+1;i<matric.length-start;i++) {
            System.out.println(matric[i][matric[0].length-start-1]);
        }
        if (start==matric.length-start-1)
            return;
        for (int i=matric[0].length-start-2;i>=start;i--) {
            System.out.println(matric[matric.length-start-1][i]);
        }
        for (int i=matric.length-start-2;i>start;i--) {
            System.out.println(matric[i][start]);
        }
    }
}
