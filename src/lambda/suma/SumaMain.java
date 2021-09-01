package lambda.suma;

/**
 * Ejemplo de interfaz funcional.
 * 
 * @author jesus
 *
 */
public class SumaMain {

  public static void main(String[] args) {

    // Antes de java8

    Sumar suma = new Sumar() {

      @Override
      public int suma(int a, int b) {

        return a + b;
      }
    };

    // Ejemplo con Java8 Lambda
    System.out.println(suma.suma(2, 3));

    Sumar sumaLambda = (a, b) -> a + b;

    System.out.println(sumaLambda.suma(3, 4));


    // Body con expresiones.
    Sumar sumaLambdaDos = (a, b) -> {

      a = b * b;
      a = a + b;

      System.out.println("Mensaje dentro de lambda");

      return a;
    };

    System.out.println(sumaLambdaDos.suma(2, 3));

  }

}
