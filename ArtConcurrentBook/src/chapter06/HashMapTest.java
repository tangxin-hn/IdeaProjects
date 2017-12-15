package chapter06;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class HashMapTest {
    public AtomicInteger count=new AtomicInteger();
    public static void main(String[] args) {
        HashMapTest test = new HashMapTest();
        test.Test();
        try {
        Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(test.count);
    }
    public void Test(){
        final HashMap<String,String> map = new HashMap<String, String>(2);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10000;i++) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            count.getAndIncrement();
                            System.out.println(Thread.currentThread().getName());
                            map.put(UUID.randomUUID().toString(),"");
                        }
                    },"ftf"+i).start();
                }
            }
        },"ftf");
        t.start();
        try{
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
