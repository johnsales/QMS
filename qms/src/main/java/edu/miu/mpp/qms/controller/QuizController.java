package edu.miu.mpp.qms.controller;

import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import edu.miu.mpp.qms.business.Options;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class QuizController implements Initializable{

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
    private Button cancelButtonId;

    @FXML
    private Button SubmitButtonId;

    @FXML
    private Button nextButtonId;

    Set<Options> userOptions;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		userOptions = new HashSet<>();
	}
	
	@FXML
    void cancelAction(ActionEvent event) {
		userOptions = new HashSet<>();
    }

    @FXML
    void nextAction(ActionEvent event) {
    	userOptions.add(null);
    }

    @FXML
    void submittAction(ActionEvent event) {
    	//TODO
    }

}

