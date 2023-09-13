/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tableropeliculas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class CartelPeliculasController implements Initializable {

    @FXML
    private BorderPane root;
    @FXML
    private ComboBox<Genero> generosPeliculas;
    @FXML
    private FlowPane panelPeliculas;
    @FXML
    private VBox detallePelicula;
    
    /**
     * 
     * 
     */
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            /*
            ##############################
            LLENAR EL COMBO BOX DE GENEROS
            ##############################
            */
            try{
                generosPeliculas.getItems().addAll(GenerarData.cargarGeneros());
            } catch(IOException e){
                //Reescribir el top del borderpane
                root.setTop(new Label(e.getMessage()));
            }
            
//            Manejar eventos usando lambda
//            panelPeliculas.getChildren().clear();
//              generosPeliculas.setOnAction(e -> {
//                Genero genero = generosPeliculas.getValue();
//                ArrayList<Pelicula> peliculas = new ArrayList<>();
//                try {
//                    peliculas = PeliculaData.cargarPelicula(genero);
//                } catch (IOException ex) {
//                    ex.printStackTrace();
//                }
//                for(Pelicula pelicula : peliculas){
//                    Label peliculaLbl = new Label(pelicula.getNombre() + "\n" + pelicula.getYear());
//                    ImageView imagen = new ImageView();
//                    try {
//                        imagen = new ImageView(new Image(new FileInputStream("recursos/" + pelicula.getImageName())));
//                    } catch (FileNotFoundException ex) {
//                        ex.printStackTrace();
//                    }
//                    peliculaLbl.setGraphic(imagen);
//                    peliculaLbl.setContentDisplay(ContentDisplay.TOP);
//                    panelPeliculas.getChildren().add(peliculaLbl);
//                }
//
//            });
    }

    //Manejar eventos usando FXML
    @FXML
    private void mostrarPeliculas(ActionEvent event) throws IOException {
        /*
        ##################################
        COMPLETAR ESTE METODO
        ##################################
        */
        panelPeliculas.getChildren().clear();
        Genero genero = generosPeliculas.getValue();
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        try {
            peliculas = PeliculaData.cargarPelicula(genero);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        for(Pelicula pelicula : peliculas){
            Label peliculaLbl = new Label(pelicula.getNombre() + "\n" + pelicula.getYear());
            Image peli = new Image(new FileInputStream("recursos/" + pelicula.getImageName()));
            ImageView imagen = new ImageView(peli);
            peliculaLbl.setGraphic(imagen);
            peliculaLbl.setContentDisplay(ContentDisplay.TOP);
            //Manejador para el detalle
            peliculaLbl.setOnMouseClicked(eh -> {
                detallePelicula.getChildren().clear();
                Image estrella = null;
                try {
                    estrella = new Image(new FileInputStream("recursos/star.png"),25,25,false,false);
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                HBox estrellitas = new HBox();
                for(int i = 0; i < pelicula.getRating(); i++){
                    //Agregando estrellas segun el rating
                    estrellitas.getChildren().add(new ImageView(estrella));
                }
                Label detalles = new Label("Nombre: " + pelicula.getNombre() +
                        "\nDirector: " + pelicula.getDirector() + "\nAño: " + pelicula.getYear());
                detallePelicula.getChildren().addAll(new ImageView(peli), estrellitas, detalles);
            });
            panelPeliculas.getChildren().add(peliculaLbl);
        }
    }
    
}
