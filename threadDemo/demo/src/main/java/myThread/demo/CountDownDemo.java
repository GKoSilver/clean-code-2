package myThread.demo;

import java.util.concurrent.CountDownLatch;

public class CountDownDemo {

    public static void main(String[] args) {
        Thread[] threads = new Thread[10];
        CountDownLatch latch = new CountDownLatch(10);
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName + " start");
                // latch自减
                latch.countDown();
                System.out.println(threadName + " end");
            }, "thread " + i);
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        try {
            // 等待到latch为0
            latch.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("latch over");
    }

}
