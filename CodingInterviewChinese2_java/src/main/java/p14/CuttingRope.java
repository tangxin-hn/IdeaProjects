package p14;

public class CuttingRope {
    // ====================动态规划====================
    int maxProductAfterCutting_solution1(int length) {
        if (length<2)
            return 0;
        if (length==2)
            return 1;
        if (length==3)
            return 2;

        int[] product = new int[length+1];
        product[0] = 0;
        product[1] = 0;
        product[2] = 1;
        product[3] = 2;
        for (int i=4;i<=length;i++) {
            for (int j=1;j<=i/2;j++) {
                if (product[j]*product[i-j]>product[i])
                    product[j] = product[j]*product[i-j];
            }
        }
        return product[length];
    }

    // ====================贪婪算法====================
    int maxProductAfterCutting_solution2(int length) {
        if (length<2)
            return 0;
        if (length==2)
            return 1;
        if (length==3)
            return 2;
        int numberOf3 = length/3;
        if (length%3==1)
            numberOf3--;
        int numberOf2 = (length - numberOf3*3)/2;
        return (int)(Math.pow(3,numberOf3)*Math.pow(2,numberOf2));
    }
}
