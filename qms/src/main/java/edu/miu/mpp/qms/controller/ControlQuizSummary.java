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
       
//        Professor prof = new Professor("okalu", "test", "Obina", "Kalu", UserType.PROFESSOR);
//        LocalDateTime startTime1 = LocalDateTime.of(2021, 02, 28, 00, 00);
//        LocalDateTime endTime = LocalDateTime.of(2021, 03, 01, 00, 00);
//       
//        //quizzies = new Quiz(startTime, endTime, 20, prof);
//        Question q1 = new Question("Lambda ?", "1", quizzies);
//        Question q2 = new Question("Lambda ?", "1", quizzies);
//        quizzies.getQuestion().add(q1);
//       
//        //globalq1 = q1;
//        //starter = startTime1;
//        System.out.println("from question to controlQuiz");
//       
//        startTime.setText("It's OK");
       
    }
    
    //Disable startTime, StopTime and Duration
    
   public void populateQuiz(Quiz quiz) {
	   startTime.setText(quiz.getStartTime()+"");
	   stopTime.setText(quiz.getEndTime()+"");
	   duration.setText(quiz.getDuration()+"");
	   
	   //System.out.println(quiz.getQuestion().get(0).getLabel());
	   //quizSummaryListView.getItems().add(quiz.getQuestion().get(0).getLabel());
	   quiz.getQuestion().stream().forEach(q -> quizSummaryListView.getItems().add(q.getLabel()));
	   
   }
    @FXML
    public void initialize(Quiz quiz){
    	//System.out.printf("%d",x.startTime.getMinute());
    	//startTime.setText(x.getStartTime().toString());
    	setQuizzies(quiz);
//    	System.out.println("Is quiz there? "+quizzies.getDuration());
//    	startTime.setText(quizzies.getStartTime()+"");
    	populateQuiz(quizzies);
    	
    	
    	startTime.setDisable(true);
    	stopTime.setDisable(true);
    	duration.setDisable(true);
    }
    
    
    
    @FXML
    void backQuestionManagementAction(ActionEvent event) throws IOException {
    	//x.questions.set(0, null)
    	//quizSummaryListView.getItems().addAll(x.getStartTime().get(0).toString());
//    	quizSummaryListView.getItems().add("Q2");
//    	quizSummaryListView.getItems().add("Itemdfsddfd 1");
//    	quizSummaryListView.getItems().add("Itdfdgfgem 1");
//    	quizSummaryListView.getItems().add("Itemfg 1");
//    	quizSummaryListView.getItems().add("sdfdsfhfgjhgg 1");
    	App.setRoot("questionManagement");
    	
    }

    @FXML
    void confirmAction(ActionEvent event) {
    	//LoadData
    	
    }

}
