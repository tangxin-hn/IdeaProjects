package p64;

public class Accumulate {
    public static int Sum(int n) {
        Temp.reset();
        Temp[] t = new Temp[n];
        return Temp.getSum();
    }
}
class Temp {
    private static int N;
    private static int sum;
    public Temp() {
        N++;
        sum += N;
    }
    public static int getSum() {
        return sum;
    }
    public static void reset() {
        N = 0;
        sum = 0;
    }
}
