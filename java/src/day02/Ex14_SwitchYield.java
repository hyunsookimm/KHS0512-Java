package day02;

import java.util.Scanner;

public class Ex14_SwitchYield {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : " );
		int num = sc.nextInt();
		// 입력받은 정수를 5로 나눈 나머지가
		// 2보다 작으면 "*" 출력
		// 그렇지 않으면 "**" 출력
		// - switch 문을 이용하시오.
		String result = switch (num % 5) {
		    // 반환값만 지정하는 경우, yield 를 생략하고 -> 사용 가능
		case 0, 1 -> "*";
		default -> {
			System.out.println("별 2개");
			// 블록의 실행문이 여러 줄 인경우 yield 필수
			// yield 반환값;
			yield "**";
		}
	};
	System.out.println(result);
		sc.close();
	}

}