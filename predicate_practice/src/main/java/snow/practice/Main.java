package snow.practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {

        // Predicado es un interface funcional que define una condición que un objeto
        // determinado debe cumplir
        Predicate<String> cadenaIgual = s -> s.equals("Java");

        System.out.println(cadenaIgual.test("Java"));

        Predicate<Integer> numeroPositivo = n -> n > 0;

        System.out.println(numeroPositivo.test(-1));

        List<String> lista = Arrays.asList("Java", "PHP", "C#", "Python");
        Stream<String> streamList = lista.stream();

        Predicate<String> contieneH = s -> s.toUpperCase().contains("H");

        // List<String> result =
        // streamList.filter(contieneH).collect(Collectors.toList());

        Consumer<String> toUpperCase = new Consumer<String>() {
            @Override
            public void accept(String t) {
                System.out.println(t.toUpperCase());
            }
        };

        toUpperCase.accept("null");

        streamList.filter(contieneH).forEach(toUpperCase);

        streamList = lista.stream();
        streamList.forEach(System.out::println);

        System.out.println(lista);
        // System.out.println(result);

        // Function<String, List<String>> toList = s -> List.of(s);
        Function<String, List<String>> toList = new Function<String, List<String>>() {
            @Override
            public List<String> apply(String t) {
                return List.of(t);
            }
        };
        System.out.println(toList.apply("Java"));
        streamList = lista.stream();

        // streamList.map(s -> List.of(s)).forEach(System.out::println);
        streamList.map(toList).forEach(System.out::println);
    }
}