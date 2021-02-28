package edu.miu.mpp.qms.controller;

import java.io.IOException;

import edu.miu.mpp.qms.App;
import javafx.fxml.FXML;

public class QuizManagementController {

    @FXML
    private void switchToQuestion() throws IOException {
        App.setRoot("questionManagement");
    }
    @FXML
    private void logoutAction() throws IOException {
        App.setRoot("adminLogin");
    }
    @FXML
    private void saveQuestion() throws IOException {
        App.setRoot("secondary");
    }
 
}