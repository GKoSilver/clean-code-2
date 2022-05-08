package myThread.demo;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    // 同时可以执行的线程数
    static Semaphore semaphore = new Semaphore(2);

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> method(), "thread " + i).start();

        }
    }

    public static void method() {
        try {
            // 信号减1
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " start ");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " over ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 信号恢复(1)
            semaphore.release();
        }
    }

}
