package c2;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigNumber {
    public enum Money {
        ONE(1),FIVE(5),TEN(10),FIFTY(50),ONE_HUNDRED(100);

        private final int value;

        // 构造器默认也只能是private, 从而保证构造函数只能在内部使用
        Money(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
    public static void main(String... args) {
        Money money = Money.ONE;
        System.out.println(money);
        System.out.println(money.getValue());


        for (String s:args) {
            System.out.println(s);
        }
        BigInteger bigInteger = new BigInteger("11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
        BigDecimal bigDecimal = new BigDecimal("0.00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
        bigDecimal = bigDecimal.multiply(bigDecimal);
        bigInteger = bigInteger.multiply(bigInteger);
        System.out.println(bigDecimal);
        System.out.println(bigInteger);
    }
}
