import java.util.Scanner;

public class Contrasena2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String contrasenaIngresada;
        String nuevaUsuario;
        String nuevaContrasena = null;

                System.out.print("Ingrese un nombre de usuario: ");
                 nuevaUsuario = scanner.nextLine();
                System.out.println("Usuario guardado con éxito: " + nuevaUsuario);

                System.out.print("Ingrese una nueva contraseña: " );
                nuevaContrasena = scanner.nextLine();
                System.out.println("Contraseña guardado con éxito ");

        do {
            System.out.print("Ingrese la contraseña: ");
            contrasenaIngresada = scanner.nextLine();

            if (contrasenaIngresada.equals(nuevaContrasena)) {
                System.out.println("Contraseña correcta, Acceso concedido. Bienvenido " + nuevaUsuario);
                break; // Salir del bucle si la contraseña es correcta

            } else {
                System.out.println("Contraseña incorrecta. Inténtelo nuevamente.");
            }

        } while (true);

        scanner.close();
    }
}
