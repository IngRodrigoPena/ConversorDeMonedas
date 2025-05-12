package com.rodstone.conversordemonedas.modelos;

//Esta clase modelo representara la respuesta
//se usara para convertir el JSON en un objeto Java
// para poder trabajar más fácilmente con los datos.
public class ExchangeRateResponse {
    private String result;
    private String base_code;
    private String target_code;
    private double conversion_rate;
    //getters
    public String getResult() {
        return result;
    }

    public String getBaseCode() {
        return base_code;
    }

    public String getTargetCode() {
        return target_code;
    }

    public double getConversionRate() {
        return conversion_rate;
    }
}
