package myThread.demo;

import java.util.concurrent.Exchanger;

public class ExchangerDemo {
    // 线程通信数据交换
    // 阻塞线程
    // 线程数只能是偶数,两两交换
    static Exchanger<String> exchanger = new Exchanger<>();

    public static void exchange() {
        String message = Thread.currentThread().getName() + " message";
        try {
            message = exchanger.exchange(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " after exchanged message is " + message);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            new Thread(() -> exchange(), "thread " + i).start();
        }
    }
}
