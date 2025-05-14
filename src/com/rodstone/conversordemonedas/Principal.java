package com.rodstone.conversordemonedas;

import com.rodstone.conversordemonedas.modelos.SupportedCodesResponse;
import com.google.gson.Gson;
import java.net.http.HttpRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Principal {

    public static void main(String[] args) {
        ApiClient apiClient = new ApiClient();
        Gson gson = new Gson();
        CurrencyConverterUI ui = new CurrencyConverterUI();
        CurrencyConversionManager manager = new CurrencyConversionManager();
        Set<String> codigosValidos = new HashSet<>();

        // Mostrar las monedas disponibles
        ui.mostrarMensaje("=== Monedas Disponibles ===");
        try {
            HttpRequest codesRequest = apiClient.createCodesRequest();
            String codesJson = apiClient.sendRequest(codesRequest);
            SupportedCodesResponse codesResponse = gson.fromJson(codesJson, SupportedCodesResponse.class);

            for (List<String> codePair : codesResponse.getSupportedCodes()) {
                codigosValidos.add(codePair.get(0));
            }

            // Mostrar las monedas disponibles
            for (int i = 0; i < codesResponse.getSupportedCodes().size(); i++) {
                List<String> codePair = codesResponse.getSupportedCodes().get(i);
                System.out.printf("%-7s - %-25s", codePair.get(0), codePair.get(1));
                if ((i + 1) % 3 == 0) {
                    System.out.println();
                }
            }

        } catch (Exception e) {
            ui.mostrarMensaje("Error al obtener las monedas: " + e.getMessage());
            return;
        }

        boolean continuar = true;
        while (continuar) {
            try {
                // Obtener entrada del usuario
                String baseCode = ui.obtenerCodigoMoneda("base");
                String targetCode = ui.obtenerCodigoMoneda("destino");
                double amount = ui.obtenerCantidad();

                // Validar códigos
                if (!CurrencyValidator.esCodigoValido(baseCode, codigosValidos) || !CurrencyValidator.esCodigoValido(targetCode, codigosValidos)) {
                    ui.mostrarMensaje("⚠️ Uno o ambos códigos ingresados no son válidos. Intenta de nuevo.");
                } else {
                    // Realizar la conversión
                    double resultado = manager.realizarConversion(baseCode, targetCode, amount);
                    ui.mostrarMensaje(String.format("%.2f %s equivalen a %.2f %s", amount, baseCode, resultado, targetCode));
                }
            } catch (Exception e) {
                ui.mostrarMensaje("Ocurrió un error durante la conversión: " + e.getMessage());
            }

            // Preguntar si desea continuar
            continuar = ui.deseaContinuar();
        }

        ui.mostrarMensaje("\nGracias por usar el conversor de monedas.");
        ui.cerrarScanner();
    }
}


