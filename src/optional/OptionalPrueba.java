package optional;

import java.nio.channels.UnsupportedAddressTypeException;
import java.util.Optional;

/*
 * La principal funcional de los optional, es reducir la cantidad de nullpointerexecption en el
 * proyecto,
 * 
 * Es un envoltorio de un tipo de dato.
 */
public class OptionalPrueba {

  public static void main(String[] args) {
    // probarOptional(null);
    // orElseOptional(null);
    orElseThrow("jesus");
    // isPresent(null);
  }

  public static void probarOptional(String nombre) {
    System.out.println(nombre.length());
  }


  public static void crearOptional() {
    Optional<String> optional = Optional.empty(); // Optional vacio.
    optional.get(); // Para obtener el tipo de dato se llama al metodo get.
  }

  public static void orElseOptional(String nombre) {
    Optional<String> optional = Optional.ofNullable(nombre); // Acepta null en la variable
    // nombre.
    // Optional<String> optional1 = Optional.of(nombre); // No aceota null en la variable nombre,
    // lanza
    // una exepcion.

    String nombreOfNullAble = optional.orElse("default"); // LE asiganamos un valor default en
    // caso
    // de que llegue en null.

    // String nombreOf = optional1.orElse("Vacio");

    System.out.println(nombreOfNullAble);
    // System.out.println(optional1.orElse("vacio"));


  }

  public static void orElseThrow(String nombre) {
    Optional<String> optional = Optional.ofNullable(nombre);
    optional.orElseThrow(NullPointerException::new);
    String nombre1 = optional.get();
    System.out.println(nombre1);
  }

  public static void isPresent(String nombre) {
    Optional<String> optional = Optional.ofNullable(nombre);
    System.out.println(optional.isPresent());
  }

}
