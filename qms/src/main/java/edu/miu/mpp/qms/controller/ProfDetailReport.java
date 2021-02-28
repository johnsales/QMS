package edu.miu.mpp.qms.controller;

import java.io.IOException;

import edu.miu.mpp.qms.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ProfDetailReport {

    @FXML
    private Button logout;

    @FXML
    private Button back;

    @FXML
    void backAction(ActionEvent event) throws IOException {
    	App.setRoot("professorDashBoard");
    }

    @FXML
    void logoutAction(ActionEvent event) throws IOException {
    	App.setRoot("login");
    }

}

