package lambda.suma;

/*
 * Interfaz funcional, solo tiene un metodo abstracto.
 */

@FunctionalInterface // Indica que es una interfaz funcional
public interface Sumar {
  int suma(int a, int b);
}
