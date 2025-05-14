package com.rodstone.conversordemonedas;
import java.util.Scanner;

public class CurrencyConverterUI {
    private final Scanner scanner;

    public CurrencyConverterUI() {
        this.scanner = new Scanner(System.in);
    }

    // Muestra las opciones y obtiene la entrada del usuario
    public String obtenerCodigoMoneda(String tipo) {
        System.out.print("Ingresa la " + tipo + " moneda (por ejemplo, USD): ");
        return scanner.nextLine().toUpperCase();
    }

    public double obtenerCantidad() {
        System.out.print("Ingrese el importe a convertir: ");
        return Double.parseDouble(scanner.nextLine());
    }

    public boolean deseaContinuar() {
        System.out.print("\n¿Deseas realizar otra conversión? (s/n): ");
        String respuesta = scanner.nextLine().toLowerCase();
        return respuesta.equals("s");
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void cerrarScanner() {
        scanner.close();
    }
}


