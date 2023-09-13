package ec.edu.espol.mavenproject3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;



public class PrimaryController {
    private ArrayList<Rutina> rutinas;
    @FXML
    private ComboBox<Rutina> combobox;
    @FXML
    private VBox vbox;
    @FXML
    private ImageView img;
    private Ejercicio ejerci;
    private Thread h = new Thread();



    @FXML
    private void filtrar(ActionEvent event) {
        Rutina rut = combobox.getValue();
        if(rut!=null){
            vbox.getChildren().clear();
            for(Ejercicio ej: rut.getEjercicios()){
                Button b = new Button();
                b.setText(ej.toString());
                vbox.getChildren().add(b);
                vbox.setSpacing(7);
                b.setOnMouseClicked(new ManejadorEvento(ej));
                
            }
        }
    }
    
    
    public void initialize(){
        rutinas = Rutina.cargarListaRutinas("src/main/resources/ec/edu/espol/img/rutinas.txt");
        combobox.getItems().setAll(rutinas);

        
    }
    
    private class ManejadorEvento implements EventHandler<Event>{
        private Ejercicio ej;

        public ManejadorEvento(Ejercicio ej) {
            this.ej = ej;
        }
        
        @Override
        public void handle(Event arg0) {
            if(h.isAlive()){
                h.stop();
            }
            ejerci=ej;
            h = new Thread(new Hilo());
            h.setDaemon(true);
            h.start();
                
            
            
        }
        
    }
    private class Hilo implements Runnable{

        @Override
        public void run() {
            ArrayList<String> imagenes = ejerci.getImagenes();
            for(int i =0; i<ejerci.getRepeticiones(); i++){
                for(String im : imagenes){
                    try (FileInputStream input = new FileInputStream("src/main/resources/ec/edu/espol/img/"+im)){
                        Image imagen = new Image(input,200,200,false,false);
                        Platform.runLater(()->{
                            img.setImage(imagen);
                        });
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    
                }
            }
        }
        
    }
}
