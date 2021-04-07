package application.controller;

import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.ResourceBundle;

import org.controlsfx.control.Rating;

import application.DBConnection;
import application.dao.MenuDAO;
import application.dao.RestaurantDAO;
import application.dao.ReviewDAO;
import application.vo.MenuVO;
import application.vo.RestaurantVO;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class WriteReViewController implements Initializable {

	public static Connection conn = DBConnection.getConnection();
	
	public static String id = "";
	public static String restaurantName;
	public static String sessionNickname;
	
	@FXML
	private Button watchMenu;

	@FXML
	private ListView<String> WriteReviewListView;
	
	@FXML
	public TextArea txtAreaReview;

	private ObservableList<String> listItems;

	@FXML
	private Button btn_writecomplete;
	@FXML
	private Label menuPrint;

	@FXML
	private Rating rating;
	
	public static void setRestaurantName(String restaurantName) {
		WriteReViewController.restaurantName = restaurantName;
		System.out.println(restaurantName);
	}
	
	public static void setSessionNickname(String nn) {
		WriteReViewController.sessionNickname = nn;
		System.out.println(sessionNickname);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		WriteReviewListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		WriteReviewListView.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

				String strItem = WriteReviewListView.getSelectionModel().getSelectedItem();
				menuPrint.setText(strItem);

			}
		});
	}
	
	/*백엔드*/
	// 전체 메뉴 출력
	public void showMenuList(ActionEvent event) throws Exception {
		System.out.println("show menu");
		
		MenuDAO dao = new MenuDAO();
		ArrayList<MenuVO> list = dao.getMenuList(conn, restaurantName);
		
		String[] strArr = new String[list.size()];
		
		MenuVO data;
		
		for(int i = 0; i < list.size(); i++) {
			data = (MenuVO) list.get(i);
			strArr[i] = data.getMenuName();
		}
		
		listItems = FXCollections.observableArrayList(strArr);
		WriteReviewListView.setItems(listItems); 
	}
	
	
	// 리뷰 쓰기
	public void WriteReviewComplete(ActionEvent event) throws Exception {

		System.out.println("Write Reivew");
		
		String comment = txtAreaReview.getText();
		double score = rating.getRating();
		String menuName = WriteReviewListView.getSelectionModel().getSelectedItem();

		// 예외처리 - 댓글 내용이 비었을 떄 팝업창으로 알림
		if (comment.equals(""))
			System.out.println("내용을 작성해주세요!");

		// 예외처리 - 별점 기입이 없을 때 팝업창으로 알림
		if (score == 0)
			System.out.println("별점을 매겨주세요!");

		ReviewDAO.enrollReview(conn, comment, score, menuName, id);

		Parent root = FXMLLoader.load(getClass().getResource("/application/pages/RestaurantInformation2.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = (Stage) btn_writecomplete.getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}