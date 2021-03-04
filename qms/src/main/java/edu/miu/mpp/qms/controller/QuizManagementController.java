package edu.miu.mpp.qms.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import edu.miu.mpp.qms.App;
import edu.miu.mpp.qms.business.Professor;
import edu.miu.mpp.qms.business.Question;
import edu.miu.mpp.qms.business.Quiz;
import edu.miu.mpp.qms.business.UserType;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class QuizManagementController extends Controller {

	@FXML
	private Button logoutBtn;

	@FXML
	private DatePicker startime;

	@FXML
	private DatePicker endTime;

	@FXML
	private TextField duration;

	@FXML
	private Button addBtn;

	@FXML
	private Button goBackBtn;

	Quiz quiz;

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}
	
	public void getQuizFromForm() {
		quiz = new Quiz();
		LocalDate lStart = startime.getValue();
		LocalDate lEnd = endTime.getValue();
		LocalDateTime startTime = lStart.atStartOfDay();
		LocalDateTime endTime = lEnd.atStartOfDay();
		
		quiz.setDuration(duration.getText().equals(null)?0:Integer.parseInt(duration.getText()));
		quiz.setStartTime(startTime);
		quiz.setEndTime(endTime);
	}

	@FXML
	private void switchToQuestion() throws IOException {
//		LocalDate startT = startime.getValue();
//		LocalDate endT = endTime.getValue();
		getQuizFromForm();

//		double durationT = Double.parseDouble(duration.getText());
		//Professor prof = new Professor("okalu", "test", "Obina", "Kalu", UserType.PROFESSOR);
		//quiz.setProfessor(prof);
		
		//App.showSceneWithData(quiz, "questionManagement");
		App.showQuestionWithData(quiz, "questionManagement");
		
		//App.setRoot("questionManagement");
	}

	@FXML
	private void logoutAction() throws IOException {
		App.setRoot("login");
	}

	@FXML
	private void backToProfDashBoard() throws IOException {
		App.setRoot("professorDashBoard");
	}

}