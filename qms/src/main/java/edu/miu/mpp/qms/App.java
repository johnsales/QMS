package edu.miu.mpp.qms;

import java.io.IOException;
import java.util.List;

import edu.miu.mpp.qms.business.Quiz;
import edu.miu.mpp.qms.controller.CongratController;
import edu.miu.mpp.qms.controller.ControlQuizSummary;
import edu.miu.mpp.qms.controller.Controller;
import edu.miu.mpp.qms.controller.QuestionManagementController;
import edu.miu.mpp.qms.controller.QuizController;
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
    private static Stage primaryStage;
    private Parent parent;
    private static List<Quiz> getAllQuizzes = LoadData.getQuizzes();
    
    @Override
    public void start(Stage stage) throws IOException {
    	parent = loadFXML("login");
//    	parent = loadFXML("studentDashboard");
    	//clean error authentication
    	parent.getChildrenUnmodifiable().get(6).setVisible(false);
    	
    	scene = new Scene(parent, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader();
    	fxmlLoader.setLocation(App.class.getResource("view/"+fxml + ".fxml"));
    	return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
    
    public static void showQuestionWithData(Quiz data, String fxml) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("view/"+fxml+".fxml"));
           // loader.setLocation(App.class.getResource("view/questionManagement.fxml"));
            Parent root = (Parent) loader.load();
            
            // Set the data into the controller.
            QuestionManagementController controller = loader.getController();
            //System.out.println("Data: "+data.getStartTime());
            controller.initialize(data);
            scene.setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void showQuestionToControlQuiz(Quiz data, String fxml) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("view/"+fxml+".fxml"));
           // loader.setLocation(App.class.getResource("view/questionManagement.fxml"));
            Parent root = (Parent) loader.load();
            
            // Set the data into the controller.
            ControlQuizSummary controller = loader.getController();
            //System.out.println("Data: "+data.getStartTime());
            controller.initialize(data);
            scene.setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void sendQuizToQuizController(Quiz data, String fxml) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("view/"+fxml+".fxml"));
           // loader.setLocation(App.class.getResource("view/questionManagement.fxml"));
            Parent root = (Parent) loader.load();
            
            // Set the data into the controller.
            QuizController controller = loader.getController();
            controller.setQuiz(data);
            scene.setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void sendQuizToCongratController(Double data, String fxml) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("view/"+fxml+".fxml"));
           // loader.setLocation(App.class.getResource("view/questionManagement.fxml"));
            Parent root = (Parent) loader.load();
            
            // Set the data into the controller.
            CongratController controller = loader.getController();
            controller.initialize(data);
            scene.setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void showSceneWithData(Object data, String fxml) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("view/"+fxml+".fxml"));
           // loader.setLocation(App.class.getResource("view/questionManagement.fxml"));
            Parent root = (Parent) loader.load();
            
            // Set the data into the controller.
            Controller controller = loader.getController();
            //System.out.println("Data: "+data.getStartTime());
            controller.setData(data);
            scene.setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Quiz> getAllQuizzes(){
    	return getAllQuizzes;
    }
    

}