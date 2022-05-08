package myThread.demo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                if (i == 5) {
                    // thread指定线程锁定(阻塞)
                    LockSupport.park();
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("sub thread after " + (i + 1) + " seconds");
            }
        });
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("mian thread after 10 seconds");
        // thread指定线程解锁
        // unpark可以在pack前调用,使后续的park失效
        LockSupport.unpark(thread);
    }

}
