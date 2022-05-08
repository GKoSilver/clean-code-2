package cleanCode.demo;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Demo3 {
    public static void main(String[] args) {
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);
        scheduled(executor);
        executor.shutdown();
    }

    static void scheduled(ScheduledThreadPoolExecutor executor) {
        executor.schedule(() -> {
            int n = 1 / 0;
            System.out.println(n);
        }, 10, TimeUnit.NANOSECONDS);
    }

}
