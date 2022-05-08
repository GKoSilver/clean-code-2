package myThread.demo;

public class Demo1 {

	public static void main(String[] args) {
		Thread t1 = new Thread(() -> {
			try {
				for (int i = 0; i < 10; i++) {
					String formatString = String.format("run t1 times %d", i);
					System.out.println(formatString);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("t1 end");

		});
		Thread t2 = new Thread(() -> {
			try {
				t1.join();
				for (int i = 0; i < 10; i++) {
					String formatString = String.format("run t2 times %d", i);
					System.out.println(formatString);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("t2 end");
		});
		Thread t3 = new Thread(() -> {
			try {
				t2.join();
				for (int i = 0; i < 10; i++) {
					String formatString = String.format("run t3 times %d", i);
					System.out.println(formatString);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("t3 end");
		});
		t3.start();
		t2.start();
		t1.start();
	}

}
