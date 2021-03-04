package edu.miu.mpp.qms.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.miu.mpp.qms.App;
import edu.miu.mpp.qms.business.Options;
import edu.miu.mpp.qms.business.Question;
import edu.miu.mpp.qms.business.Quiz;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

public class QuestionManagementController extends Controller {

	@FXML
	private Button logoutButton;

	@FXML
	private TextArea questionTxtField;

	@FXML
	private TextField opt1TxtField;

	@FXML
	private TextField opt2TxtField;

	@FXML
	private TextField opt3TxtField;

	@FXML
	private TextField opt4TxtField;

	@FXML
	private RadioButton correctARadio;

	@FXML
	private RadioButton correctBRadio;

	@FXML
	private RadioButton correctCRadio;

	@FXML
	private RadioButton correctDRadio;

	@FXML
	private Button cancelBtn;

	@FXML
	private Button finishBtn;

	@FXML
	private Button nextBtn;

	@FXML
	private Button addQuestionBtn;
	
	private List<Question> listQuestions = new ArrayList<Question>();
	
	public List<Question> getListQuestions() {
		return listQuestions;
	}

	public void setListQuestions(List<Question> listQuestions) {
		this.listQuestions = listQuestions;
	}

	private Quiz quiz;
	int order = 0;

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz parent) {
		this.quiz = parent;
		//logoutButton.setText(parent.getDuration()+"");
		//questionTxtField.setText("Duration: "+parent.getDuration()+" - ");
	}

	/**
	 * The constructor. The constructor is called before the initialize() method.
	 */
	public QuestionManagementController() {
		super();
	}

	@FXML
	public void initialize(Quiz quiz) {
		ToggleGroup group = new ToggleGroup();
		setQuiz(quiz);
		correctARadio.setToggleGroup(group);
		correctBRadio.setToggleGroup(group);
		correctCRadio.setToggleGroup(group);
		correctDRadio.setToggleGroup(group);
		
	}

//    
	@FXML
	private void switchToquiz() throws IOException {
		validatingFields();
    	if (validateMessage.length() > 0) {
    		alertMessage();
    		return;
    	}
    	
		App.setRoot("quizManagement");
	}

	@FXML
	
	synchronized void confirmQuestion(ActionEvent event) {
		//System.out.println("local: "+quiz+ "\n getter: "+getQuiz());
		validatingFields();
    	if (validateMessage.length() > 0) {
    		alertMessage();
    		return;
    	}
		
		Quiz q = getQuiz();
		App.showQuestionToControlQuiz(q, "quizSummary");

	}

	@FXML
	void goBackToQuiz(ActionEvent event) throws IOException {
		App.setRoot("quizManagement");

	}

	@FXML
	void logoutAction(ActionEvent event) throws IOException {
		App.setRoot("login");
	}

	public Question getQuestion(Quiz quizz) {
		String questionLabel = questionTxtField.getText();
		List<String> options = new ArrayList<String>();
		options.add(opt1TxtField.getText());
		options.add(opt2TxtField.getText());
		options.add(opt3TxtField.getText());
		options.add(opt4TxtField.getText());
		
		return new Question(questionLabel, ""+ (order++), quiz);

	}
	
	public Question addOptions(Question question) {
		List<Options> option = new ArrayList<Options>();
//    	
		option.add(new Options(correctARadio.getText(), correctARadio.selectedProperty().getValue(), question));
		option.add(new Options(question.getLabel(), correctARadio.selectedProperty().getValue(), question));
		option.add(new Options(question.getLabel(), correctARadio.selectedProperty().getValue(), question));
		option.add(new Options(question.getLabel(), correctARadio.selectedProperty().getValue(), question));
//   
		return question;
	}
	
	public void setQuestionToDefault()
	{
		questionTxtField.setText("Write your question here");
		opt1TxtField.setText("option 1");
		opt2TxtField.setText("option 2");
		opt3TxtField.setText("option 3");
		opt4TxtField.setText("option 4");
	}

	@FXML
	void addQuestion(ActionEvent event) {
		
		
		validatingFields();
    	if (validateMessage.length() > 0) {
    		alertMessage();
    		return;
    	}
    	
		Question question = getQuestion(quiz);
		//System.out.println("Data sent: "+quiz.getDuration());
		
		question = addOptions(question);
		//System.out.println(question.getLabel());
		
		quiz.getQuestion().add(question);
		
		//Set Fields to default values
		setQuestionToDefault();
	}

	@FXML
	private void receiveData(MouseEvent event) {
		QuizHolder holder = QuizHolder.getInstance();
		Quiz u = holder.getQuiz();

	}
	
	   String validateMessage ;
	    public void validatingFields() {
	    	validateMessage = "";
	    	
	    	if (questionTxtField.getText().length() < 1 ) {
	    		validateMessage = "Enter Question\n";
	    	}
	    	
	    
	    	if (opt1TxtField.getText().length() < 1) {
	    		validateMessage = validateMessage +"Enter Question Option 1\n";
	    	}
	    	
	    	if (opt2TxtField.getText().length() < 1) {
	    		validateMessage = validateMessage +"Enter Question Option 2\n";
	    	}
	    	
	    	if (opt3TxtField.getText().length() < 1) {
	    		validateMessage = validateMessage +"Enter Question Option 3\n";
	    	}
	    	
	    	if (opt3TxtField.getText().length() < 1) {
	    		validateMessage = validateMessage +"Enter Question Option 4\n";
	    	}
	    	
	    	if(!correctARadio.isSelected() && !correctBRadio.isSelected() && !correctCRadio.isSelected() && !correctDRadio.isSelected()) {
	    		validateMessage = validateMessage +"Select Correct Answer\n";

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
