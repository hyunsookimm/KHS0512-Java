package day17.Thread.Ex07_Sync;

class Bank {
	private int money = 10000;

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	// 입금 (* 메소드에 synchronized 적용)
	public void saveMoney(int save) {
		// * synchronized 블록
		// : synchronized(공유자원) { }
		synchronized (this) {
			int m = this.getMoney();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			setMoney(m + save);
		}
	}

	// 출금 (* 메소드에 synchronized 적용)
	public void minusMoney(int minus) {
		synchronized (this) {
			int m = this.getMoney();
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			setMoney(m - minus);
		}
	}
}

class Pereson1 extends Thread {

	@Override
	public void run() {
		System.out.println("사람1은 3000원을 입금합니다.");
		SyncTest.myBank.saveMoney(3000);
		System.out.println("잔액 : " + SyncTest.myBank.getMoney());
	}

}

class Person2 extends Thread {

	@Override
	public void run() {
		System.out.println("사람2는 1000원을 출금합니다.");
		SyncTest.myBank.minusMoney(1000);
		System.out.println("잔액 : " + SyncTest.myBank.getMoney());
	}

}

public class SyncTest {

	public static Bank myBank = new Bank();

	public static void main(String[] args) throws InterruptedException {
		Pereson1 person1 = new Pereson1();
		person1.start(); // money : 10000

		Thread.sleep(200);

		Person2 person2 = new Person2();
		person2.start(); // money : 10000
							// money(0.2초) : 9000

		// money(3초) : 13000
		System.out.println(SyncTest.myBank.getMoney());

	}
}
