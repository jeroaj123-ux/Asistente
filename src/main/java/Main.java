import java.util.Scanner;
//Profe esta libreria la investigue para no tener que poner una hora fija
//y que se pueda ejecutar en cualquier momento
import java.time.LocalTime;
//Profe esta libreria es necesaria para que la hora no salga super larga con los segundos, milisegundos, con esta puedo darle un formato a la hora
import java.time.format.DateTimeFormatter;

public class Main {
  // Constantes que nunca cambian
  public static final int SALUDAR = 1;
  public static final int REGISTRAR_USUARIO = 2;
  public static final int MOSTRAR_USUARIOS = 3;
  public static final int MOSTRAR_HORA = 4;
  public static final int CONTAR_CHISTE = 5;
  public static final int DAR_CONSEJO = 6;

  public static String[] usuarios = new String[10];

  // Funcion/metodo que permite registrar un usuario
  public static void registrarUsuario(String nombre) {
    for (int posicion = 0; posicion < usuarios.length; posicion++) {
      if (usuarios[posicion] == null) {
        usuarios[posicion] = nombre;
        System.out.println("Usuario registrado correctamente");
        return;
      }
      if (posicion == usuarios.length - 1)
        System.out.println("No se puede registrar el usuario, la lista esta llena");
    }
  }

  public static void mostrarUsuarios() {
    for (int posicion = 0; posicion < usuarios.length; posicion++) {
      if (usuarios[0] == null) {
        System.out.println("No hay usuarios aun, registra uno");
        break;
      } else if (usuarios[posicion] == null) {
        System.out.println("No hay mas usuarios");
        break;
      } else if (usuarios[posicion] != null) {
        System.out.println("-" + usuarios[posicion]);
      }
    }
  }

  public static void contarChiste() {
    String[] chistes = {
        "Porque se divorciaron los 2 metodos en Java?, porque estaban en discusion constante.",
        "¿Por qué los programadores prefieren el café oscuro? Porque el código oscuro es más fácil de leer.",
        "Habia una ves, y ahora hay 2."
    };
    int numeroRandom = (int) (Math.random() * chistes.length);
    System.out.println(chistes[numeroRandom]);
  }

  public static void darConsejo() {
    String[] consejos = {
        "No olvides hacer ejercicio",
        "No olvides comer saludable",
        "No dejes para mañana lo que puedes hacer hoy",
        "Nunca te rindas",
        "Siempre sonrie",
        "Si el codigo funciona, no lo toques"
    };
    int numeroRandom = (int) (Math.random() * consejos.length);
    System.out.println("Papi anote: " + consejos[numeroRandom]);
  }

  public static void main(String[] args) {
    System.out.println(
        "Hola, soy tu amigo/asistente, te ayudare a entretenerte un rato y quitarte 10 minutos de tu vida, asi que, ¿como te llamas?");
    Scanner scannerTexto = new Scanner(System.in);
    Scanner scannerNumero = new Scanner(System.in);
    String nombre = scannerTexto.nextLine();
    System.out.println("Bienvenido " + nombre + "!");

    boolean continuar = true;
    while (continuar == true) {
      System.out.println("Dime que quieres hacer?");
      System.out.println("1. Saludar");
      System.out.println("2. Registrar usuario");
      System.out.println("3. Mostrar usuarios");
      System.out.println("4. Mostrar hora");
      System.out.println("5. Alegrarte el dia (O empeorarlo) con un chiste");
      System.out.println("6. Dar consejo");

      int opcion = scannerNumero.nextInt();
      switch (opcion) {
        case SALUDAR:
          System.out.println("Hola " + nombre);
          break;
        case REGISTRAR_USUARIO:
          System.out.println("Dime el nombre del usuario");
          String nombreUsuario = scannerTexto.nextLine();
          registrarUsuario(nombreUsuario);
          break;
        case MOSTRAR_USUARIOS:
          System.out.println("Los usuarios son:");
          mostrarUsuarios();
          break;
        case MOSTRAR_HORA:
          LocalTime horaActual = LocalTime.now();
          DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm");
          String horaArreglada = horaActual.format(formato);
          System.out.println("La hora actual es: " + horaArreglada);
          break;
        case CONTAR_CHISTE:
          contarChiste();
          break;
        case DAR_CONSEJO:
          darConsejo();
          break;
        default:
          System.out.println("No entiendo");
      }
      if (continuar) {
        System.out.print("Deseas continuar? (si/no): ");
        String respuesta = scannerTexto.nextLine().toLowerCase();
        if (!respuesta.equals("si")) {
          continuar = false;
          System.out.println("Me despido, suerte en tu viaje.");
        }
      }
    }
  }
}