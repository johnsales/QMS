package edu.miu.mpp.qms.controller;

import java.io.IOException;

import edu.miu.mpp.qms.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class StudentReport {

	@FXML
    private Button logout;

    @FXML
    private ComboBox<?> selectQuiz;

    @FXML
    private Button back;

    @FXML
    void backAction(ActionEvent event) throws IOException {
    	App.setRoot("studentDashBoard");
    }

    @FXML
    void logoutAction(ActionEvent event) throws IOException {
    	App.setRoot("login");
	}

}
