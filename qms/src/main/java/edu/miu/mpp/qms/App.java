package edu.miu.mpp.qms;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private Parent parent;
    
    @Override
    public void start(Stage stage) throws IOException {
    	//parent = loadFXML("login");
    	parent = loadFXML("studentDashboard");
    	//clean error authentication
    	//parent.getChildrenUnmodifiable().get(6).setVisible(false);
    	
    	scene = new Scene(parent, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view/"+fxml + ".fxml"));
    	return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}