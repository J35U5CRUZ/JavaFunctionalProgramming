package lambda.nombre;

public class MiNombreMain {

  public static void main(String[] args) {
    /*
     * Formato de Lambda (Parametris de entrada) -> (Simbolo Lambda) "Body". (n) -> n*n; Devuelve un
     * entero. (n) -> n==2 ; Devuelve un bool Solo es posible usarlas con interfaces funcionales
     */


    // Se implementa la interfaz como clase anonima, sin usar lambdas.
    MiNombreInterface miNombreAnonima = new MiNombreInterface() {

      @Override
      public String miNombre() {
        return "Jesús Cruz";
      }
    };


    MiNombreInterface miNombreLambda = () -> "Jesus Cruz Lambda";
    System.out.println(miNombreAnonima.miNombre());
    System.out.println(miNombreLambda.miNombre());


  }

}
