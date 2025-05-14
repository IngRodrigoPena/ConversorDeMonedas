package com.rodstone.conversordemonedas.util;

import java.util.Set;

public class CurrencyValidator {
    public static boolean esCodigoValido(String codigo, Set<String> codigosValidos) {
        return codigosValidos.contains(codigo.toUpperCase());
    }
}


