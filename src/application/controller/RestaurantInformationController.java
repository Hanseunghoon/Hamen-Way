package application.controller;

import java.net.URL;
import java.sql.Connection;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.chart.PieChart.Data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.DBConnection;
import application.Session;
import application.dao.RestaurantDAO;
import application.dao.ReviewDAO;
import application.vo.RestaurantVO;
import application.vo.ReviewVO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RestaurantInformationController {

	public static Connection conn = DBConnection.getConnection();

	public static String restaurantName;

	@FXML
	public Button btnWriteReview, ResInfo_backbtn, check_resinfo, check_review;

	@FXML
	public Label res_name, res_grade, res_position, res_category, cu_reviewname1, cu_reviewgrade1, cu_reviewname2,
			cu_reviewgrade2, cu_reviewname3, cu_reviewgrade3, cu_reviewname4, cu_reviewgrade4, cu_reviewname5,
			cu_reviewgrade5, cu_reviewname6, cu_reviewgrade6, cu_reviewname7, cu_reviewgrade7, cu_reviewname8,
			cu_reviewgrade8, cu_reviewname9, cu_reviewgrade9, cu_reviewname10, cu_reviewgrade10;

	@FXML
	public Text cu_reviewdate1, cu_reviewdate2, cu_reviewdate3, cu_reviewdate4, cu_reviewdate5, cu_reviewdate6,
			cu_reviewdate7, cu_reviewdate8, cu_reviewdate9, cu_reviewdate10, cu_reviewtxt1, cu_reviewtxt2,
			cu_reviewtxt3, cu_reviewtxt4, cu_reviewtxt5, cu_reviewtxt6, cu_reviewtxt7, cu_reviewtxt8, cu_reviewtxt9,
			cu_reviewtxt10;

	@FXML
	private ListView<Review> listViewReview;

	private ObservableList<Review> ReviewObservableList;

	public static void setRestaurantName(String restaurantName) {
		RestaurantInformationController.restaurantName = restaurantName;
		System.out.println(restaurantName);
	}

	public void WriteReview(ActionEvent event) throws Exception {
		WriteReViewController.setRestaurantName(restaurantName);
		Parent root = FXMLLoader.load(getClass().getResource("/application/pages/WriteReView2.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = (Stage) btnWriteReview.getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void RestaurantInfo_BackBtn(ActionEvent event) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("/application/pages/NearbyRestaurant2.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = (Stage) ResInfo_backbtn.getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/* 백엔드 */
	// 가게 정보 불러오기
	public void showRestaurantInfo(ActionEvent event) throws SQLException {
		System.out.println("show Restaurant Info");

		System.out.println(restaurantName);

		RestaurantDAO dao = new RestaurantDAO();
		RestaurantVO data = dao.getRestaurantInfo(conn, restaurantName);

		res_name.setText(data.getRestaurantName());
		res_grade.setText(Double.toString(data.getRestaurantRating()));
		res_position.setText(data.getRestaurantLocation());
		res_category.setText(data.getRestaurantCategory());
	}

	// 가게 리뷰 불러오기
	public void showRestaurantReview(ActionEvent event) throws SQLException {
		System.out.println("show Restaurant Review");

		System.out.println(restaurantName);

		ReviewDAO dao = new ReviewDAO();
		ArrayList<ReviewVO> list = dao.getRestaurantTopReview(conn, restaurantName);

		ReviewObservableList = FXCollections.observableArrayList();

		ArrayList<Review> reviewArr = new ArrayList<>(list.size());

		for (int i = 0; i < list.size(); i++) {
			ReviewVO data = (ReviewVO) list.get(i);
			reviewArr.add(new Review(data.getMemberNickName(), Double.toString(data.getReviewTasteRating()),
					data.getReviewComment(), data.getReviewWriteDate()));

			System.out.println(data.getMemberNickName() + " / " + Double.toString(data.getReviewTasteRating()) + " / "
					+ data.getReviewComment() + " / " + data.getReviewWriteDate());
		}

		ReviewObservableList.addAll(reviewArr);

		listViewReview.setItems(ReviewObservableList);
		listViewReview.setCellFactory(studentListView -> new ReviewItemCell());
	}

	@FXML
	PieChart pieChart;

	public void btn(ActionEvent event) {
		
		ArrayList<Integer> datas = null;
		
		ReviewDAO dao = new ReviewDAO();
		try {
			datas = dao.getCountReviewRating(conn, restaurantName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ObservableList<Data> list = FXCollections.observableArrayList(
				new PieChart.Data("1점", datas.get(0)),
				new PieChart.Data("2점", datas.get(1)), 
				new PieChart.Data("3점", datas.get(2)), 
				new PieChart.Data("4점", datas.get(3)),
				new PieChart.Data("5점", datas.get(4)));
		pieChart.setData(list);
	}

	public void initialize(URL location, ResourceBundle resources) {

		// TODO Auto-generated method stub
		check_resinfo.setOnAction(event -> {
			try {
				showRestaurantInfo(event);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		check_review.setOnAction(event -> {
			try {
				showRestaurantReview(event);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
}