package application.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class BoardButtonMainController {

	public static String name = "";
	public static String age = "";
	public static String nickname = "";

	@FXML
	public Button Homebtn, NearbyBtn, RecommendBtn, logoutBtn;

	@FXML
	private Label username_main, user_content_continue, info_username, info_userage, info_userNickName, info_userhate;

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

	public void LogOutBtn(ActionEvent event) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("/application/pages/Intro.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = (Stage) logoutBtn.getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void ShowUserInfo(ActionEvent action) {
		info_username.setText(name);
		info_userage.setText(age);
		info_userNickName.setText(nickname);
	}
}
