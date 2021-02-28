package edu.miu.mpp.qms.controller;

import java.io.IOException;
import javafx.fxml.FXML;

public class QuizManagmentController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}