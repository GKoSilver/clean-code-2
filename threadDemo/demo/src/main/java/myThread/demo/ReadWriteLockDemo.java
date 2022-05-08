package myThread.demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {

    private static Lock lock = new ReentrantLock();

    static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    static Lock readLock = readWriteLock.readLock();
    static Lock writeLock = readWriteLock.writeLock();

    public static void read(Lock lock) {
        try {
            lock.lock();
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " read over");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void write(Lock lock) {
        try {
            lock.lock();
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " write over");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        // 排它锁
        // Runnable readR = () -> read(lock);
        // Runnable writeR = () -> write(lock);

        // 读写锁
        Runnable readR = () -> read(readLock);
        Runnable writeR = () -> write(writeLock);

        for (int i = 0; i < 18; i++) {
            new Thread(readR, "read thread " + i).start();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(writeR, "write thread " + i).start();
        }

    }

}