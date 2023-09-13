package snow.practice;

/**
 * Es una interfaz que solo contiene un método abstracto.
 * Permite métodos por defecto y métodos estáticos.
 */
@FunctionalInterface
public interface Ejecutor {
    int ejecutar(String param);
}
