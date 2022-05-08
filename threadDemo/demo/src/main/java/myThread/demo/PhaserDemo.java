package myThread.demo;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class PhaserDemo {

    static MyPhaser phaser = new MyPhaser();

    static void millisleep(int milli) {
        try {
            TimeUnit.MILLISECONDS.sleep(milli);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class MyPhaser extends Phaser {
        @Override
        protected boolean onAdvance(int phase, int registeredParties) {
            switch (phase) {
                case 0: {
                    System.out.println(registeredParties + " method0 end");
                    System.out.println();
                    return false;
                }
                case 1: {
                    System.out.println(registeredParties + " method1 end");
                    System.out.println();
                    return false;
                }
                case 2: {
                    System.out.println(registeredParties + " method2 end");
                    System.out.println();
                    return false;
                }
                case 3: {
                    System.out.println(registeredParties + " method3 end");
                    System.out.println();
                    return true;
                }
                default:
                    return true;
            }
        }
    }

    static class Person implements Runnable {
        String name = "";

        public Person(String name) {
            this.name = name;
        }

        public void method0() {
            millisleep(1000);
            System.out.println(name + " into method0");
            phaser.arriveAndAwaitAdvance();
        }

        public void method1() {
            millisleep(1000);
            System.out.println(name + " into method1");
            phaser.arriveAndAwaitAdvance();
        }

        public void method2() {
            millisleep(1000);
            System.out.println(name + " into method2");
            phaser.arriveAndAwaitAdvance();
        }

        private void method3() {
            if (name.equals("P1") || name.equals("P2")) {
                millisleep(1000);
                System.out.println(name + " into method3");
                phaser.arriveAndAwaitAdvance();
            } else {
                // 线程不参与
                phaser.arriveAndDeregister();
            }
        }

        @Override
        public void run() {
            method0();
            method1();
            method2();
            method3();
        }
    }

    public static void main(String[] args) {
        phaser.bulkRegister(8);
        for (int i = 0; i < 8; i++) {
            new Thread(new Person("P" + i)).start();
        }
    }
}
