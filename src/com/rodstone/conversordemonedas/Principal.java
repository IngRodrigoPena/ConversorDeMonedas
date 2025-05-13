package com.rodstone.conversordemonedas;

import com.google.gson.Gson;
import com.rodstone.conversordemonedas.modelos.ConversionResponse;
import com.rodstone.conversordemonedas.modelos.SupportedCodesResponse;
import java.net.http.HttpRequest;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;

import static com.rodstone.conversordemonedas.util.ValidadorMoneda.esCodigoValido;

//Se reemplaza el menú de opciones fijas por una versión más flexible,
//donde el usuario pueda ingresar los códigos de las monedas que desea convertir

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ApiClient apiClient = new ApiClient();
        Gson gson = new Gson();
        CurrencyConverter converter = new CurrencyConverter();
        Set<String> codigosValidos = null;

        //Muestra las monedas disponibles
        System.out.println("=== Monedas Disponibles ===");
        try{
            HttpRequest codesRequest = apiClient.createCodesRequest();
            String codesJson  = apiClient.sendRequest(codesRequest);
            SupportedCodesResponse codesResponse = gson.fromJson(codesJson, SupportedCodesResponse.class);

            //set de codigos validos
            //Set<String> codigosValidos = new HashSet<>();
            codigosValidos = new HashSet<>();
            for (List<String> codePair : codesResponse.getSupportedCodes()) {
                codigosValidos.add(codePair.get(0));
            }


            //Mostrar en columnas
            List<List<String>> codes = codesResponse.getSupportedCodes();
            int columnas =3;
            //System.out.println("=== Monedas Disponibles ===");
            for(int i =0;i<codes.size();i++){
                List<String> codePair = codes.get(i);
                System.out.printf("%-7s - %-25s", codePair.get(0),codePair.get(1));
                if((i+1) %columnas == 0){
                    System.out.println();
                }
            }
            System.out.println("\nTambién puedes consultar la lista completa aquí:");
            System.out.println("https://www.exchangerate-api.com/docs/supported-currencies");

//            System.out.println("=== Monedas Disponibles ===");
//            for(List<String> codePair : codesResponse.getSupportedCodes()){
//                System.out.printf("%s - %s\n",codePair.get(0),codePair.get(1));
//            }
        }catch (Exception e){
            System.out.println("Error al obtener las monedas: " + e.getMessage());
            return;
        }

        //Verificando que codigosvalidos no este vacio o null
        // Verifica si el Set fue creado correctamente y tiene datos
        if (codigosValidos == null || codigosValidos.isEmpty()) {
            System.out.println("❌ No se pudieron cargar los códigos de moneda. Intenta más tarde.");
            return; // o System.exit(1);
        }

        boolean continuar = true;
        while (continuar) {
            try {
                System.out.println("Bienvenido al conversor de monedas. " +
                        "\nSolo necesitas ingresar la moneda que tienes, " +
                        "\nla moneda a la que quieres convertir y el monto.");
                System.out.print("\nIngresa la moneda base (por ejemplo, USD):");
                String baseCode = scanner.nextLine().toUpperCase();

                System.out.print("Ingresa la moneda destino (por ejemplo, JPY):");
                String targetCode = scanner.nextLine().toUpperCase();

                System.out.print("Ingrese el importe a convertir:");
                double amount = Double.parseDouble(scanner.nextLine());

                //validando que el codigo de la moneda sea valido
                if (!esCodigoValido(baseCode, codigosValidos) || !esCodigoValido(targetCode, codigosValidos)) {
                    System.out.println("⚠️ Uno o ambos códigos ingresados no son válidos. Intenta de nuevo.\n");
                } else {
                    System.out.println("✅ Códigos válidos. Procediendo con la conversión...");
                    HttpRequest conversionRequest = apiClient.createRequest(baseCode, targetCode);
                    String conversionJson = apiClient.sendRequest(conversionRequest);

                    ConversionResponse response = gson.fromJson(conversionJson, ConversionResponse.class);
                    double tasa = response.getConversionRate();
                    double resultado = amount * tasa;

                    System.out.printf("\n%.2f %s equivalen a %.2f%s\n", amount, baseCode, resultado, targetCode);
                    System.out.println();
                }
            } catch (Exception e) {
                System.out.println("Ocurrio un error durante la converison: " + e.getMessage());
            }

            System.out.print("\n ¿Deseas realizar otra conversion? (s/n):");
            String respuesta = scanner.nextLine().toLowerCase();
            if(!respuesta.equals("s")){
                continuar = false;
            }
    }
        System.out.println("\n Gracias por usar el conversor de monedas.");
        scanner.close();
    }
}
