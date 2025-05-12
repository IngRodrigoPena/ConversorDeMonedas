package com.rodstone.conversordemonedas;

import com.google.gson.Gson;
import com.rodstone.conversordemonedas.modelos.ExchangeRateResponse;
import java.net.http.HttpRequest;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ApiClient apiClient = new ApiClient();
        Gson gson = new Gson();
        CurrencyConverter converter = new CurrencyConverter();

        boolean continuar = true;

        //Implementa un menú interactivo en consola donde el usuario pueda elegir
        // qué conversión desea realizar (ej. de USD a MXN, de MXN a USD, etc.),
        //o salir del programa.
        while(continuar){
            System.out.println("\n==== Conversor de Monedas ====");
            System.out.println("1. USD a MXN");
            System.out.println("2. MXN a USD");
            System.out.println("3. USD a EUR");
            System.out.println("4. EUR a USD");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opcion:");
            int opcion = Integer.parseInt(scanner.nextLine());

            if(opcion == 5){
                continuar = false;
                System.out.println("Fin del programa...Hasta luego!");
                continue;
            }

            String base = "";
            String destino = "";

            switch(opcion){
                case 1->{
                    base    = "USD";
                    destino = "MXN";
                }
                case 2->{
                    base    = "MXN";
                    destino = "USD";
                }
                case 3->{
                    base    = "USD";
                    destino = "EUR";
                }case 4->{
                    base    = "EUR";
                    destino = "USD";
                }
                default -> {
                    System.out.println("Opcion Invalida");
                    continue;
                }
            }

            try{
                HttpRequest request = apiClient.createRequest(base,destino);
                String jsonResponse = apiClient.sendRequest(request);
                ExchangeRateResponse exchangeRate = gson.fromJson(jsonResponse, ExchangeRateResponse.class);
                converter.convertCurrency(exchangeRate);
            } catch (Exception e) {
                System.out.println("Ocurrio un error al procesar la solicitud: " + e.getMessage());
            }
        }
        scanner.close();
    }
}
