package edu.miu.mpp.qms.controller;

import java.io.IOException;
import java.util.Arrays;

import edu.miu.mpp.qms.App;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

public class ProfDetailReport {

    @FXML
    private Button logout;
    @FXML
    private Button back;
    @FXML
    private ListView<String> listView;
    
    @FXML
    private void initialize() {


    	listView.getItems().addAll(Arrays.asList("a","b","c","d","e","f"));
    	ObservableList<String> observableList = FXCollections.observableArrayList(Arrays.asList("a","b","c","d","e","f"));
    	VBox vBox=new VBox();//Gives vertical box
    	Scene screen = new Scene(vBox, 10, 10);
    	//stage.setScene(screen);
    }
    
    @FXML
    void backAction(ActionEvent event) throws IOException {
    	App.setRoot("professorDashBoard");
    }

    @FXML
    void logoutAction(ActionEvent event) throws IOException {
    	App.setRoot("login");
    }

}

