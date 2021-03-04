package edu.miu.mpp.qms.controller;



import java.io.IOException;

import edu.miu.mpp.qms.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class StudentDashBoard {

    @FXML
    private Label studentLbl;

    @FXML
    void doQuizBtnAction(ActionEvent event) throws IOException {
    	App.setRoot("chooseQuiz");
    }

    @FXML
    void logoutBtnAction(ActionEvent event) throws IOException {
    	App.setRoot("login");
    }

    @FXML
    void myReportBtnAction(ActionEvent event) throws IOException {
    	App.setRoot("studentReport");
    }
    
	

}
