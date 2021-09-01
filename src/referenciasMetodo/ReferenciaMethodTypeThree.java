package referenciasMetodo;

import java.util.ArrayList;
import java.util.List;
import javax.jws.soap.SOAPBinding.Use;

public class ReferenciaMethodTypeThree {
  /*
   * Referencia a un metodo de instancia de un objeto arbitrario de un tipo particular.
   * 
   * Class::metodoInstancia
   * 
   * String::toString
   * 
   * s -s.toString() Expresion lambda equivalente
   */
  public static void main(String[] args) {

    // Con expresion lambda.
    TrabajoToString trabajoString = (palabra) -> {
      return palabra.toUpperCase();
    };

    System.out.println(trabajoString.accion("Jesus"));

    // Con referencia a metodo.
    TrabajoToString trabajoToStringRM = String::toUpperCase;

    System.out.println(trabajoToStringRM.accion("cruz hernandez"));

    // Creamos una lista de usuarios.
    List<User> users = new ArrayList<User>();
    users.add(new User("Alberto"));
    users.add(new User("Jesus"));
    users.add(new User("Alfonso"));
    users.add(new User("Reynaldo"));

    // Imprimmos la lista con lambdas.
    System.out.println("Imprime la lista con lambda");
    users.forEach(nombre -> nombre.mostrarNombre());

    // Imprimimos la lista con una refencia a metodo.
    System.out.println("Imprime la lista con metodo de referencia");
    users.forEach(User::mostrarNombre);

  }


}
