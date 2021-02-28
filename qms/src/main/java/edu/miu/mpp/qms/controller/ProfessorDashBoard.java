package edu.miu.mpp.qms.controller;


import java.io.IOException;

import edu.miu.mpp.qms.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ProfessorDashBoard {

	 @FXML
    private Label professorNameLbl;

    @FXML
    private Button createQuiz;

    @FXML
    private Button professorReport;

    @FXML
    void createQuizBtnAction(ActionEvent event) throws IOException {
    	App.setRoot("quizManagement");
    }

    @FXML
    void logoutBtnAction(ActionEvent event) throws IOException {
    	App.setRoot("login");
    }

    @FXML
    void myReportBtnAction(ActionEvent event) throws IOException {
    	App.setRoot("profDetailReport");
    }


}
