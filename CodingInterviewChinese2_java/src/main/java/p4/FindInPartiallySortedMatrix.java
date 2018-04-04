package p4;

public class FindInPartiallySortedMatrix {
    boolean Find(int[][] matrix, int number) {
        if (matrix==null)
            return false;
        int rows = matrix.length-1;
        int columns = matrix[0].length-1;
        while (columns>=0) {
            if (matrix[0][columns]>number) {
                rows--;
            } else {
                if (matrix[rows][columns]<number)
                    return false;
                int up = 0, down = rows-1;
                while (up<=down) {
                    int middle = (up+down)/2;
                    if (matrix[middle][columns]==number)
                        return true;
                    else if (matrix[middle][columns]<number)
                        up = middle+1;
                    else
                        down = middle-1;
                }
            }
        }
        return false;
    }

    boolean Find2(int[][] matrix, int number) {
        if (matrix==null)
            return false;
        int row = 0;
        int column = matrix[0].length-1;
        while (column>=0 && row<matrix.length) {
            if (matrix[row][column]==number) {
                return true;
            }else if (matrix[row][column]>number) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }
}
