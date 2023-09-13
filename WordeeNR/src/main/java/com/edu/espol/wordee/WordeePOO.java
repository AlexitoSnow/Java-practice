/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.edu.espol.wordee;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class WordeePOO {
    private List<String> frases;

    public WordeePOO(String archivo) {
        cargarFrases(archivo);
    }
    
    /**
     * Selecciona aleatoriamente una frase de la lista de frases
     * @return String con frase aleatoria
     */
    public String seleccionarFrase(){
        String frase;
        Random random = new Random();
        do{
            int indice = random.nextInt(frases.size()); // Aleatorio entre 0 y la longitud de la lista
            frase = frases.get(indice);
        } while(frase.split(" ").length != 5);
        return frase;
    }
    
    /**
     * Inicializa y llena la variable de instancia frases con las frases que se
     * encuentran en el archivo
     * @param archivo nombre del archivo a leer
     */
    private void cargarFrases(String archivo){
        frases = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))){
            String line;
            while((line = br.readLine()) != null){
                frases.add(line);
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
