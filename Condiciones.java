import java.util.Scanner;

public class Condiciones {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        
        do {
            System.out.print("Ingrese el primer número: ");
            double numero1 = leer.nextDouble();
            
            System.out.print("Ingrese el segundo número: ");
            double numero2 = leer.nextDouble();
            
            double suma = numero1 + numero2;
            double resta = numero1 - numero2;
            double multiplicacion = numero1 * numero2;
            double division = (numero2 != 0) ? (numero1 / numero2) : Double.POSITIVE_INFINITY;
            
            System.out.println("Suma: " + suma);
            System.out.println("Resta: " + resta);
            System.out.println("Multiplicación: " + multiplicacion);
            System.out.println("División: " + division);
            
            System.out.print("¿Desea realizar otra operación? (Si/No): ");
            String continuar = leer.next();
            
            if (!continuar.equalsIgnoreCase("Si")) {
                System.out.println("Saliendo, fue un placer ayudarte :)");
                break;
            }
            
        }
        while (true);
        
        leer.close();
    }
}




