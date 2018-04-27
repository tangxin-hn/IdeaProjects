package p10;

public class Fibonacci {
    public static long fibonacciSolution1(int n) {
        if (n<=0)
            return 0;
        if (n==1)
            return 1;
        long f1 = 0, f2 = 1;
        for (int i=0;i<n-1;i++) {
            long temp = f1 + f2;
            f1 = f2;
            f2 = temp;
        }
        return f2;
    }
    public static long fibonacciSolution2(int n) {
        if (n<=0)
            return 0;
        if (n==1)
            return 1;
        return fibonacciSolution2(n-1) + fibonacciSolution2(n-2);
    }
}
