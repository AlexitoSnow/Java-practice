/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model_controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class Pregunta implements Serializable {
    private String texto;
    private List<String> opciones;
    private String respuesta;
    private Categoria categoria;

    public Pregunta(String texto, List<String> opciones, String respuesta, Categoria categoria) {
        this.texto = texto;
        this.opciones = opciones;
        this.respuesta = respuesta;
        this.categoria = categoria;
    }    

    public String getTexto() {
        return texto;
    }

    public List<String> getOpciones() {
        return opciones;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public Categoria getCategoria() {
        return categoria;
    }
    
}
