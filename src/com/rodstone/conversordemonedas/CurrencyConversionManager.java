package com.rodstone.conversordemonedas;

import com.google.gson.Gson;
import com.rodstone.conversordemonedas.modelos.ConversionResponse;

import java.net.http.HttpRequest;

public class CurrencyConversionManager {

    private final ApiClient apiClient;
    private final Gson gson;

    // ✅ Constructor que recibe el ApiClient y Gson desde fuera
    public CurrencyConversionManager(ApiClient apiClient, Gson gson) {
        this.apiClient = apiClient;
        this.gson = gson;
    }

    public double realizarConversion(String baseCode, String targetCode, double amount) {
        HttpRequest request = apiClient.createRequest(baseCode, targetCode);
        String json = apiClient.sendRequest(request);

        ConversionResponse response = gson.fromJson(json, ConversionResponse.class);
        return amount * response.getConversionRate();
    }
}
