/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.mavenproject3;

import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class Ejercicio implements Comparable<Ejercicio>{
    private String nombre;
    private int repeticiones;
    private ArrayList<String> imagenes;
    
    public Ejercicio(String nombre, int repticiones, ArrayList<String> imagenes){
        this.nombre = nombre;
        this.repeticiones = repticiones;
        this.imagenes = imagenes;
    }

    public String getNombre() {
        return nombre;
    }

    public int getRepeticiones() {
        return repeticiones;
    }

    public ArrayList<String> getImagenes() {
        return imagenes;
    }


    @Override
    public int compareTo(Ejercicio arg0) {
        if(this.nombre.compareTo(arg0.nombre)==0){
            if(this.repeticiones==arg0.repeticiones){
                return 0;
            }else if(this.repeticiones>arg0.repeticiones){
                return 1;
            }else{
                return -1;
            }
        }
        else if(this.nombre.compareTo(arg0.nombre)>0){
            return 1;
        }else{
            return -1;
        }
    }

    @Override
    public String toString() {
        return repeticiones+" "+nombre;
    }
    
    
}