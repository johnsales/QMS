package edu.miu.mpp.qms.controller;

import java.io.IOException;

import edu.miu.mpp.qms.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

public class RegistrationController {

    @FXML
    private AnchorPane fname;

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
    void registerationAction(ActionEvent event) {

    }
    @FXML
    void adminSigninAction(ActionEvent event) throws IOException {
    	 App.setRoot("registration");
    }
    
    
    @FXML
    void logoutAction(ActionEvent event) throws IOException {
    	 App.setRoot("adminLogin");
    }


}
