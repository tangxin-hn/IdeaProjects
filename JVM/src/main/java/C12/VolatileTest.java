package C12;

/**
 * volatile变量自增运算测试
 *
 * @author zzm
 */
public class VolatileTest {

    public static volatile int race = 0;

    public static void increase() {
        race++;
        //System.out.println(race);
    }

    private static final int THREADS_COUNT = 20;

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        increase();
                    }
                }
            });
            System.out.println(Thread.activeCount());
            threads[i].start();
            //System.out.println(Thread.activeCount());
        }

        // 等待所有累加线程都结束
        while (Thread.activeCount() > 2) {
            //System.out.println(race);
            //System.out.println(Thread.activeCount());
            Thread.yield();
        }

        System.out.println(race);
    }
}


