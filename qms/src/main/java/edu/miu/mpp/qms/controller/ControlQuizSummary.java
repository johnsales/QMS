package edu.miu.mpp.qms.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Collection;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import edu.miu.mpp.qms.App;
import edu.miu.mpp.qms.LoadData;
import edu.miu.mpp.qms.business.Professor;
import edu.miu.mpp.qms.business.Question;
import edu.miu.mpp.qms.business.Quiz;
import edu.miu.mpp.qms.business.UserType;

public class ControlQuizSummary extends QuestionManagementController {

    @FXML
    private TextField startTime;

    @FXML
    private TextField stopTime;

    @FXML
    private TextField duration;

    @FXML
    private Button backQuestionManagement;
    
    @FXML
    private ListView<String> quizSummaryListView;
    //private ListView listView;

    @FXML
    private Button confirm;
    private Quiz quizzies;
    
    QuestionManagementController x = new QuestionManagementController();
    
    public Quiz getQuizzies() {
        return quizzies;
    }
    public void setQuizzies(Quiz quizzies) {
        this.quizzies = quizzies;
       
    }
    
    //Disable startTime, StopTime and Duration
    
   public void populateQuiz(Quiz quiz) {
	   startTime.setText(quiz.getStartTime()+"");
	   stopTime.setText(quiz.getEndTime()+"");
	   duration.setText(quiz.getDuration()+"");
	   quiz.getQuestion().stream().forEach(q -> quizSummaryListView.getItems().add(q.getLabel()));
	   
   }
    @FXML
    public void initialize(Quiz quiz){
    	setQuizzies(quiz);
    	populateQuiz(quizzies);
//    	quizSummaryListView.setLayoutX(10);
//    	quizSummaryListView.setLayoutY(5);

    	//quizSummaryListView.setPrefSize(500, 200);
    	
    	
    	startTime.setDisable(true);
    	stopTime.setDisable(true);
    	duration.setDisable(true);
    }
    
    
    
    @FXML
    void backQuestionManagementAction(ActionEvent event) throws IOException {
    	App.setRoot("questionManagement");
    	
    }

    @FXML
    void confirmAction(ActionEvent event) throws IOException {
    	//LoadData
    	App.getAllQuizzes().add(quizzies);
    	App.setRoot("professorDashBoard");
    	
    }

}
