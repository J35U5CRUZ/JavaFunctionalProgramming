package referenciasMetodo;

public class ReferenciaMethodTypeTwo {
  public static void main(String[] args) {

    /*
     * Referencia a un metodo de instancia de un objeto particular.
     * 
     * instancia::metodoInstancia
     * 
     * s:toString ()->"string".toString Expresion lambda equivalente.
     */

    // Con expresion lambda.
    User user = new User("Jesus"); // Insancia de objeto real.
    Trabajo trabajo = () -> user.referenciaAMetodoParticular();
    trabajo.accion();

    // Con referencia a metodo.
    Trabajo trabajoMR = user::referenciaAMetodoParticular;
    trabajoMR.accion();



  }
}
