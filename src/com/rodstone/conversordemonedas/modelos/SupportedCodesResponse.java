package com.rodstone.conversordemonedas.modelos;

import java.util.List;

// usando la URI GET https://v6.exchangerate-api.com/v6/YOUR_API_KEY/codes
//Obtendra desde la API todas las monedas disponibles
//para mostrarle al usaurio un listado actualizado y dinamico
public class SupportedCodesResponse {
    private String result;
    private List<List<String>> supported_codes;

    public String getResult() {
        return result;
    }

    public List<List<String>> getSupportedCodes() {
        return supported_codes;
    }
}
