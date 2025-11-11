package day17.Thread.Ex02_스레드구현;

class MyRunnable implements Runnable {

	@Override
	public void run() {
	// 200번 반복하면서 현재 스레드 어떤 스레드가 CPU 점유하고 있는지 확인
			for (int i = 0; i < 200; i++) {
				// 현재 실행 중인 스레드 이름
				String threadName = Thread.currentThread().getName();
				System.out.println(i + " : " + threadName);
			}
		}
	}


public class RunnableTest {
    public static void main(String[] args) {
		System.out.println("프로그램 시작!");
		
		Thread thread1 = new Thread(new MyRunnable());
		Thread thread2 = new Thread(new MyRunnable());
		
		thread1.start();
		thread2.start();
		
		System.out.println("프로그램 종료!");
	}
}
