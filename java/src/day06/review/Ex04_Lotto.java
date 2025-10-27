package day06.review;

public class Ex04_Lotto {
	
	public static void main(String[] args) {
		// Math.random() : 0.0xx ~ 0.9xxx 사이의 난수를 반환하는 메소드
		double random = Math.random();
		System.out.println(random);
		
		// 1~6 사이의 정수 : 주사위
		// Math.random() * 10				: 0.xxx ~ 9.xxx
		// (int) (Math.random() * 10)		: 0 ~ 9
		// (int) (Math.random() * 6)		: 0 ~ 5
		// (int) (Math.random() * 6) + 1	: 1 ~ 6
		int dice = (int) (Math.random() * 6) + 1;
		System.out.println("주사위 : " + dice);
		
		// (공식) : (int) (Math.random() * [개수]) + [시작숫자]
		
		// 1~20 사의 랜덤수
		System.out.println("(1~20)");
		System.out.println( (int) (Math.random() * 20) + 1 );
		
		// -20~20 사의 랜덤수
		System.out.println("(-20~20)");
		System.out.println( (int) (Math.random() * 41) - 20 );
		
		// 1~45 사이의 랜덤수 6개를 배열에 저장하시오.
		int lotto[] = new int[6];
		
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = (int) (Math.random() * 45) + 1;
			// 중복제거
			for (int j = 0; j <= i-1; j++) {
				// 중복
				if( lotto[i] == lotto[j] ) {
					i--;
					break;
				}
			}
		}
		
		// 오름차순 정렬
		for (int i = 0; i < lotto.length - 1; i++) {
			for (int j = i+1; j < lotto.length; j++) {
				if( lotto[i] > lotto[j] ) {
					// 교환
					int temp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = temp;
				}
			}
		}
		
		System.out.println("## 로또 번호 ##");
		for (int i : lotto) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

}








