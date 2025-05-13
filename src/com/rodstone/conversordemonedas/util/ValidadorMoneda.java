package com.rodstone.conversordemonedas.util;

import java.util.Set;

public class ValidadorMoneda {

    //Valida se el codigo proporcionado es valido
    public static boolean esCodigoValido(String codigo, Set<String> codigosValidos) {
        return codigosValidos.contains(codigo.toUpperCase());
    }
}
