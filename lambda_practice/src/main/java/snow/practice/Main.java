package snow.practice;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.snow.conexiones.*;

public class Main {
    /*
     * mvn install:install-file
     * -Dfile="C:\WorkSpace\Projects\Java\conexionesbd\target\conexionesbd-1.0.jar"
     * -DgroupId="com.snow.conexiones" -DartifactId=conexionesbd -Dversion="1.0"
     * -Dpackaging=jar -DgeneratePom=true
     */
    public static void main(String[] args) {
        Ejecutor claseAnonima = new Ejecutor() {
            @Override
            public int ejecutar(String p) {
                System.out.println("Clase anónima dice: " + p);
                return p.length();
            }
        };

        // Función lambda multilínea
        Ejecutor lambdaMultilineEjecutor = (String p) -> {
            System.out.print("Lambda multilínea dice: ");
            System.out.println(p);
            return p.length();
        };

        // Función lambda de una sola línea
        // La función puede detectar el tipo de parámetro ingresado
        // Cuando la función solo tiene una línea, no es necesario usar return
        Ejecutor lambdaOneLineEjecutor = (p) -> p.length();

        claseAnonima.ejecutar("Hola mundo!");
        lambdaMultilineEjecutor.ejecutar("Hola mundo!");
        int length = lambdaOneLineEjecutor.ejecutar("One line lambda function!");
        System.out.println(length);

        ConexionBD conexion = new ConexionBD(Gestor.MYSQL, "3306", "foursquare", "root", "preciosa2002");
        DQL dql = new DQL(conexion);
        List<Row> rows = dql.getTable("Pais").stream().collect(Collectors.toList());
        conexion.close();
        rows.stream().forEach(System.out::println);

    }
}