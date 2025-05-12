package com.rodstone.conversordemonedas;

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
    }
}
