package edu.miu.mpp.qms.controller;

import java.io.IOException;

import edu.miu.mpp.qms.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class QuestionManagementController {

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
    private RadioButton correctCRadio;

    @FXML
    private Button cancelBtn;

    @FXML
    private Button finishBtn;

    @FXML
    private Button nextBtn;

	/**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public QuestionManagementController() {
    }
    
    @FXML
    private void switchToquiz() throws IOException {
        App.setRoot("quizManagement");
    }

    @FXML
    void confirmQuestion(ActionEvent event) {

    }

    @FXML
    void goBackToQuiz(ActionEvent event) {

    }

    @FXML
    void logoutAction(ActionEvent event) throws IOException {
    	 App.setRoot("adminLogin");
    }

    @FXML
    void saveQuestion(ActionEvent event) {
    	//finishBtn.setText("Congrat!");
    	//mainApp.getPrimaryStage().
    	//mainApp.initRootLayout();

    }

}
