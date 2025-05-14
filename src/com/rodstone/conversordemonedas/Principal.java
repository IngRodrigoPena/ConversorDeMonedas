package com.rodstone.conversordemonedas;

import com.rodstone.conversordemonedas.logica.ConversorDeMoneda;
import com.rodstone.conversordemonedas.modelos.ConversionResponse;
import com.rodstone.conversordemonedas.modelos.SupportedCodesResponse;
import com.rodstone.conversordemonedas.servicio.ExchangeRateService;
import com.rodstone.conversordemonedas.ui.InterfazUsuario;

public class Principal {
    public static void main(String[] args) {
        //String apiKey = "TU_API_KEY"; // Reemplaza por tu clave real
        String apiKey = "59fa01b6e1764f26115f52fa";
        ExchangeRateService servicio = new ExchangeRateService(apiKey);
        ConversorDeMoneda conversor = new ConversorDeMoneda();
        InterfazUsuario ui = new InterfazUsuario();

        SupportedCodesResponse codigos = servicio.obtenerCodigosSoportados();
        if (codigos == null || !"success".equalsIgnoreCase(codigos.getResult())) {
            ui.mostrarError("No se pudieron obtener los códigos de monedas.");
            return;
        }
        //mostrar monedas disponibles en la API
        ui.mostrarEnlaceMonedas(apiKey);

        boolean continuar = true;
        while (continuar) {
            String base = ui.pedirCodigoMoneda("base");
            String destino = ui.pedirCodigoMoneda("destino");
            double cantidad = ui.pedirCantidad();

            if (cantidad <= 0) {
                ui.mostrarError("Cantidad inválida. Intenta de nuevo.");
                continue;
            }

            ConversionResponse conversion = servicio.obtenerConversion(base, destino);
            if (conversion == null || !"success".equalsIgnoreCase(conversion.getResult())) {
                ui.mostrarError("No se pudo obtener la tasa de conversión.");
                continue;
            }

            double resultado = conversor.convertir(cantidad, conversion);
            ui.mostrarResultado(cantidad, base, resultado, destino, conversion.getConversionRate());

            continuar = ui.preguntarOtraConversion();
        }

        ui.mostrarMensaje("Gracias por usar el conversor de monedas.");
        ui.cerrar();
    }
}



