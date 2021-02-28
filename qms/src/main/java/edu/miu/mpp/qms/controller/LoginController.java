package edu.miu.mpp.qms.controller;

import java.io.IOException;

import edu.miu.mpp.qms.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class LoginController {

    @FXML
    private TextField userName;
    @FXML
    private TextField password;
    @FXML
    private Button signUp;

    @FXML
    private Button signin;
    
    @FXML
    private Text failedAuthText;

    @FXML
    void signUpAction(ActionEvent event) throws IOException {
    	App.setRoot("registration");
    }

    @FXML
    void signinAction(ActionEvent event) throws IOException {
    	String mainUser = "teacher";
    	String mainPass = "teacher";
    	
    	if(userName.getText().trim().equalsIgnoreCase(mainUser) && password.getText().trim().equalsIgnoreCase(mainPass)) {
    		failedAuthText.setVisible(false);
    		if(mainUser.equals("teacher"))
    			App.setRoot("quizManagement");
    		else 
    			App.setRoot("choseQuiz");
    	}else {
    		failedAuthText.setVisible(true);
    	}
    }
}
