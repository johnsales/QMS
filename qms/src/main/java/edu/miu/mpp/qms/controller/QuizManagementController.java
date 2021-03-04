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
import javafx.scene.control.Alert;
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
		
		validatingFields();
    	if (validateMessage.length() > 0) {
    		alertMessage();
    		return;
    	}
		
//		LocalDate startT = startime.getValue();
//		LocalDate endT = endTime.getValue();
		getQuizFromForm();
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
	
    String validateMessage ;
    public void validatingFields() {
    	validateMessage = "";
    	
    	 ;
    	if (startime.getValue() == null) {
    		validateMessage = "Enter Start time\n";
    	}
    	if (endTime.getValue() == null) {
    		validateMessage = validateMessage +"Enter End Time\n";
    	}
    
    	if (duration.getText().length() < 1) {
    		validateMessage = validateMessage +"Enter Duration\n";
    	}
    
    	
    }
    
    public void alertMessage() {
  	  Alert alert = new Alert(Alert.AlertType.INFORMATION);
  	    alert.setTitle("Alert");
  	    alert.setHeaderText("Data Missing");
  	    alert.setContentText(validateMessage);
  	    alert.showAndWait();
 
}

}