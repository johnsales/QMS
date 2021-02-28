package edu.miu.mpp.qms.controller;

import java.io.IOException;

import edu.miu.mpp.qms.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private TextField adminUserName;

    @FXML
    private TextField adminPassword;

    @FXML
    private TextField studentUserName;

    @FXML
    private TextField studentPassword;

    @FXML
    private Button adminSignUp;

    @FXML
    private Button adminSignin;

    @FXML
    private Button studentSignin;

    @FXML
    private Button studentSignup;

    @FXML
    void adminSignUpAction(ActionEvent event) {
    	
    }

    @FXML
    void adminSigninAction(ActionEvent event) throws IOException {
    	String mainUser = "ABCD";
    	String mainPass = "1234";
    	String username = adminUserName.getText();
    	String password = adminPassword.getText();
    	System.out.printf("Username: %s \nPassword: %s", username, password );
    	if(username.trim().equalsIgnoreCase(mainUser) && password.trim().equalsIgnoreCase(mainPass)) {
//    		try {
//    			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("../view/Registeration.fxml"));
//    			Stage stage = (Stage) studentPassword.getScene().getWindow();
//    			Scene scene = new Scene(root, 600,  400);
//    			stage.setScene(scene);
//    		} catch(Exception e) {
//    			e.printStackTrace();
//    		}
    	App.setRoot("registration");
    	}
    }

    @FXML
    void studentSigninAction(ActionEvent event) {
    	System.out.println("LoginController.studentSigninAction()");
    }

    @FXML
    void studentSignupAction(ActionEvent event) {

    }
    

}
