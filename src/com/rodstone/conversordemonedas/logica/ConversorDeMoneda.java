// com.rodstone.conversordemonedas.logica.ConversorDeMoneda.java
package com.rodstone.conversordemonedas.logica;

import com.rodstone.conversordemonedas.modelos.ConversionResponse;

public class ConversorDeMoneda {
    public double convertir(double cantidad, ConversionResponse datosConversion) {
        return cantidad * datosConversion.getConversionRate();
    }
}


