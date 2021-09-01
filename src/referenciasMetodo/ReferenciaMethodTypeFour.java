package referenciasMetodo;

public class ReferenciaMethodTypeFour {

  public static void main(String[] args) {

    /*
     * Referencia a un Constructor.
     * 
     * Class::new
     * 
     * String::new
     * 
     * ()-> new String
     */

    // Clase anonima.
    UserInterface user = new UserInterface() {

      @Override
      public User crear(String nombre) {
        return new User(nombre);
      }
    };

    User usuarioUno = user.crear("Manuel");
    usuarioUno.mostrarNombre();

    // Con Lambda.
    UserInterface userLambda = (nombre -> new User(nombre));
    User usuarioDos = userLambda.crear("Carlos");
    usuarioDos.mostrarNombre();

    // Con referencia a metodo.
    UserInterface userMD = User::new;
    User usuarioTres = userMD.crear("Alberto");
    usuarioTres.mostrarNombre();
  }

}
