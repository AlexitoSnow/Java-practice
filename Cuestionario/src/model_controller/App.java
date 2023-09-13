package model_controller;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import static javafx.application.Application.launch;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("VistaExamen"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/vista/"+fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        List<Pregunta> lista = new ArrayList<>();
        List<String> opciones = new ArrayList<>();
        opciones.add("opcion1");
        opciones.add("opcion2");
        opciones.add("opcion3");
        Categoria biologia = new Categoria("biologia","foto1.png");
        Categoria geografia = new Categoria("geografia","foto3.png");
        Categoria literatura = new Categoria("literatura","foto2.png");
        lista.add(new Pregunta("pregunta1",opciones,"respuesta1",biologia));
        lista.add(new Pregunta("pregunta2",opciones,"respuesta2",biologia));
        lista.add(new Pregunta("pregunta3",opciones,"respuesta3",biologia));
        lista.add(new Pregunta("pregunta1",opciones,"respuesta1",geografia));
        lista.add(new Pregunta("pregunta2",opciones,"respuesta2",geografia));
        lista.add(new Pregunta("pregunta3",opciones,"respuesta3",geografia));
        lista.add(new Pregunta("pregunta1",opciones,"respuesta1",literatura));
        lista.add(new Pregunta("pregunta2",opciones,"respuesta2",literatura));
        lista.add(new Pregunta("pregunta3",opciones,"respuesta3",literatura));
        try {
            ObjectOutputStream ob = new ObjectOutputStream(new FileOutputStream("src/recursos/preguntas.ser"));
            ob.writeObject(lista);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        BufferedWriter bf = null;
        try {
            bf = new BufferedWriter(new FileWriter("src/recursos/categorias.txt"));
            bf.write("biologia,foto1.png\n");
            bf.write("geografia,foto3.png\n");
            bf.write("literatura,foto2.png\n");
            bf.close();
            launch();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                bf.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}