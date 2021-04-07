package application.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class ReviewItemCell extends ListCell<Review> {

	@FXML
	private Label userNick, rating, date;
	@FXML
	private Text reviewText;
	@FXML
	private AnchorPane anchorpane;

	private FXMLLoader mLLoader;

	@Override
	protected void updateItem(Review review, boolean empty) {
		super.updateItem(review, empty);

		if (empty || review == null) {

			setText(null);
			setGraphic(null);

		} else {
			if (mLLoader == null) {
				mLLoader = new FXMLLoader(getClass().getResource("/application/pages/ReviewItemCell.fxml"));
				mLLoader.setController(this);

				try {
					mLLoader.load();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

			userNick.setText(review.getUserNickName());
			rating.setText(review.getRating());
			reviewText.setText(review.getReview());
			date.setText(review.getReviewWriteDate());
			setGraphic(anchorpane);
		}

	}

}
