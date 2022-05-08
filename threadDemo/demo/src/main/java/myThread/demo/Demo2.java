package myThread.demo;

public class Demo2 implements Runnable {

	private /* volatile */ int count = 100;

	public static void main(String[] args) {
		Demo2 demo = new Demo2();
		for (int i = 0; i < 100; i++) {
			new Thread(demo, "Thread" + i).start();
		}
	}

	@Override
	public /* synchronized */ void run() {
		count--;
		System.out.println(Thread.currentThread().getName() + " count = " + count);
	}
}
