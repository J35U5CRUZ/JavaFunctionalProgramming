package lambda.porDefecto;

/*
 * Apartir de Java 8 se pueden tener metodos por defecto.
 */
public interface PorDefectoInterface {
  void mostraNombre(String nombre);

  /*
   * Implementamos un metodo default.
   */
  default String nombrePorDefecto(String nombre) {//Se añade la palabra reservada default
    return nombre + "Default   ";
  }
}
