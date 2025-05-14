//package com.rodstone.conversordemonedas;
//import com.rodstone.conversordemonedas.modelos.ExchangeRateResponse;
//import java.util.Scanner;
//
//public class UserInterface {
//
//    // Método para interactuar con el usuario y hacer la conversión
//    public void startConversion(ExchangeRateResponse exchangeRate) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.printf("Ingresa la cantidad en %s que deseas convertir: ", exchangeRate.getBaseCode());
//
//        // Manejo de posibles errores de entrada
//        double cantidad = 0;
//        boolean validInput = false;
//        while (!validInput) {
//            try {
//                cantidad = Double.parseDouble(scanner.nextLine());
//                validInput = true;
//            } catch (NumberFormatException e) {
//                System.out.println("Por favor, ingresa un número válido.");
//            }
//        }
//
//        // Realizar la conversión
//        double resultado = convertCurrency(cantidad, exchangeRate);
//
//        // Mostrar el resultado
//        System.out.printf("%.2f %s equivalen a %.2f %s\n",
//                cantidad,
//                exchangeRate.getBaseCode(),
//                resultado,
//                exchangeRate.getTargetCode());
//    }
//}
