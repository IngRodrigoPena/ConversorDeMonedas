package com.rodstone.conversordemonedas.modelos;

//Esta clase se encargará de representar los datos JSON
// que devuelve la API cuando se hace una conversión
// entre dos  monedas

public class ConversionResponse {
    private String result;
    private String base_code;
    private String target_code;
    private double conversion_rate;
    //getters
    public String getBase_code() {
        return base_code;
    }

    public String getTarget_code() {
        return target_code;
    }

    public String getResult() {
        return result;
    }

    public double getConversionRate() {
        return conversion_rate;
    }



    //setters
}
