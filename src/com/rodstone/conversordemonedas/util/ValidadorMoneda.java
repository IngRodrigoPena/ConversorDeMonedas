package com.rodstone.conversordemonedas.util;

import java.util.Set;

public class ValidadorMoneda {

    private Set<String> codigosValidos;

    // Constructor para inyectar los códigos válidos
    public ValidadorMoneda(Set<String> codigosValidos) {
        this.codigosValidos = codigosValidos;
    }

    // Método para validar si el código es válido
    public boolean esCodigoValido(String codigo) {
        return codigosValidos.contains(codigo.toUpperCase());
    }
}
