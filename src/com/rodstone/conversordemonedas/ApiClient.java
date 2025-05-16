package com.rodstone.conversordemonedas;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ApiClient {

//    private static final Logger logger = Logger.getLogger(ApiClient.class.getName());
//    private final HttpClient client;
//    private final String apiKey;
//
//    // Constructor que recibe la API Key como parámetro
//    public ApiClient(String apiKey) {
//        this.client = HttpClient.newHttpClient();
//        this.apiKey = apiKey;
//    }
//
//    // Método para obtener el cliente HTTP
//    public HttpClient getClient() {
//        return client;
//    }
//
//    // Método para construir la solicitud de conversión de divisas
//    public HttpRequest createConversionRequest(String baseCode, String targetCode) {
//        String uri = String.format("https://v6.exchangerate-api.com/v6/%s/pair/%s/%s", apiKey, baseCode, targetCode);
//        return HttpRequest.newBuilder()
//                .uri(URI.create(uri))
//                .GET()
//                .build();
//    }
//
//    // Método para enviar una solicitud y obtener la respuesta
//    public String sendRequest(HttpRequest request) {
//        try {
//            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//            return response.body();
//        } catch (IOException | InterruptedException e) {
//            logger.log(Level.SEVERE, "Error al enviar la solicitud", e);
//            throw new RuntimeException("Error al enviar la solicitud", e);
//        }
//    }
//
//    // Método para obtener todos los códigos de monedas disponibles
//    public HttpRequest createCodesRequest() {
//        String url = String.format("https://v6.exchangerate-api.com/v6/%s/codes", apiKey);
//        return HttpRequest.newBuilder()
//                .uri(URI.create(url))
//                .GET()
//                .build();
//    }
}
