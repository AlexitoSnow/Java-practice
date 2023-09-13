
package com.mycompany.tableropeliculas;

public class Genero implements Comparable<Genero> {
    private String codigo;
    private String nombre;
    
    public Genero(String nombre, String codigo){
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public String toString(){
        return nombre;
    }
    
    @Override
    public int compareTo(Genero ge){
        return nombre.compareTo(ge.getNombre());
    }
    
}
