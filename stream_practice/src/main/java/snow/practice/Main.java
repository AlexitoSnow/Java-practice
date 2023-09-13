package snow.practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        /*
         * 1. Obtener un Stream a partir de una colección o una fuente de datos.
         * 2. Realizar las operaciones deseadas en el Stream, como filtrar, mapear o
         * reducir elementos.
         * 3. Terminar el Stream, ya sea recolectando los elementos resultantes o
         * realizando una operación final.
         */

        List<String> lista = Arrays.asList("a", "A", "c", "3", "T");
        Stream<String> stringStream = lista.stream(); // no tiene método toString()

        // collect permite transformar un stream en una colección
        List<String> stringList = stringStream.collect(Collectors.toList());
        System.out.println(stringList);

        // el stream ya fue consumido por lo que se vuelve a crear
        stringStream = lista.stream();

        // filtrado de elementos
        // la función lambda pasada como parámetro debe retornar un booleano
        Stream<String> stringStreamFilter = stringStream
                .filter(value -> value.equals(value.toUpperCase()));
        System.out.println(stringStreamFilter.collect(Collectors.toList()));

        stringStream = lista.stream();

        // mapeo de elementos (transformación)
        // la función lambda pasada como parámetro debe retornar un valor del mismo tipo
        // que el stream
        Stream<String> stringStreamMap = stringStream
                .map(value -> value.equals(value.toUpperCase()) ? value.toLowerCase() : value.toUpperCase());
        System.out.println(stringStreamMap.collect(Collectors.toList()));

        stringStream = lista.stream();

        // conteo de elementos
        long count = stringStream.count();
        System.out.println(count);

        stringStream = lista.stream();

        // anyMatch retorna true si al menos un elemento cumple con la condición
        boolean anyMatch = stringStream.anyMatch(value -> value.matches("[0-9]"));
        System.out.println(anyMatch);

        stringStream = lista.stream();

        // allMatch retorna true si todos los elementos cumplen con la condición
        boolean allMatch = stringStream.allMatch(value -> value.matches("[0-9]"));
        System.out.println(allMatch);

        stringStream = Stream.of("Alvarito", "Juanito", "Vaca", "Pera", "Manzana", "Esmeralda", "juanete");

        // Operaciones anidadas
        // Se pueden realizar varias operaciones en un mismo stream
        Stream<Integer> integerStream = stringStream
                .filter(value -> value.length() > 5)
                .map(value -> value.length());
        System.out.println(integerStream.collect(Collectors.toList()));

    }
}