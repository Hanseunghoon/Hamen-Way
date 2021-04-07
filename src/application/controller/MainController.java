package application.controller;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import application.DBConnection;
import application.Session;
import application.dao.MemberDAO;
import application.dao.MenuDAO;
import application.dao.RestaurantDAO;
import application.dao.ReviewDAO;
import application.vo.MemberVO;
import application.vo.RestaurantVO;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainController {

	public static Connection conn = DBConnection.getConnection();

	public static String res = "";

	@FXML
	public Label lblStatus1, lblStatus2, roulletResLabel;

	@FXML
	public TextField txtUserName, txtMasterUserName, txtPassword, txtMasterPassword, inputLocation, ma_menuname,
			ma_nickname, ma_id, ma_password, ma_lastname, ma_firstname, ma_age, ma_location, ma_retaurantname,
			ma_retaurantcategory;

	@FXML
	public TextArea txtAreaReview;

	@FXML
	public Text reviewTxt;

	@FXML
	public Button OwnerIntroBtn, CustomerIntroBtn, CustomerLoginBtn, CustomerSignupBtn, MasterLoginBtn, MasterSignupBtn,
			CustomerSignupNextBtn, CustomerSignupCompleteBtn, OwnerSignupCompleteBtn, roulettestop, roulletetoCommu,
			movetocommunity, BoardButtonMain2_nearby, Nearby_homebtn, btnWriteReview, btn_recommend,
			BoardButtonMain2_home, btn_nearby_recommend, recommend_homebtn, recommend_nearbybtn, ResInfo_backbtn,
			Recommend_roulbtn, roulRes_recommend, roulRes_nearby, roulRes_home, btn_writecomplete, Homebtn, NearbyBtn,
			RecommendBtn, ma_menuplus, searchLocation, rouletteplay, showResBtn, finish, searchCategory;

	@FXML
	public Label restaurantName1, restaurantName2, restaurantName3, restaurantName4, restaurantName5, restaurantName6,
			restaurantName7, restaurantName8, restaurantName9, restaurantName10;

	@FXML
	public Label restaurantLocation1, restaurantLocation2, restaurantLocation3, restaurantLocation4,
			restaurantLocation5, restaurantLocation6, restaurantLocation7, restaurantLocation8, restaurantLocation9,
			restaurantLocation10;

	@FXML
	public Label restaurantRating1, restaurantRating2, restaurantRating3, restaurantRating4, restaurantRating5,
			restaurantRating6, restaurantRating7, restaurantRating8, restaurantRating9, restaurantRating10;

	@FXML
	public ImageView rouletteimg, recommendMenuImage, foodImg, imgView1, imgView2, imgView3, imgView4, imgView5,
			imgView6, imgView7, imgView8, imgView9, imgView10;

	@FXML
	public ListView<String> ma_menuaddlistview;

	public ObservableList<String> nomes;

	@FXML
	public AnchorPane Nearbypane1, Nearbypane2, Nearbypane3, Nearbypane4, Nearbypane5, Nearbypane6, Nearbypane7,
			Nearbypane8, Nearbypane9, Nearbypane10;

	@FXML
	public AnchorPane RouletteRespane, AP, btnMenuClick;

	public void RestaurantInformation1(MouseEvent event) throws Exception {
		RestaurantInformationController.setRestaurantName(restaurantName1.getText());
		System.out.println();
		Parent root = FXMLLoader.load(getClass().getResource("/application/pages/RestaurantInformation2.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = (Stage) Nearbypane1.getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void RestaurantInformation2(MouseEvent event) throws Exception {
		RestaurantInformationController.setRestaurantName(restaurantName2.getText());
		Parent root = FXMLLoader.load(getClass().getResource("/application/pages/RestaurantInformation2.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = (Stage) Nearbypane2.getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void RestaurantInformation3(MouseEvent event) throws Exception {
		RestaurantInformationController.setRestaurantName(restaurantName3.getText());
		Parent root = FXMLLoader.load(getClass().getResource("/application/pages/RestaurantInformation2.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = (Stage) Nearbypane3.getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void RestaurantInformation4(MouseEvent event) throws Exception {
		RestaurantInformationController.setRestaurantName(restaurantName4.getText());
		Parent root = FXMLLoader.load(getClass().getResource("/application/pages/RestaurantInformation2.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = (Stage) Nearbypane4.getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void RestaurantInformation5(MouseEvent event) throws Exception {
		RestaurantInformationController.setRestaurantName(restaurantName5.getText());
		Parent root = FXMLLoader.load(getClass().getResource("/application/pages/RestaurantInformation2.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = (Stage) Nearbypane5.getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void RestaurantInformation6(MouseEvent event) throws Exception {
		RestaurantInformationController.setRestaurantName(restaurantName6.getText());
		Parent root = FXMLLoader.load(getClass().getResource("/application/pages/RestaurantInformation2.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = (Stage) Nearbypane6.getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void RestaurantInformation7(MouseEvent event) throws Exception {
		RestaurantInformationController.setRestaurantName(restaurantName7.getText());
		Parent root = FXMLLoader.load(getClass().getResource("/application/pages/RestaurantInformation2.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = (Stage) Nearbypane7.getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void RestaurantInformation8(MouseEvent event) throws Exception {
		RestaurantInformationController.setRestaurantName(restaurantName9.getText());
		Parent root = FXMLLoader.load(getClass().getResource("/application/pages/RestaurantInformation2.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = (Stage) Nearbypane8.getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void RestaurantInformation9(MouseEvent event) throws Exception {
		RestaurantInformationController.setRestaurantName(restaurantName8.getText());
		Parent root = FXMLLoader.load(getClass().getResource("/application/pages/RestaurantInformation2.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = (Stage) Nearbypane9.getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void RestaurantInformation10(MouseEvent event) throws Exception {
		RestaurantInformationController.setRestaurantName(restaurantName10.getText());
		Parent root = FXMLLoader.load(getClass().getResource("/application/pages/RestaurantInformation2.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = (Stage) Nearbypane10.getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void HomeButton(ActionEvent event) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("/application/pages/BoardButtonMain2.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = (Stage) Homebtn.getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void NearbyButton(ActionEvent event) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/application/pages/NearbyRestaurant2.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = (Stage) NearbyBtn.getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void RecommendBtn(ActionEvent event) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("/application/pages/Recommend.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = (Stage) RecommendBtn.getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	File rootpath = new File("");
	String path = rootpath.getAbsolutePath() + "/src/application/resources/main.wav";

	Media media = new Media(new File(path).toURI().toString());
	MediaPlayer mediaplayer = new MediaPlayer(media);

	public void musicstart_main(ActionEvent event) throws Exception {
		mediaplayer.play();
	}

	public void OBtn(ActionEvent event) throws Exception {
		// mediaplayer.play();
		Parent root = FXMLLoader.load(getClass().getResource("/application/pages/MasterLogin.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = (Stage) OwnerIntroBtn.getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public void CBtn(ActionEvent event) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("/application/pages/CustomerLogin.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = (Stage) CustomerIntroBtn.getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public void Login(ActionEvent event) throws Exception {
		String id = txtUserName.getText();
		String pw = txtPassword.getText();

		MemberVO data = new MemberVO();
		data.setMemberId(id);
		data.setMemberPw(pw);
		data.setOwner("N");

		if (MemberDAO.login(data)) {

			Parent root = FXMLLoader.load(getClass().getResource("/application/pages/BoardButtonMain2.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = (Stage) CustomerLoginBtn.getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.show();

		} else {
			lblStatus1.setText("잘못 입력하셨습니다.");
		}
	}

	public void MasterLogin(ActionEvent event) throws Exception {

		String id = txtMasterUserName.getText();
		String pw = txtMasterPassword.getText();

		MemberVO data = new MemberVO();
		data.setMemberId(id);
		data.setMemberPw(pw);
		data.setOwner("Y");

		if (MemberDAO.login(data)) {

			Parent root = FXMLLoader.load(getClass().getResource("/application/pages/BoardButtonMain2.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = (Stage) MasterLoginBtn.getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.show();
		} else {
			lblStatus2.setText("�젙蹂닿� �옒紐� �엯�젰�릺�뿀�뒿�땲�떎.");
		}
	}

	public void CustomerSignup(ActionEvent event) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("/application/pages/CustomerSignup.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = (Stage) CustomerSignupBtn.getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public void MasterSignup(ActionEvent event) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("/application/pages/MasterSignup.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = (Stage) MasterSignupBtn.getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public void MenuPlus(ActionEvent event) throws Exception {
		String nickname = ma_nickname.getText();
		String id = ma_id.getText();
		String pw = ma_password.getText();
		String lastname = ma_lastname.getText();
		String firstname = ma_firstname.getText();
		String age = ma_age.getText();
		String location = ma_location.getText();
		String restaurantname = ma_retaurantname.getText();
		String restaurantcategory = ma_retaurantcategory.getText();

		MemberVO data = new MemberVO();
		data.setMemberId(id);
		data.setMemberPw(pw);
		data.setMemberNickName(nickname);
		data.setOwner("Y");
		data.setMemberLastName(lastname);
		data.setMemberFirstName(firstname);
		data.setMemberAge(Integer.parseInt(age));

		if (MemberDAO.masterSignup(data, location, restaurantname, restaurantcategory)) {
			Parent root = FXMLLoader.load(getClass().getResource("/application/pages/InsertMenuListView.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = (Stage) ma_menuplus.getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.show();
		} else {
			System.out.println("다시 입력해 주세요.");
		}

	}

	File rootpath2 = new File("");
	String path2 = rootpath.getAbsolutePath() + "/src/application/resources/roulette.wav";
	Media media2 = new Media(new File(path2).toURI().toString());
	MediaPlayer mediaplayer2 = new MediaPlayer(media2);

	// animation
	public void rplay(ActionEvent event) throws Exception {

		RotateTransition rotate = new RotateTransition();
		rotate.setNode(rouletteimg);
		rotate.setDuration(Duration.millis(250));
		rotate.setCycleCount(TranslateTransition.INDEFINITE);
		rotate.setByAngle(360);
		rotate.play();

		playRoulette(event);
	}

	public void rstop(ActionEvent event) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("/application/pages/RouletteStopPopup.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = (Stage) roulettestop.getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void rtc(ActionEvent event) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("/application/pages/NearbyRestaurant2.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = (Stage) roulletetoCommu.getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void mtc(ActionEvent event) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("/application/pages/NearbyRestaurant2.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = (Stage) movetocommunity.getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void BoardButtonMain2_nearby(ActionEvent event) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("/application/pages/NearbyRestaurant2.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = (Stage) BoardButtonMain2_nearby.getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void BoardButtonMain2_recommend(ActionEvent event) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("/application/pages/Recommend.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = (Stage) btn_recommend.getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void Nearby_home(ActionEvent event) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("/application/pages/BoardButtonMain2.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = (Stage) Nearby_homebtn.getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void Nearby_recommend(ActionEvent event) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("/application/pages/Recommend.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = (Stage) btn_nearby_recommend.getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void Recommend_home(ActionEvent event) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("/application/pages/BoardButtonMain2.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = (Stage) recommend_homebtn.getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void Recommend_nearby(ActionEvent event) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("/application/pages/NearbyRestaurant2.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = (Stage) recommend_nearbybtn.getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void RoulBtn(ActionEvent event) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("/application/pages/RouletteRes.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = (Stage) Recommend_roulbtn.getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void RoulRes_recommend(ActionEvent event) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("/application/pages/Recommend.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = (Stage) roulRes_recommend.getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void RoulRes_nearby(ActionEvent event) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("/application/pages/NearbyRestaurant2.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = (Stage) roulRes_nearby.getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void RoulRes_home(ActionEvent event) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("/application/pages/BoardButtonMain2.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = (Stage) roulRes_home.getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void WriteReviewComplete(ActionEvent event) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("/application/pages/RestaurantInformation2.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = (Stage) btn_writecomplete.getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/* 백 부분 이벤트 처리 */
	// 평균 평점에 따른 식당 안전 등급을 색으로 표현
	public void setColor(Label label, double d) {

		if (d >= 4.0 && d <= 5.0) {
			label.setStyle("-fx-font-weight: bold");
			label.setStyle("-fx-text-fill: green;");
		} else if (d >= 2.0 && d < 4.0) {
			label.setStyle("-fx-font-weight: bold");
			label.setStyle("-fx-text-fill: blue;");
		} else if (d >= 0.0 && d < 2.0) {
			label.setStyle("-fx-font-weight: bold");
			label.setStyle("-fx-text-fill: red;");
		}
	}

	public static void playRoulette(ActionEvent event) {
		res = MenuDAO.rouletteplay(conn, Session.getSessionId());
		System.out.println(res);
	}

	// 카테고리에 따른 메뉴를 가진 식당 TOP 10 출력
	public void getMenuTop10(ActionEvent event) throws SQLException {

		System.out.println("해당 메뉴 top10 갖고오기");

		String tmp = inputLocation.getText();

		RestaurantDAO dao = new RestaurantDAO();
		ArrayList<RestaurantVO> list = dao.getRestaurantTop10(conn, tmp);

		RestaurantVO data = (RestaurantVO) list.get(0);
		restaurantName1.setText(data.getRestaurantName());
		restaurantLocation1.setText(data.getRestaurantLocation());
		restaurantRating1.setText(Double.toString(data.getRestaurantRating()));
		setColor(restaurantName1, data.getRestaurantRating());
		imgView1.setVisible(true);

		data = (RestaurantVO) list.get(1);
		restaurantName2.setText(data.getRestaurantName());
		restaurantLocation2.setText(data.getRestaurantLocation());
		restaurantRating2.setText(Double.toString(data.getRestaurantRating()));
		setColor(restaurantName2, data.getRestaurantRating());
		imgView2.setVisible(true);

		data = (RestaurantVO) list.get(2);
		restaurantName3.setText(data.getRestaurantName());
		restaurantLocation3.setText(data.getRestaurantLocation());
		restaurantRating3.setText(Double.toString(data.getRestaurantRating()));
		setColor(restaurantName3, data.getRestaurantRating());
		imgView3.setVisible(true);

		data = (RestaurantVO) list.get(3);
		restaurantName4.setText(data.getRestaurantName());
		restaurantLocation4.setText(data.getRestaurantLocation());
		restaurantRating4.setText(Double.toString(data.getRestaurantRating()));
		setColor(restaurantName4, data.getRestaurantRating());
		imgView4.setVisible(true);

		data = (RestaurantVO) list.get(4);
		restaurantName5.setText(data.getRestaurantName());
		restaurantLocation5.setText(data.getRestaurantLocation());
		restaurantRating5.setText(Double.toString(data.getRestaurantRating()));
		setColor(restaurantName5, data.getRestaurantRating());
		imgView5.setVisible(true);

		data = (RestaurantVO) list.get(5);
		restaurantName6.setText(data.getRestaurantName());
		restaurantLocation6.setText(data.getRestaurantLocation());
		restaurantRating6.setText(Double.toString(data.getRestaurantRating()));
		setColor(restaurantName6, data.getRestaurantRating());
		imgView6.setVisible(true);

		data = (RestaurantVO) list.get(6);
		restaurantName7.setText(data.getRestaurantName());
		restaurantLocation7.setText(data.getRestaurantLocation());
		restaurantRating7.setText(Double.toString(data.getRestaurantRating()));
		setColor(restaurantName7, data.getRestaurantRating());
		imgView7.setVisible(true);

		data = (RestaurantVO) list.get(7);
		restaurantName8.setText(data.getRestaurantName());
		restaurantLocation8.setText(data.getRestaurantLocation());
		restaurantRating8.setText(Double.toString(data.getRestaurantRating()));
		setColor(restaurantName8, data.getRestaurantRating());
		imgView8.setVisible(true);

		data = (RestaurantVO) list.get(8);
		restaurantName9.setText(data.getRestaurantName());
		restaurantLocation9.setText(data.getRestaurantLocation());
		restaurantRating9.setText(Double.toString(data.getRestaurantRating()));
		setColor(restaurantName9, data.getRestaurantRating());
		imgView9.setVisible(true);

		data = (RestaurantVO) list.get(9);
		restaurantName10.setText(data.getRestaurantName());
		restaurantLocation10.setText(data.getRestaurantLocation());
		restaurantRating10.setText(Double.toString(data.getRestaurantRating()));
		setColor(restaurantName10, data.getRestaurantRating());
		imgView10.setVisible(true);
	}

	// 위치에 따른 메뉴를 가진 식당 TOP 10 출력
	public void getMenuLoc10(ActionEvent event) throws SQLException {

		System.out.println("근처 식당 top10 갖고오기");

		String tmp = inputLocation.getText();

		System.out.println(tmp);

		RestaurantDAO dao = new RestaurantDAO();
		ArrayList<RestaurantVO> list = dao.getRestaurantLoc10(conn, tmp);

		RestaurantVO data = (RestaurantVO) list.get(0);
		restaurantName1.setText(data.getRestaurantName());
		restaurantLocation1.setText(data.getRestaurantLocation());
		restaurantRating1.setText(Double.toString(data.getRestaurantRating()));
		setColor(restaurantName1, data.getRestaurantRating());
		imgView1.setVisible(true);

		data = (RestaurantVO) list.get(1);
		restaurantName2.setText(data.getRestaurantName());
		restaurantLocation2.setText(data.getRestaurantLocation());
		restaurantRating2.setText(Double.toString(data.getRestaurantRating()));
		setColor(restaurantName2, data.getRestaurantRating());
		imgView2.setVisible(true);

		data = (RestaurantVO) list.get(2);
		restaurantName3.setText(data.getRestaurantName());
		restaurantLocation3.setText(data.getRestaurantLocation());
		restaurantRating3.setText(Double.toString(data.getRestaurantRating()));
		setColor(restaurantName3, data.getRestaurantRating());
		imgView3.setVisible(true);

		data = (RestaurantVO) list.get(3);
		restaurantName4.setText(data.getRestaurantName());
		restaurantLocation4.setText(data.getRestaurantLocation());
		restaurantRating4.setText(Double.toString(data.getRestaurantRating()));
		setColor(restaurantName4, data.getRestaurantRating());
		imgView4.setVisible(true);

		data = (RestaurantVO) list.get(4);
		restaurantName5.setText(data.getRestaurantName());
		restaurantLocation5.setText(data.getRestaurantLocation());
		restaurantRating5.setText(Double.toString(data.getRestaurantRating()));
		setColor(restaurantName5, data.getRestaurantRating());
		imgView5.setVisible(true);

		data = (RestaurantVO) list.get(5);
		restaurantName6.setText(data.getRestaurantName());
		restaurantLocation6.setText(data.getRestaurantLocation());
		restaurantRating6.setText(Double.toString(data.getRestaurantRating()));
		setColor(restaurantName6, data.getRestaurantRating());
		imgView6.setVisible(true);

		data = (RestaurantVO) list.get(6);
		restaurantName7.setText(data.getRestaurantName());
		restaurantLocation7.setText(data.getRestaurantLocation());
		restaurantRating7.setText(Double.toString(data.getRestaurantRating()));
		setColor(restaurantName7, data.getRestaurantRating());
		imgView7.setVisible(true);

		data = (RestaurantVO) list.get(7);
		restaurantName8.setText(data.getRestaurantName());
		restaurantLocation8.setText(data.getRestaurantLocation());
		restaurantRating8.setText(Double.toString(data.getRestaurantRating()));
		setColor(restaurantName8, data.getRestaurantRating());
		imgView8.setVisible(true);

		data = (RestaurantVO) list.get(8);
		restaurantName9.setText(data.getRestaurantName());
		restaurantLocation9.setText(data.getRestaurantLocation());
		restaurantRating9.setText(Double.toString(data.getRestaurantRating()));
		setColor(restaurantName9, data.getRestaurantRating());
		imgView9.setVisible(true);

		data = (RestaurantVO) list.get(9);
		restaurantName10.setText(data.getRestaurantName());
		restaurantLocation10.setText(data.getRestaurantLocation());
		restaurantRating10.setText(Double.toString(data.getRestaurantRating()));
		setColor(restaurantName10, data.getRestaurantRating());
		imgView10.setVisible(true);
	}

	// 룰렛 결과 확인
	public void showResult(ActionEvent event) {
//		System.out.println("결과 확인" + res);
		roulletResLabel.setText("제육볶음");
//		roulletResLabel.setText(res);
		foodImg.setVisible(true);
	}

	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		searchLocation.setOnAction(event -> {
			try {
				getMenuLoc10(event);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		showResBtn.setOnAction(event -> showResult(event));

		searchCategory.setOnAction(event -> {
			try {
				getMenuTop10(event);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
}
