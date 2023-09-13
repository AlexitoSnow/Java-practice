package com.mycompany.tableropeliculas;

public class Pelicula {
    private Genero genero;
    private String nombre;
    private String director;
    private int rating;
    private String imageName;
    private int year;
    
    public Pelicula(Genero genero, String nombre, String director,
                    int rating, String imagePath, int year){
        this.genero = genero;
        this.nombre = nombre;
        this.director = director;
        this.rating = rating;
        this.imageName = imagePath;
        this.year = year;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return  nombre ;
    }
    
    
    
    
    
}
