package day09.Compare.Comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
class Item {
	
	String code;		// 상품코드
	String name;		// 상품명
	int price;			// 가격
	
}

public class ComparatorEx2 {
	
	public static void main(String[] args) {
		List<Item> itemList = Arrays.asList(
			new Item("PRD001", "과자", 4000),	
			new Item("PRD002", "바지", 40000),	
			new Item("PRD003", "패딩", 100000),	
			new Item("PRD004", "셔츠", 15000),	
			new Item("PRD005", "우유", 4000),	
			new Item("PRD006", "젤리", 4000)	
		);
		
		// 정렬 전
		System.out.println("정렬 전");
		for (Item item : itemList) {
			System.out.println(item);
		}
		System.out.println();
		
		// 정렬
		// * 익명 구현 객체로 비교기준 정의
		Collections.sort( itemList, new Comparator<Item>() {

			@Override
			public int compare(Item o1, Item o2) {
				int price1 = o1.getPrice();
				int price2 = o2.getPrice();
				String name1 = o1.getName();
				String name2 = o2.getName();
				
				int result1 = price2 - price1;			// 가격순 ↓
				int result2 = name1.compareTo(name2);	// 이름순 ↑
				return result1 == 0 ? result2 : result1;
			}
			
		});
		
		// 정렬 후
		System.out.println("정렬 후");
		for (Item item : itemList) {
			System.out.println(item);
		}
		System.out.println();
		
	}
}











