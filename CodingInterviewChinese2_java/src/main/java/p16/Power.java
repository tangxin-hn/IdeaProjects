package p16;

public class Power {
    public static double power(double base, int exponent) throws Exception{
        if (Double.doubleToLongBits(base)==Double.doubleToLongBits(0.0)) {
            if (exponent<0)
                throw new Exception("invalid input");
            return 0;
        }
        boolean flag = false;
        if (exponent<0) {
            flag = true;
            exponent = 0 - exponent;
        }
        double result = recursion(base, exponent);
        if (flag)
            result = 1/result;
        return result;
    }
    private static double recursion(double base, int exponent) {
        if (exponent==0)
            return 1;
        if (exponent==1)
            return base;
        double result = 1;
        if ((exponent & 1) == 1){
            result = base;
        }
        return result * recursion(base,exponent>>1);
    }
}
