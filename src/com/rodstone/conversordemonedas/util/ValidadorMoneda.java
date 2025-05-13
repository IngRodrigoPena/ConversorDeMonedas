package com.rodstone.conversordemonedas.util;

public class ValidadorMoneda {

    public static boolean esCodigoValido(String codigo, Set<String> codigosValidos) {
        return codigosValidos.contains(codigo.toUpperCase());
    }
}
