package edu.miu.mpp.qms.controller;

import java.io.IOException;

import edu.miu.mpp.qms.App;
import edu.miu.mpp.qms.business.Professor;
import edu.miu.mpp.qms.business.User;
import edu.miu.mpp.qms.business.UserType;
import edu.miu.mpp.qms.dao.LoadData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
    
    String validateMessage ;
    public void validatingFields() {
    	validateMessage = "";
    	
    	if (fname.getText().length() < 1) {
    		validateMessage = "Enter Firstname\n";
    	}
    	if (lname.getText().length() < 1) {
    		validateMessage = validateMessage +"Enter Lastname\n";

    	}
    	if (username.getText().length() < 1) {
    		validateMessage = validateMessage +"Enter Username\n";

    	}
    	
    	if (pwd.getText().length() < 1) {
    		validateMessage = validateMessage +"Enter Password\n";

    	}
    
    	if(!prof.isSelected() && !stu.isSelected()) {
    		validateMessage = validateMessage +"Select Any Role\n";

    	}
    	
    	
    }
    
    
	@FXML
    void registerationAction(ActionEvent event) throws IOException {
		//verify is is teacher or student
		
		validatingFields();
    	if (validateMessage.length() > 0) {
    		alertMessage();
    		return;
    	}
		
		User newUser = new User(username.getText(), pwd.getText(), fname.getText(), lname.getText());
		newUser.setUserType(prof.isSelected() ? UserType.PROFESSOR : UserType.STUDENT);
		LoadData.getUsers().add(newUser);
		App.setRoot("login");
    }
    @FXML
    void adminSigninAction(ActionEvent event) throws IOException {
    	 App.setRoot("registration");
    }
    
    
    @FXML
    void logoutAction(ActionEvent event) throws IOException {
    	 App.setRoot("login");
    }
    
    public void alertMessage() {
    	  Alert alert = new Alert(Alert.AlertType.INFORMATION);
    	    alert.setTitle("Alert");
    	    alert.setHeaderText("Data Missing");
    	    alert.setContentText(validateMessage);
    	    alert.showAndWait();
   
}


}
