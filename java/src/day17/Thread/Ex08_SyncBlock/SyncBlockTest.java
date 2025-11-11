package day17.Thread.Ex08_SyncBlock;

class Bank {
	private int money = 10000;

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	// 입금 (* 메소드에 synchronized 적용)
	public synchronized void saveMoney(int save) {
		int m = this.getMoney();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		setMoney(m + save);
	}

	// 출금 (* 메소드에 synchronized 적용)
	public synchronized void minusMoney(int minus) {
		int m = this.getMoney();
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		setMoney(m - minus);
	}
}

class Pereson1 extends Thread {

	@Override
	public void run() {
		System.out.println("사람1은 3000원을 입금합니다.");
		SyncBlockTest.myBank.saveMoney(3000);
		System.out.println("잔액 : " + SyncBlockTest.myBank.getMoney());
	}

}

class Person2 extends Thread {

	@Override
	public void run() {
		System.out.println("사람2는 1000원을 출금합니다.");
		SyncBlockTest.myBank.minusMoney(1000);
		System.out.println("잔액 : " + SyncBlockTest.myBank.getMoney());
	}

}

public class SyncBlockTest {

	public static Bank myBank = new Bank();

	public static void main(String[] args) throws InterruptedException {
		Pereson1 person1 = new Pereson1();
		person1.start();    // money       : 10000

		Thread.sleep(200);

		Person2 person2 = new Person2();
		person2.start();    // money       : 10000
							// money(0.2초) : 9000

		                    // money(3초)   : 13000
		System.out.println(SyncBlockTest.myBank.getMoney());

	}
}
