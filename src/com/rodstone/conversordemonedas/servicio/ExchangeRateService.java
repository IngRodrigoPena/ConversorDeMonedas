// com.rodstone.conversordemonedas.servicio.ExchangeRateService.java
package com.rodstone.conversordemonedas.servicio;

import com.google.gson.Gson;
import com.rodstone.conversordemonedas.modelos.ConversionResponse;
import com.rodstone.conversordemonedas.modelos.SupportedCodesResponse;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.io.IOException;

public class ExchangeRateService {
    private final HttpClient client;
    private final Gson gson;
    private final String apiKey;

    public ExchangeRateService(String apiKey) {
        this.client = HttpClient.newHttpClient();
        this.gson = new Gson();
        this.apiKey = apiKey;
    }

    public SupportedCodesResponse obtenerCodigosSoportados() {
        String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/codes";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return gson.fromJson(response.body(), SupportedCodesResponse.class);
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al obtener códigos: " + e.getMessage());
            return null;
        }
    }

    public ConversionResponse obtenerConversion(String baseCode, String targetCode) {
        String url = String.format("https://v6.exchangerate-api.com/v6/%s/pair/%s/%s", apiKey, baseCode, targetCode);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return gson.fromJson(response.body(), ConversionResponse.class);
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al convertir moneda: " + e.getMessage());
            return null;
        }
    }
}

