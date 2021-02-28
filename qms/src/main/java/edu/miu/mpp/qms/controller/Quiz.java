package edu.miu.mpp.qms.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class Quiz {

    @FXML
    private Button logout;

    @FXML
    private Text quiztitle;

    @FXML
    private TextArea questiontext;

    @FXML
    private RadioButton opt1;

    @FXML
    private RadioButton opt2;

    @FXML
    private RadioButton opt3;

    @FXML
    private RadioButton opt4;

    @FXML
    private Button cancel;

    @FXML
    private Button submitt;

    @FXML
    void submittAction(ActionEvent event) {

    }

}

