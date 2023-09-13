/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model_controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author USER
 */
public class Examen {
    private List<Pregunta> listaPreguntas;
    private int tiempo;

    public Examen(int tiempo){
        this.tiempo = tiempo;
        //this.listaPreguntas = Pregunta.cargarPreguntas();
    }

    public List<Pregunta> getListaPreguntas() {
        return listaPreguntas;
    }

    public int getTiempo() {
        return tiempo;
    }

}
