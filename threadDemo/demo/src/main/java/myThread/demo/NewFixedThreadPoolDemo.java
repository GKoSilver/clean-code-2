package myThread.demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class NewFixedThreadPoolDemo {
    public static void main(String[] args) {
        // 定长线程池
        // 不推荐使用Executors创建,控制力度低,要自己创建
        // ExecutorService executorService = Executors.newFixedThreadPool(1);
        // 手动创建线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2, // 核心线程数
                4, // 最大线程数
                10, // 最大空闲时间
                TimeUnit.MILLISECONDS, // 时间单位
                new ArrayBlockingQueue<>(2), // 阻塞队列
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread thread = new Thread(r);
                        thread.setName("thread");
                        return thread;
                    }
                }, // 线程工厂
                new ThreadPoolExecutor.AbortPolicy() // 拒绝策略
        );

        executor.execute(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
            }
        });
    }

}
