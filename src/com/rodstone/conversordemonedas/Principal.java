// com.rodstone.conversordemonedas.Principal.java
package com.rodstone.conversordemonedas;

import com.rodstone.conversordemonedas.logica.ConversorDeMoneda;
import com.rodstone.conversordemonedas.modelos.ConversionResponse;
import com.rodstone.conversordemonedas.modelos.SupportedCodesResponse;
import com.rodstone.conversordemonedas.servicio.ExchangeRateService;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        //String apiKey = "TU_API_KEY"; // Reemplaza con tu API key real
        String apiKey = "59fa01b6e1764f26115f52fa"; 

        Scanner scanner = new Scanner(System.in);

        ExchangeRateService servicio = new ExchangeRateService(apiKey);
        ConversorDeMoneda conversor = new ConversorDeMoneda();

        SupportedCodesResponse codigos = servicio.obtenerCodigosSoportados();
        if (codigos == null || !"success".equalsIgnoreCase(codigos.getResult())) {
            System.out.println("No se pudieron obtener los códigos de monedas.");
            return;
        }

        System.out.println("Conversor de Monedas");
        System.out.print("Moneda base (por ejemplo, USD): ");
        String base = scanner.nextLine().toUpperCase();

        System.out.print("Moneda destino (por ejemplo, MXN): ");
        String destino = scanner.nextLine().toUpperCase();

        System.out.print("Cantidad a convertir: ");
        double cantidad;



        try {
            cantidad = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Cantidad inválida.");
            return;
        }

        ConversionResponse conversion = servicio.obtenerConversion(base, destino);
        if (conversion == null || !"success".equalsIgnoreCase(conversion.getResult())) {
            System.out.println("No se pudo obtener la tasa de conversión.");
            return;
        }

        double resultado = conversor.convertir(cantidad, conversion);
        System.out.printf("%.2f %s equivalen a %.2f %s (Tasa: %.4f)\n",
                cantidad, base, resultado, destino, conversion.getConversionRate());
    }
}



