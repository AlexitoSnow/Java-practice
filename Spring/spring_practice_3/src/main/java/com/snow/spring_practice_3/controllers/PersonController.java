package com.snow.spring_practice_3.controllers;

import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.snow.spring_practice_3.models.Person;

@RestController
public class PersonController {
    private static List<Person> people = new ArrayList<>();

    /*static {
        people = new ArrayList<>();
        people.add(new Person("John", "Doe", 30));
        people.add(new Person("Jane", "Doe", 25));
    }*/

    @GetMapping("/")
    public List<Person> getPeople() {
        return people;
    }
    
    /*
     * La forma más sencilla de añadir una persona es con RequestBody
     */

    /**
     * Obteniendo con PathVariable (parámetros en la URL)
     * Ejemplo: http://localhost:8080/PathVariable/Alex+Snow+20
     */
    @GetMapping("/PathVariable/{nombre}+{apellido}+{edad}")
    public Person pathVariable(@PathVariable("nombre") String nombre, @PathVariable("apellido") String apellido, @PathVariable("edad") int edad) {
        return people.stream()
            .filter(person -> person.getNombre().equals(nombre) && person.getApellido().equals(apellido) && person.getEdad() == edad)
            .findFirst()
            .orElse(null);
    }

    /**
     * Obteniendo con RequestParam (URL Query)
     * Ejemplo: http://localhost:8080/RequestParam?nombre=John&apellido=Doe&edad=30
     */
    @GetMapping("/RequestParam")
    public Object requestParam(@RequestParam("nombre") String nombre) {

        return Stream.of("alex","juan","jean","carlos")
            .filter(p -> p.contains(nombre));
    }


    /**
     * Añadiendo con RequestBody (en el body)
     * Ejemplo: http://localhost:8080/
     * Body:
     * {
     *  "nombre": "John",
     *  "apellido": "Doe",
     *  "edad": 30
     * }
     * El JSon se convierte en un objeto de tipo Person, solo necesita tener los mismos atributos
     */
    @PostMapping("/RequestBody")
    public Person addPerson(@RequestBody Person person) {
        people.add(person);
        return person;
    }

    /**
     * Añadiendo una imagen con MultipartFile (en el body)
     */
    @PostMapping(value = "/addMedia")
    public String addMedia(@RequestParam("file") MultipartFile file) throws IOException{
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Path path = Paths.get("assets/imgs/" + fileName);
        file.transferTo(path);
        return "assets/imgs/" + fileName;
    }

    /**
     * Obteniendo una imagen con MediaType.IMAGE_JPEG_VALUE
     */
    @GetMapping(value = "/getMedia", produces = MediaType.IMAGE_PNG_VALUE)
    public @ResponseBody byte[] getMedia(@RequestParam("file") String file) throws IOException{
        Path path = Paths.get("assets/imgs/" + file);
        return Files.readAllBytes(path);
    }

    
}