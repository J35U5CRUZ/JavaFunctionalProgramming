package referenciasMetodo;

public class User {

  private String nombre;

  public User(String nombre) {
    this.nombre = nombre;
  }

  public static void referenciaMetodoEstatico() {
    System.out.println("Probando referencia a  Método Estatico");
  }

  public void referenciaAMetodoParticular() {
    System.out.println("Prbando referencia a metod particular");
  }

  public void mostrarNombre() {
    System.out.println(nombre.toUpperCase());
  }
}
