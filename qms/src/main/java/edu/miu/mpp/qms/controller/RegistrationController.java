package edu.miu.mpp.qms.controller;

import java.io.IOException;

import edu.miu.mpp.qms.App;
import edu.miu.mpp.qms.business.Professor;
import edu.miu.mpp.qms.business.User;
import edu.miu.mpp.qms.dao.LoadData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class RegistrationController {

    @FXML
    private TextField fname;
    @FXML
    private TextField lname;
    @FXML
    private TextField username;
    @FXML
    private PasswordField pwd;
    @FXML
    private RadioButton prof;
    @FXML
    private RadioButton stu;
    @FXML
    private Button register;
    @FXML
    final ToggleGroup group = new ToggleGroup();
    
    public RegistrationController() {
		// TODO Auto-generated constructor stub
//    	prof.setToggleGroup(group);
//    	stu.setToggleGroup(group);
	}


    
	@FXML
    void registerationAction(ActionEvent event) throws IOException {
		//verify is is teacher or student
		User newUser = new Professor(username.getText(), pwd.getText(), fname.getText(), lname.getText());
		LoadData.getUsers().add(newUser);
		App.setRoot("quizManagement");
    }
    @FXML
    void adminSigninAction(ActionEvent event) throws IOException {
    	 App.setRoot("registration");
    }
    
    
    @FXML
    void logoutAction(ActionEvent event) throws IOException {
    	 App.setRoot("login");
    }


}
