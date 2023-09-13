
package com.mycompany.tableropeliculas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GenerarData {
    private static String FILE_PATH = Constants.RESOURCE_FOULDER+"/generos.txt";
    
    public static ArrayList<Genero> cargarGeneros() throws IOException{
        ArrayList<Genero> listaRetorno = new ArrayList<>();
        
        /*
        ###################################################
        COMPLETAR EL METODO QUE LEERA EL ARCHIVO DE GENEROS
        ###################################################
        */
        
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(";");
                listaRetorno.add(new Genero(datos[0],datos[1]));
            }
        } catch (Exception e) {
        }
        
        return listaRetorno;
       
       
    }
}
