package edu.miu.mpp.qms.controller;

import java.io.IOException;

import edu.miu.mpp.qms.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CongratController {

	@FXML
    private Label resultLabel;

    @FXML
    private Label congratMessage;

    @FXML
    private Button exitButton;
    
    private Double score;
    
    @FXML
    public void initialize(Double score) {
    	this.score = score;
    	resultLabel.setText(score+"");
    	if (this.score >= 80.0) {
    		congratMessage.setText("Congratulations you passed !!!!");
    	} else
    	{
    		congratMessage.setText("Sorry you failed !!!!");
    	}
    }

    @FXML
    void goToDashBoard(ActionEvent event) throws IOException {
    	App.setRoot("studentDashBoard");

    }
    
    public void setScore(Double score) {
		this.score = score;
	}
    
    public Double getScore() {
		return score;
	}

}
