import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Taller4 {

    static String[] getNombresDeCasas(int size) {
        String[] response = new String[size];
        Random random = new Random();

        String[] prefijos = { "la", "una" };
        String[] mid = { "cueva", "casa", "mansión" };
        String[] suf = {
                "de la montaña",
                "del bosque",
                "del pantano",
                "del desierto",
                "de Drácula",
                "de la bruja",
                "del vampiro",
        };

        for (int i = 0; i < size; i++) {
            int randPref = random.nextInt(prefijos.length);
            int randMid = random.nextInt(mid.length);
            int randSuf = random.nextInt(suf.length);
            response[i] = prefijos[randPref] + " " + mid[randMid] + " " + suf[randSuf];
        }
        return response;
    }

    static int[] getPrices(int size) {
        int[] response = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            response[i] = random.nextInt(1000000);
        }
        return response;
    }

    public static void main(String[] args) {
        // Asociadas
        String[] nombresDeCasas = getNombresDeCasas(10);
        int[] prices = getPrices(10);

        // Aleatoria
        String[] nombreBarrios = {
                "Floresta",
                "Aranjuez",
                "Manrique",
                "Carlos E",
                "Robledo",
        };

        HashMap<String, Integer> ventas = new HashMap<String, Integer>();

        for (String barrio : nombreBarrios) {
            ventas.put(barrio, 0);
        }

        int userEntry = 0;
        Random rnd = new Random();
        Scanner scner = new Scanner(System.in);
        // 0 para descartar
        // 1 para comprar
        // 2 para finalizar

        System.out.println("¡Hola te doy la bienvenida a Tinder House!");
        System.out.println("El juego consiste en hacer match con cada casa que te guste");
        System.out.println("presiona 0 para descartar, 1 para comprar y 2 para terminar el juego");
        do {
            // Aqui va el juego
            int randCasa = rnd.nextInt(nombresDeCasas.length);
            int randBarrio = rnd.nextInt(nombreBarrios.length);
            int randPrice = rnd.nextInt(prices.length);
            System.out.println("------*-------");
            System.out.println(nombresDeCasas[randCasa]);
            System.out.println(nombreBarrios[randBarrio]);
            System.out.println(prices[randPrice] + " Bolivares");
            System.out.println("------*-------");
            userEntry = scner.nextInt();
            if (userEntry == 1) {
                int actualVenta = ventas.get(nombreBarrios[randBarrio]);
                int newVenta = actualVenta + prices[randPrice];
                ventas.replace(nombreBarrios[randBarrio], newVenta);
            }
        } while (userEntry != 2);

        System.out.println("Reporte de ventas:");

        for (String barrio: ventas.keySet()){
            System.out.println(barrio + " vendió "+ ventas.get(barrio));
        }  
        
        
    }

public class Taller4 {
    // HashMap para almacenar las ventas por barrio
    private static HashMap<String, Double> ventasPorBarrio = new HashMap<>();
    // HashMap para almacenar los pesos de los barrios
    private static HashMap<String, Integer> pesosPorBarrio = new HashMap<>();

    public static void main(String[] args) {

        mostrarResultados();
    }

    
    private static String generarNombreCasa() {
       
        return "NombreCasa";
    }

    private static double generarPrecio(String barrio) {
        // Lógica para generar un precio
        int peso = pesosPorBarrio.getOrDefault(barrio, 1); 
        return Math.random() * 100000 * peso; 
    }

    private static void mostrarResultados() {
        // Calcular el barrio que más dinero ganó y el que menos dinero ganó
        String barrioMasGanador = "";
        String barrioMenosGanador = "";
        double maxVentas = Double.MIN_VALUE;
        double minVentas = Double.MAX_VALUE;

        // Calcular el barrio que más casas vendió
        String barrioMasCasasVendidas = "";
        int maxCasasVendidas = Integer.MIN_VALUE;

        for (Map.Entry<String, Double> entry : ventasPorBarrio.entrySet()) {
            String barrio = entry.getKey();
            double ventas = entry.getValue();

            // Actualizar el barrio que más dinero ganó y el que menos dinero ganó
            if (ventas > maxVentas || (ventas == maxVentas && pesosPorBarrio.get(barrio) < pesosPorBarrio.get(barrioMasGanador))) {
                barrioMasGanador = barrio;
                maxVentas = ventas;
            }

            if (ventas < minVentas || (ventas == minVentas && pesosPorBarrio.get(barrio) > pesosPorBarrio.get(barrioMenosGanador))) {
                barrioMenosGanador = barrio;
                minVentas = ventas;
            }

       
            if (ventas > maxCasasVendidas || (ventas == maxCasasVendidas && pesosPorBarrio.get(barrio) > pesosPorBarrio.get(barrioMasCasasVendidas))) {
                barrioMasCasasVendidas = barrio;
                maxCasasVendidas = (int) ventas;
            }
        }

        System.out.println("Barrio que más dinero ganó: " + barrioMasGanador);
        System.out.println("Barrio que menos dinero ganó: " + barrioMenosGanador);
        System.out.println("Barrio que más casas vendió: " + barrioMasCasasVendidas);
    }

}
}