package lambda.porDefecto;

public class PorDefectoMain implements PorDefectoInterface {
  public static void main(String[] args) {

    // Usando el metodo default.
    PorDefectoMain porDefecto = new PorDefectoMain();
    System.out.println(porDefecto.nombrePorDefecto("Jesus "));

    // Usando lambda para el metodo no implementado.
    PorDefectoInterface pdi = (nombre) -> {
      System.out.println("Hola " + nombre);
    };
    pdi.mostraNombre("jesus");

    // Usando el metodo que se implemento en el main.
    porDefecto.mostraNombre("jesus");


  }

  // Solo nos pide implementr el metodo no default.
  @Override
  public void mostraNombre(String nombre) {
    System.out.println("Hello from override method" + nombre);

  }


}
