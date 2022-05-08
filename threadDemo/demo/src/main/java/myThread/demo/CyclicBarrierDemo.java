package myThread.demo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    // 线程数达到parties,执行Runnable barrierAction
    static CyclicBarrier barrier = new CyclicBarrier(5, new Runnable() {
        @Override
        public void run() {
            System.out.println("=== threshold 5 reached ===");
        }
    });

    public static void method() {
        try {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " start");
            barrier.await();
            System.out.println(threadName + " end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 15; i++) {
            new Thread(CyclicBarrierDemo::method, "thread " + i).start();
        }

    }

}
