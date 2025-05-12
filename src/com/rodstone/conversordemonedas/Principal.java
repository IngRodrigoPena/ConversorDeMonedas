package com.rodstone.conversordemonedas;

import com.google.gson.Gson;
import com.rodstone.conversordemonedas.modelos.ExchangeRateResponse;

import java.net.http.HttpRequest;

public class Principal {
    public static void main(String[] args) {
        System.out.println("Conversor de Monedas iniciado");

        //construye una solicitud, al ejecutar esa solicitud con el HttpClient
        //obtiene la respuesta desde la API.
        ApiClient apiClient = new ApiClient();
        HttpRequest request = apiClient.createRequest("USD", "MXN");
        String jsonResponse = apiClient.sendRequest(request);
        System.out.println(jsonResponse);

        //Analizando la respuesta de la API
        Gson gson = new Gson();
        ExchangeRateResponse exchangeRate = gson.fromJson(jsonResponse, ExchangeRateResponse.class);

        System.out.printf("1 %s equivale a %.2f %s\n",
                exchangeRate.getBaseCode(),
                exchangeRate.getConversionRate(),
                exchangeRate.getTargetCode());

        //Una vez que se obtiene la respuesta JSON se convierte a un objeto ExchangeRateResponse
        // Crear instancia de la clase de conversión
        CurrencyConverter converter = new CurrencyConverter();
        converter.convertCurrency(exchangeRate);
    }
}
