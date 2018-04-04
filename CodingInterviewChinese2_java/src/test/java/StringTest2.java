public class StringTest2 {
    public static void main(String[] args) {
        String str="中国A我";
        byte[] b = str.getBytes();
        for (byte t : b )
            System.out.print(t+" ");
        System.out.println();
        new StringTest2().A(str,10);
    }
    public void A(String str,int i) {
        byte[] b = new byte[1024];
        int num = 0;
        b = str.getBytes();
        if (b[i-1]>0) {
            System.out.println(new String(b,0,i));
        } else {
            for (int j=0;j<i;j++) {
                if (b[j]<0) {
                    num++;
                    num = num%3;
                } else {
                    num = 0;
                }
            }
            System.out.println(new String(b,0,i-num));
            /*
            if (num==0) {
                System.out.println(new String(b,0,i));
            } else {
                System.out.println(new String(b,0,i-1));
            }*/
        }
    }
}
