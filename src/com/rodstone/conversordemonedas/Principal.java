package com.rodstone.conversordemonedas;

//import com.google.gson.Gson;
//import com.rodstone.conversordemonedas.modelos.ExchangeRateResponse;
//import com.rodstone.conversordemonedas.modelos.SupportedCodesResponse;
//
//import java.net.http.HttpRequest;
//import java.util.List;
//import java.util.Scanner;

import com.google.gson.Gson;
import com.rodstone.conversordemonedas.modelos.SupportedCodesResponse;

import java.net.http.HttpRequest;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ApiClient apiClient = new ApiClient();
        Gson gson = new Gson();
        CurrencyConverter converter = new CurrencyConverter();

        //Muestra las monedas disponibles
        try{
            HttpRequest codesRequest = apiClient.createCodesRequest();
            String codesJson  = apiClient.sendRequest(codesRequest);
            SupportedCodesResponse codesResponse = gson.fromJson(codesJson, SupportedCodesResponse.class);

            System.out.println("=== Monedas Disponibles ===");
            for(List<String> codePair : codesResponse.getSupportedCodes()){
                System.out.printf("%s - %s\n",codePair.get(0),codePair.get(1));
            }
        }catch (Exception e){
            System.out.println("Error al obtener las monedas: " + e.getMessage());
            return;
        }

        boolean continuar = true;
        while(continuar){
            System.out.print("\nIngresa la moneda base (por ejemplo, USD:");
            String baseCode = scanner.nextLine().toUpperCase();

            System.out.print("Ingresa la moneda destino (por ejemplo, JPY:");
            String targetCode = scanner.nextLine().toUpperCase();

            System.out.print("Ingrese el importe a convertir:");
            double amount = Double.parseDouble(scanner.nextLine());

            HttpRequest conversionRequest = apiClient.createRequest(baseCode,targetCode);
            String conversionJson = apiClient.sendRequest(conversionRequest);

            ConversionResponse  response = gson.fromJson(conversionJson,ConversionResponse.class);
            double tasa = response.getConversionRate();
            double resultado = amount*tasa;

            System.out.printf("\n%.2f %s equivalen a %.2f%s\n", amount,baseCode,resultado,targetCode);
        }
    }
//        Scanner scanner = new Scanner(System.in);
//        ApiClient apiClient = new ApiClient();
//        Gson gson = new Gson();
//        CurrencyConverter converter = new CurrencyConverter();
//
//        boolean continuar = true;
//
//        //mostrando los codigos de todas las monedas disponibles
//        HttpRequest codesRequest = apiClient.createCodesRequest();
//        String codesJson = apiClient.sendRequest(codesRequest);
//
//        SupportedCodesResponse codesResponse = gson.fromJson(codesJson, SupportedCodesResponse.class);
//
//        System.out.println("Monedas disponibles:");
//        for (List<String> codePair : codesResponse.getSupportedCodes()) {
//            System.out.printf("%s - %s\n", codePair.get(0), codePair.get(1));
//        }
//
//
//        //Implementa un menú interactivo en consola donde el usuario pueda elegir
//        // qué conversión desea realizar (ej. de USD a MXN, de MXN a USD, etc.),
//        //o salir del programa.
//        while(continuar){
//            System.out.println("\n==== Conversor de Monedas ====");
//            System.out.println("1. USD a MXN");
//            System.out.println("2. MXN a USD");
//            System.out.println("3. USD a EUR");
//            System.out.println("4. EUR a USD");
//            System.out.println("5. Salir");
//            System.out.print("Selecciona una opcion:");
//            int opcion = Integer.parseInt(scanner.nextLine());
//
//            if(opcion == 5){
//                continuar = false;
//                System.out.println("Fin del programa...Hasta luego!");
//                continue;
//            }
//
//            String base = "";
//            String destino = "";
//
//            switch(opcion){
//                case 1->{
//                    base    = "USD";
//                    destino = "MXN";
//                }
//                case 2->{
//                    base    = "MXN";
//                    destino = "USD";
//                }
//                case 3->{
//                    base    = "USD";
//                    destino = "EUR";
//                }case 4->{
//                    base    = "EUR";
//                    destino = "USD";
//                }
//                default -> {
//                    System.out.println("Opcion Invalida");
//                    continue;
//                }
//            }
//
//            try{
//                HttpRequest request = apiClient.createRequest(base,destino);
//                String jsonResponse = apiClient.sendRequest(request);
//                ExchangeRateResponse exchangeRate = gson.fromJson(jsonResponse, ExchangeRateResponse.class);
//                converter.convertCurrency(exchangeRate);
//            } catch (Exception e) {
//                System.out.println("Ocurrio un error al procesar la solicitud: " + e.getMessage());
//            }
//        }
//        scanner.close();
//    }
}
