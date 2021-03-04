package edu.miu.mpp.qms.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import edu.miu.mpp.qms.App;
import edu.miu.mpp.qms.business.Options;
import edu.miu.mpp.qms.business.Question;
import edu.miu.mpp.qms.business.Quiz;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class QuizController implements Initializable{

	private int questionCounter = 0;
    private Quiz quiz;

    @FXML
    private Button logout;

    @FXML
    private Text quiztitle;

    @FXML
    private TextArea questiontext;

    @FXML
    private RadioButton opt1;

    @FXML
    private RadioButton opt2;

    @FXML
    private RadioButton opt3;

    @FXML
    private RadioButton opt4;

    @FXML
    private Button cancelButtonId;

    @FXML
    private Button SubmitButtonId;

    @FXML
    private Button nextButtonId;

    List<Options> userOptions;
    Question currentQuestion;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		userOptions = new ArrayList<>();
		quiz = ChooseQuiz.getQuiz();
		quiztitle.setText(quiz.toString());
		prepareNextQuestion();
	}

	
	
	@FXML
    void cancelAction(ActionEvent event) throws IOException {
		userOptions = new ArrayList<>();
		quiz = null;
		questionCounter = 0;
		App.setRoot("studentDashBoard");
    }

    @FXML
    void nextAction(ActionEvent event) {
    	if(opt1.isSelected()) {
    		userOptions.add(currentQuestion.getOptions().get(0));
        	opt1.setSelected(false);
    	}
        else if(opt2.isSelected()) {
        	userOptions.add(currentQuestion.getOptions().get(1));
        	opt2.setSelected(false);
        }
    		
    	else if(opt3.isSelected()) {
    		userOptions.add(currentQuestion.getOptions().get(2));
    		opt3.setSelected(false);
    	}
    	else
    	{
    		userOptions.add(currentQuestion.getOptions().get(3));
    		opt4.setSelected(false);
    	}
    	questionCounter++;
    	prepareNextQuestion();
    }

    @FXML
    void submittAction(ActionEvent event) {
    	//TODO
    }

    private void prepareNextQuestion() {
		if(quiz.getQuestion().size() > questionCounter) {
			
			currentQuestion = quiz.getQuestion().get(questionCounter);
			questiontext.setText(currentQuestion.getLabel());
			
			//setting the values in the options
			if(currentQuestion.getOptions().size() > 0)
				opt1.setText(currentQuestion.getOptions().get(0).getDescription());
			else {
				opt1.setVisible(false);
				opt2.setVisible(false);
				opt3.setVisible(false);
				opt4.setVisible(false);
			}
			if(currentQuestion.getOptions().size() > 1)
				opt2.setText(currentQuestion.getOptions().get(1).getDescription());
			else {
				opt2.setVisible(false);
				opt3.setVisible(false);
				opt4.setVisible(false);
			}
			if(currentQuestion.getOptions().size() > 2)
				opt1.setText(currentQuestion.getOptions().get(2).getDescription());
			else {
				opt3.setVisible(false);
				opt4.setVisible(false);
			}
			if(currentQuestion.getOptions().size() > 3)
				opt1.setText(currentQuestion.getOptions().get(3).getDescription());
			else
				opt4.setVisible(false);
		}else { 
			questiontext.setText("Question was not written");
			opt1.setDisable(true);
			opt2.setDisable(true);
			opt3.setDisable(true);
			opt4.setDisable(true);
			nextButtonId.setDisable(true);
		}
	}
    
    public Quiz getQuiz() {
		return quiz;
	}
    public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}
}

