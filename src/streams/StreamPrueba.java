package streams;

import com.sun.webkit.dom.CSSImportRuleImpl;
import com.sun.xml.internal.ws.policy.privateutil.RuntimePolicyUtilsException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import javax.jws.soap.SOAPBinding.Use;

public class StreamPrueba {


  /*
   * Un stream es una secuencia de elementos. Por ejemplo una lista.
   * 
   * Es un conjunto de funcoiones que se ejecutan de manera anidada.
   * 
   * Son envoltorios alrededor de una fuente de datos, nos permiten operar con esa fuente de datos.
   * 
   */
  private static List<User> users;

  public static void main(String[] args) {
    setUpUser();
    // Stream myStream = Stream.of(users);
    // users.stream(); La lista ya tiene por defecto el metodo stream.
    users.stream().forEach((e) -> e.setNombre(e.getNombre() + " Apellido")); // Foreach una nueva
    // forma de recorrer la
    // lista.
    imprimirLista();

    // Collect saca cosas del estream despues de hacer la operacion.
    // finalmente se convierte el stream de usuario en un string de la clase string.
    List<String> lista = users.stream().map(User::getNombre).collect(Collectors.toList());
    lista.stream().forEach(System.out::println);


    System.out.println("Lista copia");
    List<User> usuariodos = users.stream().collect(Collectors.toList());
    // usuariodos.stream().forEach(System.out::println);

    // null-safe way
    List<User> usuariotres = Optional.ofNullable(users).map(List::stream).orElseGet(Stream::empty)
        .collect(Collectors.toList());

    System.out.println("Lista copia tres");
    // usuariotres.stream().forEach(System.out::println);

    System.out.println();
    System.out.println("--------------------Filters-----------------------------------");
    setUpUser();
    imprimirLista();
    List<User> userFilter = users.stream().filter(e -> e.getNombre() != "Jesus")
        .filter(e -> e.getId() < 4).collect(Collectors.toList());

    System.out.println("lista filtrada");
    userFilter.stream().forEach(e -> System.out.println(e.getId() + " " + e.getNombre()));


    System.out.println("--------------------Find First-----------------------------------");
    setUpUser();
    // Find first devuelve un optional de user, de la primer ocurrencia.
    User user =
        users.stream().filter(e -> e.getNombre().equals("Alberto")).findFirst().orElse(null);

    System.out.println(user.toString());

    // Flapmap te ayuda a unir varias listas en una sola lista.
    System.out.println("--------------------Flap Map-----------------------------------");
    List<List<String>> nombresVariasListas = new ArrayList<List<String>>(
        Arrays.asList(new ArrayList<String>(Arrays.asList("Alberto", "Maria", "Pedro")),
            new ArrayList<String>(Arrays.asList("Monica", "Pablo"))));

    List<String> nombresUnicaList =
        nombresVariasListas.stream().flatMap(e -> e.stream()).collect(Collectors.toList());

    nombresUnicaList.stream().forEach(e -> System.out.println(e));

    // Peek simiirar to foreach sin ser una accion final, se pueden hacer seguir haciendo cosas en
    // el stream.
    // En el stream hay metodos intermedios y metodos finales.

    System.out.println("--------------------Peek-----------------------------------");
    setUpUser();
    List<User> user2 = users.stream().peek(e -> e.setNombre(e.getNombre() + " Apellido"))
        .collect(Collectors.toList());

    // user2.stream().forEach(System.out::println);
    user2.stream().forEach(e -> System.out.println(e.getNombre()));

    System.out.println("--------------------Count-----------------------------------");
    setUpUser();
    long numeroFiltrado = users.stream().filter(e -> e.getId() < 3).count();
    System.out.println("numero filtrado:" + numeroFiltrado);

    System.out.println("--------------------Skip y Limit-----------------------------------");
    String[] abc = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m"};
    List<String> abcFiler = Arrays.stream(abc).skip(2).limit(4).collect(Collectors.toList());
    // abcFiler.stream().forEach(e -> System.out.println(e));
    abcFiler.stream().forEach(System.out::println);

    System.out.println("--------------------Sorted-----------------------------------");
    setUpUser();
    users = users.stream().sorted(Comparator.comparing(User::getNombre)).filter(e -> e.getId() < 5)
        .collect(Collectors.toList());

    imprimirLista();
    System.out.println("--------------------MAx/ MIn-----------------------------------");
    setUpUser();
    User userMin = users.stream().min(Comparator.comparing(User::getId)).orElse(null);
    System.out.println(userMin.getId());
    User userMax = users.stream().max(Comparator.comparing(User::getId)).orElse(null);
    System.out.println(userMax.getId());

    String[] abcedario = {"a", "c", "c", "d", "d", "f", "g", "h", "i", "j", "k", "l", "m"};


    System.out.println("--------------------Distinc-----------------------------------");
    List<String> abcFilter1 = Arrays.stream(abcedario).distinct().collect(Collectors.toList());
    abcFilter1.stream().forEach(e -> System.out.println(e));

    setUpUser();
    List<String> usersnorepeat =
        users.stream().map(User::getNombre).distinct().collect(Collectors.toList());
    usersnorepeat.stream().forEach(System.out::println);


    System.out.println("\n\n--------------AllMacth, anyMatch, noneMatch-----------");
    List<Integer> listaNumeros = Arrays.asList(100, 200, 300, 5000, 20000);
    boolean allMatch = listaNumeros.stream().allMatch(e -> e > 200);
    System.out.println("allMatch value " + allMatch);

    boolean anyMatch = listaNumeros.stream().anyMatch(e -> e > 200);
    System.out.println("AnyMatch value " + anyMatch);

    boolean noMatch = listaNumeros.stream().noneMatch(e -> e > 50000);
    System.out.println("noMatch value " + noMatch);
    System.out.println("\n\n--------------Sum, average, range-----------");
    setUpUser();
    double resultaver = users.stream().mapToInt(User::getId).average().orElse(0);
    System.out.println(resultaver);
    double resultsum = users.stream().mapToInt(User::getId).sum();
    System.out.println(resultsum);

    // Crea una lista de numeros a partir de InsStream.
    List<Integer> nums = IntStream.range(0, 10).boxed().collect(Collectors.toList());
    nums.stream().forEach(e -> System.out.println(e));

    // Suma de un range.
    System.out.println(IntStream.range(0, 100).sum());


    System.out.println("\n\n--------------Reduce-----------");
    // Reduccion, toma el stream y lo convina en un unico resultado
    setUpUser();
    int numero = users.stream().map(User::getId).reduce(1000, Integer::sum);
    System.out.println("numero: " + numero);


    List<String> letters = Arrays.asList("a", "b", "c", "d", "e");
    String result =
        letters.stream().reduce("0", (partialString, element) -> partialString + element);
    System.out.println(result);

    result = "";
    result = letters.stream().reduce("", String::concat);

    System.out.println(result);

    String resulta = letters.stream().reduce("",
        (partialString, element) -> partialString.toUpperCase() + element.toUpperCase());

    System.out.println(resulta);

    List<Integer> ages = Arrays.asList(1, 2, 3, 4, 5);
    int computedAges = ages.parallelStream().reduce(0, Integer::sum, Integer::sum);

    System.out.println(computedAges);

    List<Person> people = Arrays.asList(new Person("John", 30), new Person("Julie", 35));

    int computedAgesdos = people.stream().reduce(0,
        (partialAgeResult, person) -> partialAgeResult + person.getEdad(), Integer::sum);

    int resultperson = people.stream().reduce(0,
        (partialAgeResult, person) -> partialAgeResult + person.getEdad(), Integer::sum);

    System.out.println("\n\n--------------Joining-----------");
    setUpUser();
    String names =
        users.stream().map(e -> e.getNombre()).collect(Collectors.joining("- ")).toString();
    System.out.println(names);
    String ids = users.stream().map(User::getId).map(e -> e.toString())
        .collect(Collectors.joining("-")).toString();
    System.out.println(ids);

    System.out.println("\n\n--------------Set-----------");
    setUpUser();

    Set<String> setNames = users.stream().map(User::getNombre).collect(Collectors.toSet());
    setNames.stream().forEach(e -> System.out.println(e));

    System.out.println("\n\n--------------SummarizingDouble-----------");
    setUpUser();

    DoubleSummaryStatistics statistics =
        users.stream().collect(Collectors.summarizingDouble(User::getId));
    System.out.println(statistics);

    DoubleSummaryStatistics statistics1 =
        users.stream().mapToDouble(User::getId).summaryStatistics();

    System.out.println(statistics1);


    System.out.println("\n\n--------------PartitioningBy-----------");
    setUpUser();

    List<Integer> numeros = Arrays.asList(5, 7, 54, 56, 67, 4, 98, 1, 8, 12, 0, 13);

    Map<Boolean, List<Integer>> esMayor =
        numeros.stream().sorted().collect(Collectors.partitioningBy(e -> e > 10));
    System.out.println("True");
    esMayor.get(true).stream().forEach(e -> System.out.println(e));
    System.out.println("False");
    esMayor.get(false).stream().forEach(e -> System.out.println(e));


    System.out.println("\n\n--------------GroupBy-----------");
    setUpUser();
    Map<Character, List<User>> grupoAlfabeto =
        users.stream().collect(Collectors.groupingBy(e -> new Character(e.getNombre().charAt(0))));
    grupoAlfabeto.get('A').stream().forEach(e -> System.out.println(e.getNombre()));
    grupoAlfabeto.get('C').stream().forEach(e -> System.out.println(e.getNombre()));

    System.out.println("\n\n--------------Mapping-----------");
    setUpUser();
    List<String> personas =
        users.stream().collect(Collectors.mapping(User::getNombre, Collectors.toList()));
    System.out.println("\nLista Personas");
    personas.stream().forEach(e -> System.out.println(e));

    System.out.println("\n\nLista PersonasDos");
    List<String> personasDos = users.stream().map(User::getNombre).collect(Collectors.toList());
    personasDos.stream().forEach(e -> System.out.println(e));

    System.out.println("\n\n--------------Stream paralelo-----------");
    setUpUser();
    lista.stream().forEach(System.out::println);
    long timeOne = System.currentTimeMillis();
    lista.stream().forEach(e -> convertirMayuscular(e));
    long timeDos = System.currentTimeMillis();

    System.out.println("Stream normal" + (timeDos - timeOne));


    timeOne = System.currentTimeMillis();
    lista.parallelStream().forEach(e -> convertirMayuscular(e));
    timeDos = System.currentTimeMillis();

    System.out.println("paralelo:" + (timeDos - timeOne));

  }

  private static String convertirMayuscular(String nombreEntrada) {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return nombreEntrada.toUpperCase();
  }

  private static void setUpUser() {
    users = new ArrayList<User>();

    users.add(new User(1, "Alberto"));
    users.add(new User(2, "Alberto"));
    users.add(new User(3, "Alberto"));
    users.add(new User(4, "Jesus"));
    users.add(new User(5, "Maricelna"));
    users.add(new User(6, "Claudia"));
    users.add(new User(7, "Alberto"));
    users.add(new User(8, "Angeles"));
    users.add(new User(9, "Chino"));
  }

  public static void imprimirLista() {
    users.stream().forEach(e -> {
      System.out.println(e.toString());
    });
  }


}
