package edu.miu.mpp.qms.controller;

import java.io.IOException;
import java.time.LocalDate;

import edu.miu.mpp.qms.App;
import edu.miu.mpp.qms.business.Professor;
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

//	@FXML
//	private void switchToQuestion(ActionEvent event) throws IOException {
//		// Step 1
//		LocalDate startT = startime.getValue();
//		LocalDate endT = endTime.getValue();
//
//		double durationT = Double.parseDouble(duration.getText());
//		Professor prof = new Professor("okalu", "test", "Obina", "Kalu", UserType.PROFESSOR);
//		quiz = new Quiz(startT.atStartOfDay(), endT.atStartOfDay(), durationT, prof);
//
//		Node node = (Node) event.getSource();
//		Stage stage = (Stage) node.getScene().getWindow();
//		stage.close();
//
//		// QuizHolder holder = QuizHolder.getInstance();
//		// Step 3
//		//holder.setQuiz(quiz);
//		App.setRoot("questionManagement");
//		try {
//			 FXMLLoader loader = FXMLLoader.load(getClass().getClassLoader().getResource("../view/questionManagement.fxml"));
//			    
//			//Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/SceneB.fxml"));
//			// Step 2
//			//QuizHolder holder = QuizHolder.getInstance();
//			// Step 3
//			//holder.setQuiz(quiz);
//			// Step 4
//			QuestionManagementController controller = new QuestionManagementController();
//			controller.setParent(quiz);
//
//			// Step 4
//			loader.setController(controller);
//			// Step 5
//			Parent root = loader.load();
//			
//			Scene scene = new Scene(root);
//			stage.setScene(scene);
//			stage.show();
//		} catch (IOException e) {
//			System.err.println(String.format("Error: %s", e.getMessage()));
//		}
//	}

	@FXML
	private void switchToQuestion() throws IOException {
		LocalDate startT = startime.getValue();
		LocalDate endT = endTime.getValue();

		double durationT = Double.parseDouble(duration.getText());
		Professor prof = new Professor("okalu", "test", "Obina", "Kalu", UserType.PROFESSOR);
		quiz = new Quiz(startT.atStartOfDay(), endT.atStartOfDay(), durationT, prof);
		this.setQuiz(quiz);
		
		System.out.println(quiz.toString());
		
		App.showSceneWithData(quiz, "questionManagement");
		//App.showQuestionWithData(quiz, "questionManagement");
		
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