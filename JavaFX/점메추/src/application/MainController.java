package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class MainController {

	@FXML
	private Button button;
	@FXML
	private ImageView img;
	@FXML
	private Label menu;

	// 메뉴 리스트
	private static List<Menu> MENU_LIST;
	// 타이머1 - 0.05 초마다 메뉴변경 타이머
	private Timeline rotate = null;
	// 타이머2 - 3초 뒤 랜덤메뉴를 고르는 타이머
	private Timeline stop = null;

	/**
	 * FXML 이 로딩될 때 초기화하는 메소드 
	 * * 데이터 초기화
	 *  * 이벤트 둥록
	 */
	@FXML
	public void initialize() {
		// 데이터 초기화
        initData();
		// 타이머 세팅
        initTimer();
	}

	/**
	 * 데이터 초기화
	 */

	void initData() {
		MENU_LIST = new ArrayList<Menu>();
		List<String> nameList = Arrays.asList("국밥", "규카츠", "김밥", "돈까스", "떡볶이", "마라탕", "부대찌개", "삼겹살", "쇼좌빙", "스테이크",
				"우동", "육회", "초밥", "치킨", "카레", "텐동", "파스타", "피자", "함박스테이크", "햄버거");
		List<String> imgList = Arrays.asList("국밥.png", "규카츠.png", "김밥.png", "돈까스.png", "떡볶이.png", "마라탕.png", "부대찌개.png",
				"삼겹살.png", "쇼좌빙.png", "스테이크.png", "우동.png", "육회.png", "초밥.png", "치킨.png", "카레.png", "텐동.png", "파스타.png",
				"피자.png", "함박스테이크.png", "햄버거.png");

		for (int i = 0; i < 20; i++) {
			String name = nameList.get(i);
			String img = imgList.get(i);
			MENU_LIST.add(new Menu(name, img));
		}
	}

	/** 
     * 타이머 세팅
     */
    public void initTimer() {
    	 //0.05초 마다 랜덤 타이머
    	rotate = new Timeline(
    			 new KeyFrame(Duration.millis(50), e -> {
    			 // 랜덤 메뉴 세팅
    			setMenu();   				 
    			 })
    	);
    	rotate.setCycleCount( Timeline.INDEFINITE );
    	
    	// 3 초 뒤에 메뉴 고르는 타이머 
    	stop = new Timeline(
    		new KeyFrame( Duration.millis(3000), e -> rotate.stop() )
    	 );
    	stop.setCycleCount(1);
    }
    
    public void setMenu() {
    	// 20개의 메뉴 요소들 중, 랜덤으로 하나 선택
    	Random random = new Random();
    	int index = random.nextInt(20);
    	Menu randomMenu = MENU_LIST.get(index);
    	String menuName = randomMenu.getMenu();
    	String menuImg = randomMenu.getImg();
    	System.out.println("menuName : " + menuName);
    	System.out.println("menuImg : " + menuImg);
    	// 메뉴명 라벨에 지정
    	menu.setText( menuName );
    	// 메뉴 이미지 지정
    	String filePath = getClass().getResource("/img/" + menuImg).toExternalForm();
    	img.setImage( new Image(filePath) );
    }

	@FXML
	void random(ActionEvent event) {
		// 이전 타이머 중지
         rotate.stop();
         stop.stop();
         
         // 타이머 시작
         rotate.play();
         stop.play();
	}

}
