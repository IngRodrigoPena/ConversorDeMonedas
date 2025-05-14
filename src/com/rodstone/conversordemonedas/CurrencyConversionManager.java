package com.rodstone.conversordemonedas;

import com.google.gson.Gson;
import com.rodstone.conversordemonedas.modelos.ConversionResponse;

import java.net.http.HttpRequest;

public class CurrencyConversionManager {
    private final ApiClient apiClient;
    private final Gson gson;

    public CurrencyConversionManager() {
        this.apiClient = new ApiClient();
        this.gson = new Gson();
    }

    // Realiza la conversión de monedas
    public double realizarConversion(String baseCode, String targetCode, double amount) {
        try {
            HttpRequest conversionRequest = apiClient.createRequest(baseCode, targetCode);
            String conversionJson = apiClient.sendRequest(conversionRequest);
            ConversionResponse response = gson.fromJson(conversionJson, ConversionResponse.class);
            double tasa = response.getConversionRate();
            return amount * tasa;
        } catch (Exception e) {
            throw new RuntimeException("Error al realizar la conversión: " + e.getMessage(), e);
        }
    }
}
