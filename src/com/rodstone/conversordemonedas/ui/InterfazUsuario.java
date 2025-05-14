package com.rodstone.conversordemonedas.ui;

import java.util.Scanner;

public class InterfazUsuario {
    private final Scanner scanner;

    public InterfazUsuario() {
        this.scanner = new Scanner(System.in);
    }

    public String pedirCodigoMoneda(String tipo) {
        System.out.printf("Ingresa la moneda %s (por ejemplo, USD): ", tipo);
        return scanner.nextLine().trim().toUpperCase();
    }

    public double pedirCantidad() {
        System.out.print("Ingresa la cantidad a convertir: ");
        try {
            return Double.parseDouble(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("⚠️ Cantidad inválida. Asegúrate de ingresar un número.");
            return -1;
        }
    }

    public void mostrarResultado(double cantidad, String base, double resultado, String destino, double tasa) {
        System.out.printf("\n%.2f %s equivalen a %.2f %s (Tasa: %.4f)\n\n",
                cantidad, base, resultado, destino, tasa);
    }

    public void mostrarError(String mensaje) {
        System.out.println("❌ " + mensaje);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public boolean preguntarOtraConversion() {
        System.out.print("¿Deseas realizar otra conversión? (s/n): ");
        String respuesta = scanner.nextLine().trim().toLowerCase();
        return respuesta.equals("s");
    }

    public void mostrarEnlaceMonedas(String apiKey) {
        String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/codes";
        System.out.println("\n🌍 Consulta las monedas disponibles aquí: " + url + "\n");
    }

    public void cerrar() {
        scanner.close();
    }
}