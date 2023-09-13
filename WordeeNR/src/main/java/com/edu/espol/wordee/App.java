package main.java.com.edu.espol.wordee;
 
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException; 
import static javafx.application.Application.launch;

/**
 * JavaFX App
 */  
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.setTitle("WORDEE");
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/vista/"+fxml + ".fxml"));
        //FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/main/resources/com/edu/espol/wordee/"+fxml + ".fxml"));
        
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}