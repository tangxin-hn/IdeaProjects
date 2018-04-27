package p66;

public class ConstuctArray {
    public static void BuildProductionArray(double[] input,double[] output) {
        if (input==null || output==null || input.length!=output.length || input.length<=1)
            return;
        output[0] = 1;
        for (int i=1;i<input.length;i++) {
            output[i] = output[i-1] * input[i-1];
        }
        double temp = 1;
        for (int i=input.length-2;i>=0;i--) {
            temp *= input[i+1];
            output[i] *= temp;
        }
    }
}
