package com.rodstone.conversordemonedas.modelos;

import java.util.Map;

// usando la URI GET https://v6.exchangerate-api.com/v6/YOUR_API_KEY/codes
//Obtendra desde la API todas las monedas disponibles
//para mostrarle al usaurio un listado actualizado y dinamico
public class SupportedCodesResponse {

    private String result;

    // Usamos un mapa para representar el código y su nombre
    private Map<String, String> supportedCodes;

    // Getters
    public String getResult() {
        return result;
    }

    public Map<String, String> getSupportedCodes() {
        return supportedCodes;
    }

    // Setters
    public void setResult(String result) {
        this.result = result;
    }

    public void setSupportedCodes(Map<String, String> supportedCodes) {
        this.supportedCodes = supportedCodes;
    }

    // Constructor
    public SupportedCodesResponse(String result, Map<String, String> supportedCodes) {
        this.result = result;
        this.supportedCodes = supportedCodes;
    }

    // Constructor vacío (para Gson)
    public SupportedCodesResponse() {}

    @Override
    public String toString() {
        return "SupportedCodesResponse{" +
                "result='" + result + '\'' +
                ", supportedCodes=" + supportedCodes +
                '}';
    }
}


//import java.util.List;
//
//// usando la URI GET https://v6.exchangerate-api.com/v6/YOUR_API_KEY/codes
////Obtendra desde la API todas las monedas disponibles
////para mostrarle al usaurio un listado actualizado y dinamico
//public class SupportedCodesResponse {
//    private String result;
//    private List<List<String>> supported_codes;
//
//    public String getResult() {
//        return result;
//    }
//
//    public List<List<String>> getSupportedCodes() {
//        return supported_codes;
//    }
//}
