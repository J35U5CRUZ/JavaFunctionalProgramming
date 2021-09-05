package streams;

public class User {
  private int id;



  private String nombre;

  public int getId() {
    return id;
  }

  public User(User usuario) {}

  public User(int id, String nombre) {
    this.nombre = nombre;
    this.id = id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  /**
   * Metodo override tostring.
   */
  @Override
  public String toString() {
    return id + " " + nombre;
  }


}
