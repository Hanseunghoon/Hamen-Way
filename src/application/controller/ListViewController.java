package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.dao.MenuDAO;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ListViewController implements Initializable {

	public static String restaurantNo;

	@FXML
	public ListView<String> ma_menuaddlistview;

	@FXML
	public Button ma_menuaddbtn, OwnerSignupCompleteBtn;

	@FXML
	public ChoiceBox ma_menucategory;

	@FXML
	public TextField ma_menuname, ma_menuprice;

	private ObservableList<String> nomes, listItems;

	@FXML
	public void MenuAddButton() {

		nomes.add(ma_menuname.getText());
		ma_menuaddlistview.setItems(nomes);

		String menuname = ma_menuname.getText();
		String menuprice = ma_menuprice.getText();
		String category = ma_menucategory.getValue().toString();

		MenuVO data = new MenuVO();
		data.setMenuName(menuname);
		data.setMenuPrice(Integer.parseInt(menuprice));
		data.setMenuCategory(category);

		MenuDAO.insertMenu(data);

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		nomes = FXCollections.observableArrayList();
		nomes.addAll();
		ma_menuaddlistview.setItems(nomes);
		listItems = FXCollections.observableArrayList("¸é·ù", "Æ¢±è·ù", "µ¤¹ä·ù", "ºÐ½Ä·ù", "ººÀ½·ù", "±¸ÀÌ·ù");
		ma_menucategory.setItems(listItems);

	}

	public void OSCB(ActionEvent event) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("/application/pages/Intro.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = (Stage) OwnerSignupCompleteBtn.getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();

	}
}
