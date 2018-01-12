package control;

public class VampireNumbers {
    public static void main(String[] args) {
        char[] chars=new char[4];
        firstLoop:
        for (int i=1260;i<9999;i++) {
            chars = Integer.toString(i).toCharArray();
            for (int j=1;j<=3;j++) {
                int first = (chars[0]-'0')*10+chars[j]-'0';
                int first2 = (chars[j]-'0')*10+chars[0]-'0';
                for (int k=1;k<=3;k++) {
                    if (k==j)
                        continue;
                    int second = (chars[k]-'0') * 10;
                    for (int l=1;l<=3;l++) {
                        if (l==j || l==k)
                            continue;
                        second += chars[l]-'0';
                        if (first*second==i) {
                            System.out.println( i + "=" + first + "*" + second);
                            continue firstLoop;
                        }
                        if (first2*second==i) {
                            System.out.println( i + "=" + first + "*" + second);
                            continue firstLoop;
                        }
                    }
                }
            }
        }
    }
}
