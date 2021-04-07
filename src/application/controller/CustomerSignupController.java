package application.controller;

import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.DBConnection;
import application.dao.MemberDAO;
import application.dao.MenuDAO;
import application.vo.MemberVO;
import application.vo.MenuVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CustomerSignupController implements Initializable {

	public ObservableList<String> listItems, listItems2;
	public static Connection conn = DBConnection.getConnection();
	public static String sessionNickname;

	@FXML
	public Button CustomerSignupCompleteBtn;

	@FXML
	public TextField cu_nickname, cu_id, cu_password, cu_lastname, cu_firstname, cu_age;
	
	@FXML
	public Text finishMsg;

	@FXML
	private ListView<String> hatefoodlistview, hatefoodresult;

	public void CSCB(ActionEvent event) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("/application/pages/CustomerLogin.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = (Stage) CustomerSignupCompleteBtn.getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void signUp(ActionEvent event) throws Exception {
		String nickname = cu_nickname.getText();
		String id = cu_id.getText();
		String pw = cu_password.getText();
		String lastName = cu_lastname.getText();
		String firstName = cu_firstname.getText();
		int age = Integer.parseInt(cu_age.getText());

		MemberVO data = new MemberVO();
		data.setMemberId(id);
		data.setMemberPw(pw);
		data.setMemberLastName(lastName);
		data.setMemberFirstName(firstName);
		data.setMemberAge(age);
		data.setMemberNickName(nickname);
		data.setOwner("N");
		
		BoardButtonMainController.name = lastName + firstName;
		BoardButtonMainController.age = Integer.toString(age) + "세";
		BoardButtonMainController.nickname = nickname;

		MemberDAO dao = new MemberDAO();
		sessionNickname = dao.customerSignup(conn, data);

		WriteReViewController.setSessionNickname(sessionNickname);
		WriteReViewController.id = id;

		System.out.println("가입 완료");
		
		finishMsg.setText("회원가입이 완료되었습니다!");
		finishMsg.setStyle("-fx-text-fill: red;");
	}

	public void showhatemenulist(ActionEvent event) throws Exception {

		MenuDAO dao = new MenuDAO();
		ArrayList<MenuVO> list = dao.getCategoryList(conn);

		String[] strArr = new String[list.size()];

		MenuVO data;

		for (int i = 0; i < list.size(); i++) {
			data = (MenuVO) list.get(i);
			strArr[i] = data.getMenuCategory();
		}

//		listItems = FXCollections.observableArrayList(strArr);
		listItems = FXCollections.observableArrayList("면류", "튀김류", "덮밥류", "분식류", "볶음류", "구이류");
		hatefoodlistview.setItems(listItems);
	}

	public void menuclick(ActionEvent event) throws Exception {
		String a = hatefoodlistview.getSelectionModel().getSelectedItem().toString();
		listItems2.add(a);
		hatefoodresult.setItems(listItems2);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		listItems2 = FXCollections.observableArrayList();
		listItems2.addAll();
		hatefoodresult.setItems(listItems2);
	}
}
