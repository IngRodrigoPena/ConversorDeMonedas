package com.rodstone.conversordemonedas;
import com.rodstone.conversordemonedas.modelos.ExchangeRateResponse;
import java.util.Scanner;

public class CurrencyConverter {

    //Ahora que ya puede obtener la tasa de cambio (conversion_rate),
    //este metodo permite al usuario ingresar una cantidad,
    //y calcular el valor convertido usando esa tasa.
    public void convertCurrency(ExchangeRateResponse exchangeRate) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Ingresa la cantidad en %s que deseas convertir: ", exchangeRate.getBaseCode());
        double cantidad = Double.parseDouble(scanner.nextLine());
        double resultado = cantidad * exchangeRate.getConversionRate();

        System.out.printf("%.2f %s equivalen a %.2f %s\n",
                cantidad,
                exchangeRate.getBaseCode(),
                resultado,
                exchangeRate.getTargetCode());
    }
}
