/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.mavenproject3;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Rutina {
    private String nombre;
    private ArrayList<Ejercicio> ejercicios;
    
    public Rutina(String nombre, ArrayList<Ejercicio> ejercicios){
        this.nombre = nombre;
        this.ejercicios = ejercicios;
    }
    
    public static ArrayList<Rutina> cargarListaRutinas(String nombreArchivo){
        ArrayList<Rutina> rutinas = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))){
            String line;
            while((line=br.readLine())!= null){
                ArrayList<Ejercicio> ejercicios = new ArrayList<>();
                String[] datos = line.split(";");
                String nombre = datos[0];
                for(int i = 1; i<datos.length; i++){
                    ArrayList<String> imagenes = new ArrayList<>();
                    String[] datos2 = datos[i].split(",");
                    imagenes.add(datos2[2]);
                    imagenes.add(datos2[3]);
                    int repet = Integer.valueOf(datos2[1]);
                    Ejercicio eje = new Ejercicio(datos2[0],repet,imagenes);
                    ejercicios.add(eje);
                }
                Rutina ru = new Rutina(nombre,ejercicios);
                rutinas.add(ru);
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        return rutinas;
        
        
        
    }

    public ArrayList<Ejercicio> getEjercicios() {
        return ejercicios;
    }

    @Override
    public String toString() {
        return nombre ;
    }

    
    
}