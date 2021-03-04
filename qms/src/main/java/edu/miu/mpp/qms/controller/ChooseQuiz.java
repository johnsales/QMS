package edu.miu.mpp.qms.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import edu.miu.mpp.qms.App;
import edu.miu.mpp.qms.business.Quiz;
import edu.miu.mpp.qms.dao.LoadData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class ChooseQuiz implements Initializable{

    private static Quiz quiz;

    @FXML
    private Button logout;

    @FXML
    private ComboBox<Quiz> selectQuiz;

    @FXML
    private Button startquiz;

    @FXML
    private Button back;
    
    @FXML
    void logoutAction(ActionEvent event) throws IOException {
    	App.setRoot("login");
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		selectQuiz.getItems().addAll(LoadData.getQuizzes());
	}
	
	 @FXML
    void callBack(ActionEvent event) throws IOException {
    	App.setRoot("studentDashboard");
    }
	 @FXML
    void startQuiz(ActionEvent event) throws IOException {
		 quiz = selectQuiz.getSelectionModel().getSelectedItem();
		 App.sendQuizToQuizController(quiz, "quiz");
    }
	 
	 public static Quiz getQuiz() {
		return quiz;
	}
	 public static void setQuiz(Quiz quiz) {
		ChooseQuiz.quiz = quiz;
	}
}
