package referenciasMetodo;

public class ReferenciaMethodTypeOne {

  public static void main(String[] args) {

    /**
     * Referencia a static Method.
     * 
     * Class::staticMethod Math:abs Referencia a metodo
     * 
     * n->Maths.abs(n) Expresion lambda equivalente
     * 
     */

    // Con clase anonima.
    Trabajo trabajo = new Trabajo() {

      @Override
      public void accion() {
        User.referenciaMetodoEstatico();
      }
    };
    trabajo.accion();

    // Con expresion lambda.
    Trabajo trabajoLambda = () -> User.referenciaMetodoEstatico();
    trabajoLambda.accion();

    // Con referencia a metodo estatico.
    Trabajo trabajoMR = User::referenciaMetodoEstatico;
    trabajoMR.accion();

  }

}
