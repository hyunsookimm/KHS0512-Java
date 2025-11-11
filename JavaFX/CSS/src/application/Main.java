package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;



public class Main extends Application {
	
	private static Scene scene;
	public static Stage stage;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			// 방법1 - Scene에 CSS 지정
//			BorderPane root = new BorderPane();
//			Scene scene = new Scene(root,400,400);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//			primaryStage.setScene(scene);
//			primaryStage.show();
			
			// 방법 2- FXML 에 CSS 지정
			stage = primaryStage;
			// Main.fxml 화면 파일을 로드
			Parent container = loadFXML("Main");
			// Main.fxml 화면 레이아웃을 지정하여 Scene 생성
			scene = new Scene(container);
			// Stage 에 Scene 등록
			stage.setScene(scene);
			// Stage 출력
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Scene 에 FXML 로 불러온 컨테이너를 지정하는 메소드
	 * @param fxml
	 * @throws Exception 
	 */
	public static void setRoot(String fxml) throws Exception {
		scene.setRoot( loadFXML(fxml) );
		Main.stage.sizeToScene();	// FXML 에 지정한 크기로 윈도우 크기 변경
	}
	
	/**
	 * FXML 파일을 불러오는 메소드
	 * @param fxml
	 * @return
	 * @throws Exception
	 */
	public static Parent loadFXML(String fxml) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
		return fxmlLoader.load();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
