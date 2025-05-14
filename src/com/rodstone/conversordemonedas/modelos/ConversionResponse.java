package com.rodstone.conversordemonedas.modelos;

import com.google.gson.annotations.SerializedName;

//Esta clase se encargará de representar los datos JSON
// que devuelve la API cuando se hace una conversión
// entre dos  monedas

public class ConversionResponse {

    private String result;

    @SerializedName("base_code")
    private String baseCode;

    @SerializedName("target_code")
    private String targetCode;

    @SerializedName("conversion_rate")
    private double conversionRate;

    // Constructor
    public ConversionResponse(String result, String baseCode, String targetCode, double conversionRate) {
        this.result = result;
        this.baseCode = baseCode;
        this.targetCode = targetCode;
        this.conversionRate = conversionRate;
    }

    // Constructor vacío (requerido por Gson)
    public ConversionResponse() {}

    // Getters
    public String getResult() {
        return result;
    }

    public String getBaseCode() {
        return baseCode;
    }

    public String getTargetCode() {
        return targetCode;
    }

    public double getConversionRate() {
        return conversionRate;
    }

    // Setters
    public void setResult(String result) {
        this.result = result;
    }

    public void setBaseCode(String baseCode) {
        this.baseCode = baseCode;
    }

    public void setTargetCode(String targetCode) {
        this.targetCode = targetCode;
    }

    public void setConversionRate(double conversionRate) {
        this.conversionRate = conversionRate;
    }

    // Método útil para depurar
    @Override
    public String toString() {
        return "ConversionResponse{" +
                "result='" + result + '\'' +
                ", baseCode='" + baseCode + '\'' +
                ", targetCode='" + targetCode + '\'' +
                ", conversionRate=" + conversionRate +
                '}';
    }
}
