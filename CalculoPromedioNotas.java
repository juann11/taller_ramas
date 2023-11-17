import java.util.Scanner;

public class CalculoPromedioNotas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedir el nombre del usuario
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();

        // Pedir la cantidad de materias
        System.out.print("Ingrese la cantidad de materias: ");
        int numMaterias = scanner.nextInt();

        // Crear una matriz para almacenar las notas y porcentajes de cada materia
        double[][] notasPorcentajes = new double[numMaterias][];

        // Pedir notas y porcentajes para cada materia
        for (int i = 0; i < numMaterias; i++) {
            System.out.print("Ingrese la cantidad de notas para la materia " + (i + 1) + ": ");
            int numNotas = scanner.nextInt();
            notasPorcentajes[i] = new double[numNotas * 2]; // Espacio para notas y porcentajes

            // Pedir notas y porcentajes para cada nota en la materia
            for (int j = 0; j < numNotas; j++) {
                System.out.print("Ingrese la nota " + (j + 1) + " para la materia " + (i + 1) + ": ");
                notasPorcentajes[i][j] = scanner.nextDouble();

                System.out.print("Ingrese el porcentaje para la nota " + (j + 1) + " de la materia " + (i + 1) + ": ");
                notasPorcentajes[i][j + numNotas] = scanner.nextDouble();
            }
        }

        // Calcular el porcentaje total para cada materia
        double[] porcentajeTotal = new double[numMaterias];
        for (int i = 0; i < numMaterias; i++) {
            double sumaPonderada = 0;
            double sumaPorcentajes = 0;

            for (int j = 0; j < notasPorcentajes[i].length / 2; j++) {
                sumaPonderada += notasPorcentajes[i][j] * (notasPorcentajes[i][j + notasPorcentajes[i].length / 2] / 100);
                sumaPorcentajes += notasPorcentajes[i][j + notasPorcentajes[i].length / 2];
            }

            porcentajeTotal[i] = (sumaPonderada / sumaPorcentajes) * 100;
        }

        // Mostrar resultados
        System.out.println("\nResumen de notas y porcentajes por materia:");
        for (int i = 0; i < numMaterias; i++) {
            System.out.println("Materia " + (i + 1) + ":");
            for (int j = 0; j < notasPorcentajes[i].length / 2; j++) {
                System.out.println("  Nota " + (j + 1) + ": " + notasPorcentajes[i][j]);
                System.out.println("  Porcentaje " + (j + 1) + ": " + notasPorcentajes[i][j + notasPorcentajes[i].length / 2] + "%");
            }
            System.out.println("Nota Total: " + porcentajeTotal[i]);
        }

        scanner.close(); //cerrar escaner
    }
}
