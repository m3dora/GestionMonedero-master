
package Aplicacion;

import Libreria.Monedero;
import java.util.Scanner;

public class GestionMonedero {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Monedero objMonedero = new Monedero();
        int option;

        do {
            mostrarMenu();
            option = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (option) {
                case 1:
                    consultarSaldo(objMonedero);
                    break;
                case 2:
                    cargarSaldo(objMonedero);
                    break;
                case 3:
                    pagarMonto(objMonedero);
                    break;
                case 4:
                    cambiarEstadoMonedero(objMonedero);
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida, por favor intenta nuevamente.");
                    break;
            }
        } while (option != 5);

        scanner.close();
    }

    public static void mostrarMenu() {
        System.out.println("\n--- MENÚ DE GESTIÓN DEL MONEDERO ---");
        System.out.println("1. Consultar saldo");
        System.out.println("2. Cargar saldo");
        System.out.println("3. Pagar monto");
        System.out.println("4. Cambiar estado del monedero");
        System.out.println("5. Salir");
        System.out.println("Por favor, selecciona una opción:");
    }

    public static void consultarSaldo(Monedero objMonedero) {
        int saldoTotal = objMonedero.consultarSaldo();
        System.out.println("Saldo total disponible: " + saldoTotal);
    }

    public static void cargarSaldo(Monedero objMonedero) {
        System.out.println("Por favor, ingresa el monto a cargar:");
        int monto = scanner.nextInt();
        if (objMonedero.cargar(monto)) {
            System.out.println("Saldo cargado correctamente.");
        } else {
            System.out.println("Error al cargar el saldo. El monto debe ser mayor que 0.");
        }
        mostrarResultados(objMonedero);
    }

    public static void pagarMonto(Monedero objMonedero) {
        System.out.println("Por favor, ingresa el monto a pagar:");
        int monto = scanner.nextInt();
        if (objMonedero.pagar(monto)) {
            System.out.println("Pago realizado con éxito.");
        } else {
            System.out.println("Error al realizar el pago. Verifica que el monto sea positivo y que haya suficiente saldo.");
        }
        mostrarResultados(objMonedero);
    }

    public static void cambiarEstadoMonedero(Monedero objMonedero) {
        System.out.println("Por favor, ingresa el nuevo estado (habilitada/deshabilitada):");
        String nuevoEstado = scanner.nextLine();
        if (objMonedero.cambiarEstado(nuevoEstado)) {
            System.out.println("Estado del monedero actualizado a: " + nuevoEstado);
        } else {
            System.out.println("Error al actualizar el estado. Solo se aceptan los valores 'habilitada' o 'deshabilitada'.");
        }
    }

    public static void mostrarResultados(Monedero objMonedero) {
        System.out.println("\n--- Información del Monedero ---");
        System.out.println("Número: " + objMonedero.getNumero());
        System.out.println("Saldo de Emergencia: " + objMonedero.getSaldoEmergencia());
        System.out.println("Saldo Anterior: " + objMonedero.getSaldoAnterior());
        System.out.println("Saldo Actual: " + objMonedero.getSaldoActual());
        System.out.println("Estado: " + objMonedero.getEstado());
    }
}
