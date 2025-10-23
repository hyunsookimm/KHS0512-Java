package day02;

import java.util.Scanner;

public class Ex23_Break {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//무한루프
		// : 반드시 종료조건을 추가해주어야한다.
		while(true) {
			System.out.print("입력 : ");
			String input = sc.nextLine();
			if( input.equals("STOP") )
				break;
			System.out.println(">>" + input);
		}
		System.out.println("프로그램을 종료합니다.");
		sc.close();
	}

}
