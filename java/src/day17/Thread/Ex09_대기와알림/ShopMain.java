package day17.Thread.Ex09_대기와알림;

import java.util.ArrayList;

class Shop {
	// 가게의 테이블
	private ArrayList<String> tableList = new ArrayList<>();

	public Shop() {
		tableList.add("테이블 1");
		tableList.add("테이블 2");
		tableList.add("테이블 3");
		tableList.add("테이블 4");
		tableList.add("테이블 5");
	}

	// 손님 입장
	public synchronized String entry() throws InterruptedException {
		Thread t = Thread.currentThread();
		// 테이블이 없으면,
		while (tableList.size() == 0) {
			System.out.println("웨이팅 시작!");
			wait();            // 손님에게 웨이팅 안내 (남은 스레드를 Not Runnable 상태로 )
			System.out.println("웨이팅 끝!");
		}
		String table = tableList.remove(0);
		System.out.println(table + "에 손님 입장!");
		System.out.println(" - 스레드 : " + t.getName());
		return table;
	}

	// 손님 퇴장
	public synchronized void exit(String tableName) {
		Thread t = Thread.currentThread();
		System.err.println("손님 퇴장!");
		tableList.add(tableName);
		// notify();        // 웨이팅 손님들 중 임의로 한 팀에게 빈 테이블 알림 
		                    // ( 기다리던 스레레드를 Runnable 상태로)
		notifyAll();        // 모든 웨이팅 손님들에게 빈 테이블을 알림
		                    // (기다리던 모든 스레드를 Runnable 상태로) 
		System.err.println("빈 테이블 : " + tableName);
		System.err.println("- 스레드 : " + t.getName());

	}

}

class Customer extends Thread {

	@Override
	public void run() {
		try {
			String table = ShopMain.shop.entry(); // 입장
			Thread.sleep(5000);                   // 5초동안 이용
			ShopMain.shop.exit(table);            // 퇴장
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

public class ShopMain {

	public static Shop shop = new Shop();

	public static void main(String[] args) {
		Customer c1 = new Customer();
		Customer c2 = new Customer();
		Customer c3 = new Customer();
		Customer c4 = new Customer();
		Customer c5 = new Customer();
		Customer c6 = new Customer();
		Customer c7 = new Customer();
		Customer c8 = new Customer();

		c1.start();
		c2.start();
		c3.start();
		c4.start();
		c5.start();
		c6.start();
		c7.start();
		c8.start();

	}
}
