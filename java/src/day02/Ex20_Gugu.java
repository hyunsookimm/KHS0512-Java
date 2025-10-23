package day02;

import java.util.Scanner;

public class Ex20_Gugu {

	public static void main(String[] args) {
		// 구구단
		Scanner sc = new Scanner(System.in);
		System.out.print("입력 : ");
		int input = sc.nextInt();
		
		// 9회 반복
		// (입력 단) x (반복변수:1~9) = 결과
		for (int i = 1; i <= 9; i++) {
			System.out.println(input + "*" + i + "=" + (input*i) );
		}
		
		sc.close();
	}
	
}
