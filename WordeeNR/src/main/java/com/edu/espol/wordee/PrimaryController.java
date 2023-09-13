package main.java.com.edu.espol.wordee;
 
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
/**
 *
 * @author  
 */

public class PrimaryController implements Initializable {

    private int intento;
    private String fraseAdvinar;
    @FXML
    private VBox panelFrases;

    @Override   
    public void initialize(URL url, ResourceBundle rb) {
        WordeePOO wp = new WordeePOO("frases.txt");
        fraseAdvinar = wp.seleccionarFrase();
        crearTextFields();
    }
    
    //crea un hbox con 5 cajas de texto y lo agrega al panelFrases
    private void crearTextFields() {
        HBox contenedor = new HBox();
        for(int i = 0; i < 5; i++){
            //creando y agregando los 5 textfield
            contenedor.getChildren().add(new TextField());
        }
        //agregando el hbox al vbox root
        panelFrases.getChildren().add(contenedor);
    }
    
    //Método asociado al botón Verificar
    @FXML
    private void verificar() throws IOException {
        HBox contenedor = (HBox) panelFrases.getChildren().get(intento);
        ArrayList<String> fraseUsuario = new ArrayList<>();
        ArrayList<String> aAdivinar = new ArrayList<>();
        //frase que nos da el sistema para que el usuario adivine
        for(String palabra : fraseAdvinar.split(" ")){
            aAdivinar.add(palabra); //["palabra1","palabra2","palabra3"...]
        }
        
        //Pintando los textfields
        for(int i = 0; i < 5; i++){
            //Guardando la frase del usuario
            TextField campo = (TextField) contenedor.getChildren.get(i);
            fraseUsuario.add(campo.getText()); //["palabraUsuario1",...,"palabraUsuario5"]
            campo.setDisable(true);
            if(fraseUsuario.get(i).equals(aAdivinar.get(i))){ //Si es la misma palabra
                campo.setStyle("-fx-control-inner-background: green;");
            } else if(aAdivinar.contains(fraseUsuario.get(i)))
                campo.setStyle("-fx-control-inner-background: yellow;");
            else
                campo.setStyle("-fx-control-inner-background: red;");
        }
        //Mensajes de alerta
        //cuando gana
        if(fraseUsuario.equals(aAdivinar)){
            mostrarAlerta(Alert.Alertype.INFORMATION, "Haz Ganado");
        } else {
            intento++;
            if (intento == 6) {
                mostrarAlerta(Alert.Alertype.ERROR, "Se agotaron tus intentos");
            } else {
                mostrarAlerta(Alert.Alertype.INFORMATION, "Te quedan " + (6 - intento) + " intentos restantes");
                crearTextFields();
            }
        }
    }
    
    public void mostrarAlerta(Alert.AlertType tipo, String mensaje) {
        Alert alert = new Alert(tipo);

        alert.setTitle("Resultado de operacion");
        alert.setHeaderText("Notificacion");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

}