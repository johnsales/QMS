
package edu.miu.mpp.qms.controller;

import java.io.IOException;
import java.util.Optional;

import edu.miu.mpp.qms.App;
import edu.miu.mpp.qms.business.User;
import edu.miu.mpp.qms.business.UserType;
import edu.miu.mpp.qms.dao.LoadData;
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
    	Optional<User> user = LoadData.getUsers().stream().filter(u -> u.getUsername().equals(userName.getText()) && u.getPassword().equals(password.getText())).findFirst();
    	
    	if(user.isPresent()) {
    		failedAuthText.setVisible(false);
    		if(user.get().getUserType() == UserType.PROFESSOR)
    			App.setRoot("professorDashboard");
    		else  
    			App.setRoot("studentDashboard");
    	}else {
    		failedAuthText.setVisible(true);
    	}
    }
}
