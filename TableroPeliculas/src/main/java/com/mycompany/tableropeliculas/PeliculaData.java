
package com.mycompany.tableropeliculas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PeliculaData {
    private static String FILE_PATH = Constants.RESOURCE_FOULDER+"/peliculas.txt";
    
    
    
    /*
    #######################################
    METODO QUE DADO UN GENERO DE PELICULAS
    RETORNA UNA LISTA CON TODAS LAS PELICULAS
    PERTENECIENTES A ESE GENERO
    #######################################
    */
    public static ArrayList<Pelicula> cargarPelicula(Genero ge) throws IOException{
        ArrayList<Pelicula> pe = new ArrayList<>();
        try(BufferedReader bf = new BufferedReader(new FileReader(FILE_PATH))){
            String linea;
            while ((linea = bf.readLine()) != null){
                String[] p =linea.split(";");
                if(p[1].trim().equals(ge.getCodigo())){
                    pe.add(new Pelicula(ge,
                                        p[0].trim(),
                                        p[4].trim(),
                                        Integer.valueOf(p[3].trim()),
                                        p[5].trim(),
                                        Integer.valueOf(p[2].trim())));
                }
            }
        }
        return pe;
    }
}
